package com.myFirstProject.my_first_project.withJpa.controller;

import com.myFirstProject.my_first_project.withJpa.entities.Course;
import com.myFirstProject.my_first_project.withJpa.entities.Enrollment;
import com.myFirstProject.my_first_project.withJpa.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollment")
    public ResponseEntity<List<Enrollment>> getEnrollments() {
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollments();
        if (allEnrollments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allEnrollments);
    }

    @GetMapping("/enrollment/{id}")
    public Enrollment getEnrollmentById(@PathVariable Integer id) {
        Enrollment enrollmentById = enrollmentService.getEnrollmentById(id).get();
        if(enrollmentById == null) {
            return enrollmentService.getEnrollmentById(id).get();
        }
        return enrollmentById;
    }

    @PostMapping("/enrollment")
    public ResponseEntity<?> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollement = enrollmentService.createEnrollment(enrollment);
        URI location = URI.create("/enrollment/" + newEnrollement.getEnrollmentId());
        try{
            return ResponseEntity.created(location).body(newEnrollement);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/enrollment/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable Integer id) {
        Optional<?> enrollment = enrollmentService.getEnrollmentById(id);
        if(enrollment.isPresent()) {
            enrollmentService.deleteEnrollment(id);
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/enrollment/{id}")
    public Enrollment updateEnrollment(@PathVariable Integer id, @RequestBody Enrollment enrollment) {
        System.out.println("EnrollmentController updateEnrollment");
        return enrollmentService.updateEnrollment(id, enrollment); // Return the result!
    }
}
