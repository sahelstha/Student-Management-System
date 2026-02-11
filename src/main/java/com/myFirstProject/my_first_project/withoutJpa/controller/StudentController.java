package com.myFirstProject.my_first_project.withoutJpa.controller;

import com.myFirstProject.my_first_project.withoutJpa.entities.Student;
import com.myFirstProject.my_first_project.withoutJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class StudentController {
//    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("student/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        System.out.println("updateStudent");
        studentService.updateStudent(id,student);
    }
}
