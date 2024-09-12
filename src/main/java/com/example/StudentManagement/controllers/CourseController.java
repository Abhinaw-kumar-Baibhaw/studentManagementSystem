package com.example.StudentManagement.controllers;
import com.example.StudentManagement.dto.CourseDto;
import com.example.StudentManagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
//@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public CourseDto addCourse(@RequestBody CourseDto courseDto){
       return courseService.addCourse(courseDto);
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

//    @DeleteMapping("{deletedId}")
//    public void  deleteCourse(@PathVariable Long deletedId){
//        System.out.println("CONTROLLER DELETE COURSE ID :::" + deletedId);
//        courseService.deleteCourse(deletedId);
//    }
}
