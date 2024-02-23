package com.xersky.springblog.service;

import com.xersky.springblog.entity.User;
import com.xersky.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findOneByUsername(String user) {
        return userRepository.findUserByUsernameIgnoreCase(user);
    }
    public void createUser(User user) {
       userRepository.save(user);
    }
}
