package com.etz.practice.service;

import com.etz.practice.model.CourseModel;
import com.etz.practice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    public final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseModel>getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(CourseModel course) {
        Optional<CourseModel> courseById = courseRepository.findByTitle(course.getTitle());
        if(courseById.isPresent()){
            throw new IllegalStateException("course already exists");
        }
        courseRepository.save(course);
    }
}
