package com.StudentManagementSystem.withJpa.service;

import com.StudentManagementSystem.withJpa.entities.Course;
import com.StudentManagementSystem.withJpa.entities.Enrollment;
import com.StudentManagementSystem.withJpa.entities.Student;
import com.StudentManagementSystem.withJpa.repository.CourseRepo;
import com.StudentManagementSystem.withJpa.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
    public Optional<Course> getCourseById(Integer id){
        return courseRepo.findById(id);
    }

    public List<Student> getStudentByCourseId(int courseId) {
        var enrollment = enrollmentRepo.findAll();

        List<Student> student = new ArrayList<>();

        for(Enrollment e : enrollment) {
            if(e.getCourse().getId() == courseId) {
                student.add(e.getStudent());
            }
        }
        return student;
    }
    public Course createCourse(Course course){
        System.out.println(course);
        return courseRepo.save(course);
    }
    public void deleteCourse(Integer id){
        courseRepo.deleteById(id);
    }
    public Course updateCourse(Integer id, Course incomming){
        var course = courseRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Student with id " + id + " not found"));

        if(incomming.getCourseName() != null) course.setCourseName(incomming.getCourseName());
        if(incomming.getCourseDescription() != null) course.setCourseDescription(incomming.getCourseDescription());

        return courseRepo.save(course);
    }

}
