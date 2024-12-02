package com.example.springboot_rest_jpa.controller;


import com.example.springboot_rest_jpa.dao.Course;
import com.example.springboot_rest_jpa.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    //http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id){
        Optional<Course> optionalCourse = courseService.findById(id);
        System.out.println(optionalCourse.toString());
        if(optionalCourse.isEmpty()){
            throw new RuntimeException("No matching id");
        }
        else {
            return optionalCourse.get();
        }
    }

    //update, delete and add new course

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course){
       courseService.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable Long id,@RequestBody Course course){
         courseService.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id){
      courseService.deleteById(id);

    }

}
