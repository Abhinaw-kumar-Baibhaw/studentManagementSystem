package com.example.StudentManagement.repo;

import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.entities.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MobileRepo extends JpaRepository<Mobile, Long> {

    @Modifying
    @Query("DELETE FROM Mobile m WHERE m.student.studentId = :studentId")
    void deleteByStudentId(Long studentId);
}
