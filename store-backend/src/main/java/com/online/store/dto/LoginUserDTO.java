package com.online.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDTO {

    private String email;
    private String password;
    private String address;
}
