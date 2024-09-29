package com.restapi.rest;

import com.restapi.entity.Course;
import com.restapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        String status = courseService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer id){
        Course courseById = courseService.getCourseById(id);
        return new ResponseEntity<>(courseById,HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> allCourses = courseService.getAllCourses();
        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){
        String status = courseService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
        String msg = courseService.deleteById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

}
