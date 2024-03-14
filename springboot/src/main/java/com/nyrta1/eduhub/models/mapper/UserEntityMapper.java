package com.nyrta1.eduhub.models.mapper;

import com.nyrta1.eduhub.models.dto.RegistrationDTO;
import com.nyrta1.eduhub.models.entity.UserEntity;

public class UserEntityMapper {
    public static UserEntity toEntity(RegistrationDTO registrationDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(registrationDTO.getName());
        userEntity.setSurname(registrationDTO.getSurname());
        userEntity.setUsername(registrationDTO.getUsername());
        userEntity.setPassword(registrationDTO.getPassword());
        return userEntity;
    }
}
