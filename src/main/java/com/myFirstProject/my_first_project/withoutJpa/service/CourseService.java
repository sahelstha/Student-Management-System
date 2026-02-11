package com.myFirstProject.my_first_project.withoutJpa.service;

import com.myFirstProject.my_first_project.withoutJpa.entities.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//@Component
public class CourseService {
    protected static List<Course> courses = new ArrayList<>();
    private static Integer courseId = 10000;

    static{
        courses.add(new Course(++courseId, "Complete Database Course", "Learn Db with mySQL from basic"));
        courses.add(new Course(++courseId, "Complete Data Science Course", "Learn Linear Reggression"));
        courses.add(new Course(++courseId, "Complete Spring Framework", "Learn Spring boot framework from basic"));
    }

    public List<Course> getAllCourses(){
        return courses;
    }
    public static Course getCourseById(Integer id){
        Predicate<? super Course> predicate = course -> course.getId().equals(id);
        return courses.stream().filter(predicate).findFirst().orElse(null);
    }
    public void createCourse(Course course){
        course.setId(++courseId);
        courses.add(course);
    }
    public void deleteCourse(Integer id){
        courses.removeIf(course -> course.getId().equals(id));
    }
    public Course updateCourse(Integer courseId,Course course){
        System.out.println("hello");
        var currentCourse = getCourseById(courseId);

        if(currentCourse == null) throw new IllegalArgumentException("Course with id " + courseId + " does not exist");
        if(course.getCourseName() != null) currentCourse.setCourseName(course.getCourseName());
        if(course.getCourseDescription() != null) currentCourse.setCourseDescription(course.getCourseDescription());

        return currentCourse;
    }

}
