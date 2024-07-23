package com.example.collegedirectory.service;

import com.example.collegedirectory.model.Student;
import com.example.collegedirectory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Retrieve all students from the database.
     *
     * @return a list of students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieve a student by its ID.
     *
     * @param id the ID of the student to retrieve.
     * @return an Optional containing the student if found, otherwise empty.
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Create or update a student in the database.
     *
     * @param student the student to save or update.
     * @return the saved student.
     */
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Update an existing student.
     *
     * @param id the ID of the student to update.
     * @param student the student with updated information.
     * @return an Optional containing the updated student if successful, otherwise empty.
     */
    public Optional<Student> updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);  // Ensure the ID is set for the update
            return Optional.of(studentRepository.save(student));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Delete a student by its ID.
     *
     * @param id the ID of the student to delete.
     * @return true if the student was deleted, otherwise false.
     */
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
