package com.example.StudentManagement.repo;

import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.entities.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MobileRepo extends JpaRepository<Mobile, Long> {

}
