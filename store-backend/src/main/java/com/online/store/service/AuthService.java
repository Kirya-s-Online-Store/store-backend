package com.online.store.service;

import com.online.store.dto.LoginUserDTO;
import com.online.store.dto.RegisterUserDTO;
import com.online.store.model.Role;
import com.online.store.model.User;
import com.online.store.repository.UserRepository;
import com.online.store.service.api.IAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService, UserDetailsService {

    //private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void login(LoginUserDTO loginUserDTO) {

    }

    @Override
    public void register(RegisterUserDTO request) {
        User user = modelMapper.map(request, User.class);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}