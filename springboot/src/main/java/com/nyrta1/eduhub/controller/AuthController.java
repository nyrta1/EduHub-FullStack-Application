package com.nyrta1.eduhub.controller;

import com.nyrta1.eduhub.config.security.customhandlers.CustomAuthenticationSuccessHandler;
import com.nyrta1.eduhub.models.dto.RegistrationDTO;
import com.nyrta1.eduhub.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationDTO registrationDTO) {
        try {
            userService.save(registrationDTO);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
