package com.nyrta1.eduhub.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 4, max = 35, message = "The length of the name must be between 4 and 35 characters")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 4, max = 35, message = "The length of the surname must be between 4 and 35 characters")
    private String surname;

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 35, message = "The length of the username must be between 4 and 35 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
