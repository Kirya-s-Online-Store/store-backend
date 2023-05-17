package com.online.store.dto;

import com.online.store.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "First name must be not blank")
    private String firstName;

    @NotBlank(message = "Last name must be not blank")
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotBlank(message = "Password must be not blank")
    private String password;

    @Builder.Default
    private Role role = Role.ROLE_USER;
}
