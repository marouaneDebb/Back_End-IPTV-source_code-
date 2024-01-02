package com.example.angularback.service;

import com.example.angularback.exeptions.UserNotFoundExeption;
import com.example.angularback.model.User;
import com.example.angularback.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class UserSercice {
    private final UserRepository userRepository;
    @Autowired

    public UserSercice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String username){
        userRepository.deleteUserByUsername(username);

    }
    public User findUserById(String username){
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundExeption("user not found"));

    }
}
