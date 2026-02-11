package com.myFirstProject.my_first_project.withoutJpa.controller;

import com.myFirstProject.my_first_project.withoutJpa.entities.Course;
import com.myFirstProject.my_first_project.withoutJpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class CourseController {
//    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<Course> getCourses(){
        System.out.println("hello");
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Integer id){
        return courseService.getCourseById(id);
    }

    @PostMapping("course")
    public void addCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }

    @DeleteMapping("course/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }

    @PutMapping("course/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

}
