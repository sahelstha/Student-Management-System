package com.myFirstProject.my_first_project.withJpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_seq",
            initialValue = 10001,
            allocationSize = 1
    )
    private Integer id;
    private String name;
    private LocalDate DOB;
    private String email;
    @OneToMany(mappedBy = "student",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("student") //This tells Spring: "Show the student, and show their enrollments, but inside those enrollments, don't print the student again."
    private List<Enrollment> enrollments = new ArrayList<>();
    public Student() {
    }

    public Student(String name, LocalDate DOB, String email) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
