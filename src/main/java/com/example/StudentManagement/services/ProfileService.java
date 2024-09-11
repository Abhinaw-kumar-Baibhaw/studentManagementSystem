package com.example.StudentManagement.services;
import com.example.StudentManagement.dto.ProfileDto;
import com.example.StudentManagement.entities.Profile;
import java.util.Optional;



public interface ProfileService {

    // Create or Update
    public ProfileDto addProfile(ProfileDto profile);

    // Read
    public ProfileDto findById(Long id);

    // Delete
    public void deleteById(Long id);
}
