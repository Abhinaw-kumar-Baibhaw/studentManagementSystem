package com.example.StudentManagement.services;

import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.entities.Mobile;
import com.example.StudentManagement.enums.MobileEnum;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MobileService {


    MobileDto addMobile(MobileDto mobile);

    MobileDto getMobileById(Long mobileId);

    MobileDto updateMobile(Long mobileId, MobileDto mobile);

    boolean deleteMobile(Long mobileId);

    List<MobileDto> getAllMobiles();

    List<MobileDto> getMobilesByType(MobileEnum mobileType);

//    boolean validateMobileNumber(String mobileNumber);

}
