package com.restapi.service;

import com.restapi.entity.Course;
import com.restapi.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String upsert(Course course) {
        courseRepository.save(course); // upsert (insert / update based on the PK)
        return "success";
    }

    @Override
    public Course getCourseById(Integer id) {
        Optional<Course> byId = courseRepository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> all = courseRepository.findAll();
        return all;
    }

    @Override
    public String deleteById(Integer id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
            return "Delete Success";
        }else {
            return "No Record Found";
        }
    }
}
