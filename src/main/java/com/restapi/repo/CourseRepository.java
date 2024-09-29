package com.restapi.repo;

import com.restapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

public interface CourseRepository extends JpaRepository<Course, Serializable> {
}
