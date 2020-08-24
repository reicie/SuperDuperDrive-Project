package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private UserMapper userMapper;
    private HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    // when a user is registering, check that username is unique; not being used by another user
    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    //  Create a new user
    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        User newUser = new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName());
        return userMapper.insert(newUser);
    }

    // delete user
    public void deleteUser(Integer userId) {
        userMapper.delete(userId);
    }

    // return a user given the username
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
