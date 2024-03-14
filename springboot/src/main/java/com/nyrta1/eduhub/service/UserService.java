package com.nyrta1.eduhub.service;

import com.nyrta1.eduhub.models.dto.RegistrationDTO;
import com.nyrta1.eduhub.models.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    void save(RegistrationDTO registrationDTO);
    Optional<UserEntity> findByUsername(String username);
    void deleteByUsername(String username);
    void deleteByID(Long id);
}
