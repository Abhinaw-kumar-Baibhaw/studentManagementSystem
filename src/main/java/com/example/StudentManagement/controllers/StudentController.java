package com.example.StudentManagement.controllers;
import com.example.StudentManagement.dto.StudentDto;
import com.example.StudentManagement.dto.StudentDto2;
import com.example.StudentManagement.repo.DepartmentRepo;
import com.example.StudentManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService service;


    @Autowired
    private DepartmentRepo departmentRepo;


    @PostMapping("/addStudent")
    public StudentDto2 addStudent(@RequestBody StudentDto studentDto){
        System.out.println("BEFORE TOTAL"+studentDto);
      return   service.addStudent(studentDto);
    }

    @GetMapping("getAllData")
    public List<StudentDto> getAllData(){
       return service.getAllData();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("findByEmail")
    public StudentDto findByEmail(String email) {
             return service.findByEmail(email);
    }

    @GetMapping("deletedById")
    public String deleteById(Long id) {
        return service.deleteById(id);
    }

    @GetMapping("showProfile")
    public StudentDto showProfile(Long id){
        return service.showProfile(id);
    }

    @GetMapping("updateStudent")
    public StudentDto updateStudent(StudentDto studentDto,Long id){
        return service.updateStudent(studentDto,id);
    }
}
