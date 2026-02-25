package com.StudentManagementSystem.withJpa.repository;

import com.StudentManagementSystem.withJpa.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {

}
