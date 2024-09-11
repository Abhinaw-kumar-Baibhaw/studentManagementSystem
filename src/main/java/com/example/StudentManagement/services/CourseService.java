package com.example.StudentManagement.services;

import com.example.StudentManagement.dto.CourseDto;

import java.util.List;

public interface CourseService {

    public CourseDto addCourse(CourseDto courseDto);

    public CourseDto getCourseById(Long id);

    public List<CourseDto> getAllCourses();

    public void deleteCourse(Long id);

    public CourseDto updateCourse(Long id, CourseDto courseDto);


}
