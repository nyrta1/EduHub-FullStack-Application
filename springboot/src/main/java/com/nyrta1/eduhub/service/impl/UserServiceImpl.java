package com.nyrta1.eduhub.service.impl;

import com.nyrta1.eduhub.models.dto.RegistrationDTO;
import com.nyrta1.eduhub.models.entity.Role;
import com.nyrta1.eduhub.models.entity.UserEntity;
import com.nyrta1.eduhub.models.enums.RoleType;
import com.nyrta1.eduhub.models.mapper.UserEntityMapper;
import com.nyrta1.eduhub.repository.RoleRepository;
import com.nyrta1.eduhub.repository.UserRepository;
import com.nyrta1.eduhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void save(RegistrationDTO registrationDTO) {
        try {
            UserEntity user = UserEntityMapper.toEntity(registrationDTO);

            Role role = roleRepository.findByName(RoleType.STUDENT.name());
            user.setRoles(Collections.singletonList(role));
            user.setPassword(
                    passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional
    public void deleteByUsername(String username) {
        try {
            userRepository.deleteByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void deleteByID(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
