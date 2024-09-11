package com.example.StudentManagement.controllers;
import com.example.StudentManagement.dto.DepartmentDto;
import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repo.StudentRepo;
import com.example.StudentManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(@RequestBody Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
    }

    @PostMapping("/add")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
       return departmentService.addDepartment(departmentDto);
    }

    @GetMapping("/{id}")
    public DepartmentDto getById(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(Long id){
        departmentService.deleteById(id);
    }

}
