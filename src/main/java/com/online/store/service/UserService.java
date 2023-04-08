package com.online.store.service;

import com.online.store.model.User;
import com.online.store.repository.UserRepository;
import com.online.store.service.api.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements CrudService<User> {

    private UserRepository userRepository;

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
