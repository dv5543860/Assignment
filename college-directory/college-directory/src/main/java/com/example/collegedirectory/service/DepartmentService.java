package com.example.collegedirectory.service;

import com.example.collegedirectory.model.Department;
import com.example.collegedirectory.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Retrieve all departments from the database.
     *
     * @return List of departments
     */
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Retrieve a department by its ID.
     *
     * @param id The ID of the department
     * @return Optional of department
     */
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    /**
     * Create a new department.
     *
     * @param department The department to be created
     * @return The created department
     */
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Update an existing department.
     *
     * @param id          The ID of the department to be updated
     * @param department  The updated department data
     * @return Optional of updated department
     */
    public Optional<Department> updateDepartment(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            return Optional.of(departmentRepository.save(department));
        }
        return Optional.empty();
    }

    /**
     * Delete a department by its ID.
     *
     * @param id The ID of the department to be deleted
     * @return True if deletion was successful, false otherwise
     */
    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
