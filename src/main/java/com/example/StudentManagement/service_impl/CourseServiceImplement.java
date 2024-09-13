package com.example.StudentManagement.service_impl;

import com.example.StudentManagement.dto.CourseDto;
import com.example.StudentManagement.dto.DepartmentDto;
import com.example.StudentManagement.entities.Course;
import com.example.StudentManagement.entities.Department;
import com.example.StudentManagement.exceptions.ResourceNotFoundException;
import com.example.StudentManagement.repo.CourseRepo;
import com.example.StudentManagement.repo.DepartmentRepo;
import com.example.StudentManagement.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplement implements CourseService {


    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        course.setCreatedAt(LocalDate.now());
        List<DepartmentDto> departmentDtos = courseDto.getDepartments();
        List<Department> deptList = new ArrayList<>();
        for (DepartmentDto deptDto : departmentDtos) {
            Department department;
            if (deptDto.getId() != null) {
                department = departmentRepo.findById(deptDto.getId())
                        .orElseThrow(() -> new RuntimeException("Department not found"));
            } else {
                department = modelMapper.map(deptDto, Department.class);
            }
            department.setCourses(course);
            deptList.add(department);
        }
        course.setDepartments(deptList);
        Course savedCourse = courseRepo.save(course);
        return modelMapper.map(savedCourse, CourseDto.class);
    }




    @Override
    public CourseDto getCourseById(Long id) {
        Optional<Course> byId = courseRepo.findById(id);
        if(byId.isPresent()){
            Course course = byId.get();
            CourseDto map = modelMapper.map(course, CourseDto.class);
            return map;
        }
        else {
            throw new ResourceNotFoundException("Course "+id+" is Not Found");
        }
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> allCourses = courseRepo.findAll();
        return allCourses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String  deleteCourse(Long id) {

//        System.out.println("DELETE COURSE ID :::" + id);
//       if(courseRepo.existsById(id)){
//           courseRepo.deleteById(id);
//       }
//       else {
//           throw new ResourceNotFoundException("Not Found any course");
//       }
        return "";
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        return null;
    }
}
