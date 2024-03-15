package com.nyrta1.eduhub.service.impl;

import com.nyrta1.eduhub.models.entity.UserEntity;
import com.nyrta1.eduhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            List<GrantedAuthority> authorities = userEntity.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());

            User userDetails = new User(
                    user.get().getUsername(),
                    user.get().getPassword(),
                    authorities
            );

            return userDetails;
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
