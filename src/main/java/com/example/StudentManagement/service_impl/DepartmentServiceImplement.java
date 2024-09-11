package com.example.StudentManagement.service_impl;
import com.example.StudentManagement.dto.DepartmentDto;
import com.example.StudentManagement.dto.StudentDto;
import com.example.StudentManagement.entities.Department;
import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.exceptions.ResourceNotFoundException;
import com.example.StudentManagement.repo.DepartmentRepo;
import com.example.StudentManagement.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;



@Service
public class DepartmentServiceImplement implements DepartmentService {


    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
//        StudentDto s=new StudentDto();
//        Student map1 = modelMapper.map(s, Student.class);
//        map1.setRegisterDate(new Date());
//        map1.setCreatedAt(LocalDate.now());
        Department map = modelMapper.map(departmentDto, Department.class);
        Department save = departmentRepo.save(map);
        return modelMapper.map(save,DepartmentDto.class);
    }

    @Override
    public DepartmentDto getById(Long id) {
        Optional<Department> byId = departmentRepo.findById(id);
        if(byId.isPresent()){
            Department department = byId.get();
            DepartmentDto map = modelMapper.map(department, DepartmentDto.class);
            return map;
        }
        else {
            throw new ResourceNotFoundException("Department Not Found");
        }
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return List.of();
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Department> byId = departmentRepo.findById(id);
        if(byId.isPresent()){
            departmentRepo.deleteById(id);
        }
       else {
            throw new ResourceNotFoundException("not available");
        }
    }
}
