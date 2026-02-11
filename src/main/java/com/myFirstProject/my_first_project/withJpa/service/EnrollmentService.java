package com.myFirstProject.my_first_project.withJpa.service;

import com.myFirstProject.my_first_project.withJpa.entities.Enrollment;
import com.myFirstProject.my_first_project.withJpa.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class EnrollmentService {
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Integer enrollmentId) {
        return enrollmentRepo.findById(enrollmentId);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }

    public void deleteEnrollment(Integer enrollmentId) {
        enrollmentRepo.deleteById(enrollmentId);
    }

    public Enrollment updateEnrollment(Integer id, Enrollment enrollmentRequest) {
        // 1. Find the existing enrollment
        Enrollment existingEnrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enrollment not found"));

        // 2. If the request body contains a student with an ID, re-link it safely
        if (enrollmentRequest.getStudent() != null && enrollmentRequest.getStudent().getId() != null) {
            // Technically, you should fetch the student from studentRepo here to be 100% safe
            existingEnrollment.setStudent(enrollmentRequest.getStudent());
        }

        // 3. Same for Course
        if (enrollmentRequest.getCourse() != null && enrollmentRequest.getCourse().getId() != null) {
            existingEnrollment.setCourse(enrollmentRequest.getCourse());
        }

        return enrollmentRepo.save(existingEnrollment);
    }
}
