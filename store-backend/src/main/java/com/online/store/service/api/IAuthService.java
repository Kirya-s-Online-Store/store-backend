package com.online.store.service.api;

import com.online.store.dto.LoginUserDTO;
import com.online.store.dto.RegisterUserDTO;
import com.online.store.model.User;
import org.springframework.stereotype.Service;

public interface IAuthService {

    void login(LoginUserDTO loginUserDTO);

    void register(RegisterUserDTO registerUserDTO);
}
