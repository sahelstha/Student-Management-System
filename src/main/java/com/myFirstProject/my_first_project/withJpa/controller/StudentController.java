package com.myFirstProject.my_first_project.withJpa.controller;

import com.myFirstProject.my_first_project.withJpa.entities.Course;
import com.myFirstProject.my_first_project.withJpa.entities.Student;
import com.myFirstProject.my_first_project.withJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> allStudents = studentService.findAllStudents();
            if(allStudents.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<EntityModel<Student>> getStudentById(@PathVariable Integer id) { //HATEOAS
        var student = studentService.findStudentById(id);
        if(student.isPresent()){
            EntityModel<Student> entityModel = EntityModel.of(student.get());

            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getStudents());
            entityModel.add(link.withRel("all_students"));
            return ResponseEntity.ok(entityModel);
        }

        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        URI location = URI.create("/student/" + createdStudent.getId());

        try{
            return ResponseEntity.created(location).body(createdStudent);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/student/{id}/myCourses")
    public ResponseEntity<List<Course>> getMyCourses(@PathVariable Integer id) {
        List<Course> coursesByStudentId = studentService.getCoursesByStudentId(id);
        if(coursesByStudentId.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(coursesByStudentId);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Integer id) {
        var student = studentService.findStudentById(id);
        if(student.isPresent()){
            studentService.deleteStudentById(id);
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student incomming) {
        Student student = studentService.updateStudent(id, incomming);
        return ResponseEntity.ok(student);
    }
}
