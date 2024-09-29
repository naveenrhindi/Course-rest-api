package com.restapi.service;

import com.restapi.entity.Course;

import java.util.List;

public interface CourseService {

    public String upsert(Course course);

    public Course getCourseById(Integer id);

    public List<Course> getAllCourses();

    public String deleteById(Integer id);

}
