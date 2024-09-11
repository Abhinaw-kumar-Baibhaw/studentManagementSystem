package com.example.StudentManagement.repo;

import com.example.StudentManagement.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ParentRepo extends JpaRepository<Parent, Long> {
}
