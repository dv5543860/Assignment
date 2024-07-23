package com.example.collegedirectory.repository;

import com.example.collegedirectory.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom query methods can be added here

    // Find all courses by a specific department
    List<Course> findByDepartmentId(Long departmentId);

    // Find all courses taught by a specific faculty member
    List<Course> findByFacultyId(Long facultyId);
}
