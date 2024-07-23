package com.example.collegedirectory.controller;

import com.example.collegedirectory.model.Faculty;
import com.example.collegedirectory.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    /**
     * Get all faculties.
     *
     * @return ResponseEntity with list of faculties and HTTP status
     */
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    /**
     * Get a faculty by ID.
     *
     * @param id the ID of the faculty
     * @return ResponseEntity with the faculty and HTTP status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable("id") Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Create a new faculty.
     *
     * @param faculty the faculty to be created
     * @return ResponseEntity with the created faculty and HTTP status
     */
    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return new ResponseEntity<>(createdFaculty, HttpStatus.CREATED);
    }

    /**
     * Update an existing faculty.
     *
     * @param id the ID of the faculty to be updated
     * @param faculty the updated faculty data
     * @return ResponseEntity with the updated faculty and HTTP status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        Optional<Faculty> updatedFaculty = facultyService.updateFaculty(id, faculty);
        return updatedFaculty.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Delete a faculty by ID.
     *
     * @param id the ID of the faculty to be deleted
     * @return ResponseEntity with HTTP status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable("id") Long id) {
        boolean isDeleted = facultyService.deleteFaculty(id);
        return isDeleted ? ResponseEntity.noContent().build()
                         : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
