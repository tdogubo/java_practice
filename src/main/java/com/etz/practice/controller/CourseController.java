package com.etz.practice.controller;

import com.etz.practice.model.CourseModel;
import com.etz.practice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    public final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseModel>getCourses(){return courseService.getCourses();}

    @PostMapping
    public void addNewCourse(@RequestBody CourseModel course){
        courseService.addCourse(course);
    }


}
