package com.example.collegedirectory.service;

import com.example.collegedirectory.model.Faculty;
import com.example.collegedirectory.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    /**
     * Retrieve all faculties from the database.
     *
     * @return List of faculties
     */
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    /**
     * Retrieve a faculty by its ID.
     *
     * @param id The ID of the faculty
     * @return Optional of faculty
     */
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    /**
     * Create a new faculty.
     *
     * @param faculty The faculty to be created
     * @return The created faculty
     */
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    /**
     * Update an existing faculty.
     *
     * @param id       The ID of the faculty to be updated
     * @param faculty  The updated faculty data
     * @return Optional of updated faculty
     */
    public Optional<Faculty> updateFaculty(Long id, Faculty faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return Optional.of(facultyRepository.save(faculty));
        }
        return Optional.empty();
    }

    /**
     * Delete a faculty by its ID.
     *
     * @param id The ID of the faculty to be deleted
     * @return True if deletion was successful, false otherwise
     */
    public boolean deleteFaculty(Long id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
