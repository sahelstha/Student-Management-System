package com.StudentManagementSystem.withJpa.repository;

import com.StudentManagementSystem.withJpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
