package com.online.store.service.mapper;

import com.online.store.dto.LoginUserDTO;
import com.online.store.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.*;

public class ModelMapperTest {

    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ModelMapper();
    }


    @Test
    void checkUserRegistrationToUser() {
        String address = "Some address";
        String email = "SomeEmail@gmail.com";
        String password = "Some password";
        User expected = User.builder()
                .address(address)
                .email(email)
                .password(password)
                .build();
        LoginUserDTO userRegistration = LoginUserDTO.builder()
                .email(email)
                .password(password)
                .address(address)
                .build();
        User actual = mapper.map(userRegistration, User.class);
        assertThat(actual.getAddress()).isEqualTo(expected.getAddress());
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
    }

    @Test
    void checkUserAuthenticationToUser() {
        String email = "SomeEmail@gmail.com";
        String password = "Some password";
        User expected = User.builder()
                .email(email)
                .password(password)
                .build();
        LoginUserDTO userAuthentication = LoginUserDTO.builder()
                .email(email)
                .password(password)
                .build();
        User actual = mapper.map(userAuthentication, User.class);
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
    }
}
