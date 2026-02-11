package com.myFirstProject.my_first_project.withJpa.repository;

import com.myFirstProject.my_first_project.withJpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
