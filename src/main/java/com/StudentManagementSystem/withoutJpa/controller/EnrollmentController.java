package com.StudentManagementSystem.withoutJpa.controller;

import com.StudentManagementSystem.withoutJpa.entities.Enrollment;
import com.StudentManagementSystem.withoutJpa.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class EnrollmentController {
//    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollment")
    public List<Enrollment> getEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/enrollment/{id}")
    public Enrollment getEnrollmentById(@PathVariable Integer id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping("enrollment")
    public void addEnrollment(@RequestBody Enrollment enrollment) {
        enrollmentService.createEnrollment(enrollment);
    }

    @DeleteMapping("enrollment/{id}")
    public void deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}
