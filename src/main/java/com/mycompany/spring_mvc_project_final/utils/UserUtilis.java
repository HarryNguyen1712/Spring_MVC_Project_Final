package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.service.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.ModelAttribute;

public class UserUtilis {

    public static void editProfile(@ModelAttribute(name = "user") UserEntity user, UserDetailsServiceImpl userDetailsService) {
        UserEntity userEntity= userDetailsService.findByEmail(user.getEmail());
        userEntity.setGenderEnum(user.getGenderEnum());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setFullName(user.getFullName());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setAddress(user.getAddress());
        userDetailsService.save(userEntity);
    }
}
