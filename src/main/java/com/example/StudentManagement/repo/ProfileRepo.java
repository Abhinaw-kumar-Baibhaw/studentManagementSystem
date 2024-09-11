package com.example.StudentManagement.repo;

import com.example.StudentManagement.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
