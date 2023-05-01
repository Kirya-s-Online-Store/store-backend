package com.online.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserDTO {

    private String email;
    private String password;
}
