package com.example.StudentManagement.repo;

import com.example.StudentManagement.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {

    @Modifying
    @Query("DELETE FROM AddressEntity a WHERE a.student.studentId = :studentId")
    void deleteByStudentId(Long studentId);
}
