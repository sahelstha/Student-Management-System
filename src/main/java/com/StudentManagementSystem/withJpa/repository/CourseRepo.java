package com.StudentManagementSystem.withJpa.repository;

import com.StudentManagementSystem.withJpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
