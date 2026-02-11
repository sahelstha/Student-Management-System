package com.myFirstProject.my_first_project.withJpa.service;

import com.myFirstProject.my_first_project.withJpa.entities.Course;
import com.myFirstProject.my_first_project.withJpa.entities.Enrollment;
import com.myFirstProject.my_first_project.withJpa.entities.Student;
import com.myFirstProject.my_first_project.withJpa.repository.CourseRepo;
import com.myFirstProject.my_first_project.withJpa.repository.EnrollmentRepo;
import com.myFirstProject.my_first_project.withJpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public List<Course> getCoursesByStudentId(int studentId) {
        var enrollment = enrollmentRepo.findAll();
        List<Course> courses = new ArrayList<>();
        for(Enrollment e : enrollment) {
            if(e.getStudent().getId() == studentId) {
                courses.add(e.getCourse());
            }
        }
        return courses;
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }
    public Optional<Student> findStudentById(Integer id){
        return studentRepo.findById(id);
    }
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }
    public void deleteStudentById(Integer id){
        studentRepo.deleteById(id);
    }
    public Student updateStudent(Integer id, Student incomming){
        Student student = studentRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Student with id " + id + " not found"));

        if(incomming.getName() != null) student.setName(incomming.getName());
        if(incomming.getDOB() != null) student.setDOB(incomming.getDOB());
        if(incomming.getEmail() != null) student.setEmail(incomming.getEmail());

        return studentRepo.save(student);
    }
}
