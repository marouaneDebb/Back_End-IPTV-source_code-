package com.example.angularback.controlers;

import com.example.angularback.model.User;
import com.example.angularback.service.UserSercice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/Users")
public class UserControler {
private final UserSercice userSercice;

    public UserControler(UserSercice userSercice) {
        this.userSercice = userSercice;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userSercice.findAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        User users = userSercice.findUserById(username);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User user1 = userSercice.addUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
}
