package com.myFirstProject.my_first_project.withJpa.controller;

import com.myFirstProject.my_first_project.withJpa.entities.Course;
import com.myFirstProject.my_first_project.withJpa.entities.Student;
import com.myFirstProject.my_first_project.withJpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getCourses(){
        var courses = courseService.getAllCourses();
        if(courses.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(courses);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        var course = courseService.getCourseById(id).get();
        if(course == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(course);
    }

    @GetMapping("/course/{id}/students")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable Integer id){
        List<Student> studentByCourseId = courseService.getStudentByCourseId(id);
        if(studentByCourseId.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(studentByCourseId);
    }

    @PostMapping("/course")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        Course newCourse = courseService.createCourse(course);
        URI location = URI.create("/course/" + newCourse.getId());
        try{
            return ResponseEntity.created(location).body(newCourse);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        Optional<?> course = courseService.getCourseById(id);
        if(course.isPresent()){
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course incomming){
        Course course = courseService.updateCourse(id, incomming);
        return ResponseEntity.ok(course);
    }
}
