package com.example.StudentManagement.service_impl;

import com.example.StudentManagement.dto.ProfileDto;
import com.example.StudentManagement.entities.Profile;
import com.example.StudentManagement.exceptions.ResourceNotFoundException;
import com.example.StudentManagement.repo.ProfileRepo;
import com.example.StudentManagement.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImplement implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProfileDto addProfile(ProfileDto profileDto) {
        Profile map = modelMapper.map(profileDto, Profile.class);
        Profile save = profileRepo.save(map);
        return modelMapper.map(save,ProfileDto.class);
    }

    @Override
    public ProfileDto findById(Long id) {
        Optional<Profile> byId = profileRepo.findById(id);
        if(byId.isPresent()){
            Profile profile = byId.get();
            ProfileDto map = modelMapper.map(profile, ProfileDto.class);
            return map;
        }
        else {
            throw new ResourceNotFoundException("Profle Not Found");
        }
    }

    @Override
    public void deleteById(Long id) {

    }
}
