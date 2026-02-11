package com.myFirstProject.my_first_project.withoutJpa.entities;

import java.time.LocalDate;

public class Student {

    private Integer id;
    private String name;
    private LocalDate DOB;
    private String email;

    public Student() {
    }

    public Student(Integer id, String name, LocalDate DOB, String email) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
