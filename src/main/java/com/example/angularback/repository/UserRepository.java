package com.example.angularback.repository;

import com.example.angularback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
//    void deleteUserById(String username);

//    Optional<User> findUserById(String username);

    void deleteUserByUsername(String username);

    Optional<User> findUserByUsername(String username);
}
