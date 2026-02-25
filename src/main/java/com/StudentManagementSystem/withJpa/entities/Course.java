package com.StudentManagementSystem.withJpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(
            name = "course_generator",
            sequenceName = "course_seq",
            initialValue = 1001,
            allocationSize = 1
    )
    private Integer id;
    private String courseName;
    private String courseDescription;
    @OneToMany(mappedBy = "course",  cascade = CascadeType.ALL,  orphanRemoval = true)
    @JsonIgnoreProperties("course")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(String courseName, String courseDescription) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public Course() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

//    public void setEnrollments(List<Enrollment> enrollments) {
//        this.enrollments = enrollments;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
