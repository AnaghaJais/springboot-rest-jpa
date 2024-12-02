package com.example.springboot_rest_jpa.service;

import com.example.springboot_rest_jpa.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseService extends JpaRepository<Course,Long> {
}
