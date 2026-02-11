package com.myFirstProject.my_first_project.withoutJpa.service;

import com.myFirstProject.my_first_project.withoutJpa.entities.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//@Component
public class StudentService {
    protected static List<Student> students = new ArrayList<Student>();
    private static Integer count = 100;

    static{
        students.add(new Student(++count, "Sahel Shrestha", LocalDate.now().minusYears(21), "sahel@123gmail.com"));
        students.add(new Student(++count, "Ram Shrestha", LocalDate.now().minusYears(30), "ram@123gmail.com"));
        students.add(new Student(++count, "Shyam Shrestha", LocalDate.now().minusYears(41), "shyam@123gmail.com"));
    }

    public List<Student> findAllStudents(){
        return students;
    }
    public static Student findStudentById(Integer id){
        Predicate<? super Student> findByiId = std->std.getId().equals(id);
        return students.stream().filter(findByiId).findFirst().orElse(null);
    }
    public void createStudent(Student student){
        student.setId(++count);
        students.add(student);
    }
    public void deleteStudentById(Integer id){
        students.removeIf(student -> student.getId().equals(id));
    }
    public void updateStudent(Integer id, Student student){
        Student currentStudent = findStudentById(id);

        if(currentStudent == null) throw new IllegalArgumentException("Student with id: " + id + " is not found");

        if(student.getName() != null) currentStudent.setName(student.getName());
        if(student.getDOB() != null) currentStudent.setDOB(student.getDOB());
        if(student.getEmail() != null) currentStudent.setEmail(student.getEmail());
    }
}
