package com.myFirstProject.my_first_project.withJpa.repository;

import com.myFirstProject.my_first_project.withJpa.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {

}
