package com.example.StudentManagement.repo;

import com.example.StudentManagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
