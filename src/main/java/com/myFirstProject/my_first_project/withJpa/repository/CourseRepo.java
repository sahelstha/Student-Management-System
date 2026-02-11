package com.myFirstProject.my_first_project.withJpa.repository;

import com.myFirstProject.my_first_project.withJpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
