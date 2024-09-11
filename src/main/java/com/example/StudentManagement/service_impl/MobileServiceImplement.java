package com.example.StudentManagement.service_impl;
import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.entities.Mobile;
import com.example.StudentManagement.enums.MobileEnum;
import com.example.StudentManagement.repo.MobileRepo;
import com.example.StudentManagement.services.MobileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImplement implements MobileService {



    private final MobileRepo mobileRepo;

    private final ModelMapper modelMapper;

    @Autowired
    public MobileServiceImplement(MobileRepo mobileRepo, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.mobileRepo = mobileRepo;
    }

    @Override
    public MobileDto addMobile(MobileDto mobile) {
        Mobile map = modelMapper.map(mobile, Mobile.class);
        Mobile save = mobileRepo.save(map);
       return modelMapper.map(save,MobileDto.class);
    }

    @Override
    public MobileDto getMobileById(Long mobileId) {
         Optional<Mobile> mob = mobileRepo.findById(mobileId);
         if(mob.isPresent()){
             Mobile mobile = mob.get();
            return modelMapper.map(mobile, MobileDto.class);

         }else {
             throw new RuntimeException("Mobile not found with id :: "+mobileId);
         }

    }

    @Override
    public MobileDto updateMobile(Long mobileId, MobileDto mobile) {
        return null;
    }

    @Override
    public boolean deleteMobile(Long mobileId) {
        return false;
    }

    @Override
    public List<MobileDto> getAllMobiles() {
        return List.of();
    }

    @Override
    public List<MobileDto> getMobilesByType(MobileEnum mobileType) {
        return List.of();
    }
}
