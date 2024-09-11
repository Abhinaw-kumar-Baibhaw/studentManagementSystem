package com.example.StudentManagement.services;
import com.example.StudentManagement.dto.DepartmentDto;
import java.util.List;



public interface DepartmentService {

    DepartmentDto addDepartment(DepartmentDto departmentDto);

    DepartmentDto getById(Long id);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);

    void deleteById(Long id);
}

