package com.StudentManagementSystem.withoutJpa.service;

import com.StudentManagementSystem.withoutJpa.entities.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Component
public class EnrollmentService {
    private static List<Enrollment> enrollments = new ArrayList<>();
    private static Integer enrollmentCount = 1000;
    static {
        enrollments.add(new Enrollment(++enrollmentCount, StudentService.students.get(0).getId(), CourseService.courses.get(0).getId()));
        enrollments.add(new Enrollment(++enrollmentCount, StudentService.students.get(1).getId(), CourseService.courses.get(1).getId()));
        enrollments.add(new Enrollment(++enrollmentCount, StudentService.students.get(2).getId(), CourseService.courses.get(2).getId()));
    }
    private CourseService courseService;
    private StudentService studentService;

    public EnrollmentService(CourseService courseService,
                             StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
    public Enrollment getEnrollmentById(Integer enrollmentId) {
        return enrollments.stream().filter(enrollment -> enrollment.getEnrollmentId().equals(enrollmentId)).findFirst().orElse(null);
    }

    public void createEnrollment(Enrollment enrollment) {
        try {
            enrollment.setEnrollmentId(++enrollmentCount);
            var student = studentService.findStudentById(enrollment.getStudentId());
            var course = courseService.getCourseById(enrollment.getCourseId());

            if (student != null && course != null) {
                enrollments.add(enrollment);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEnrollment(Integer enrollmentId) {
        enrollments.removeIf(enrollment -> Objects.equals(enrollment.getEnrollmentId(), enrollmentId));
    }
}
