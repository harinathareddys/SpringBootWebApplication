package com.sap.controller;

import com.sap.dao.UserMongoRepository;
import com.sap.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger    LOG  = LoggerFactory.getLogger(getClass());
    private final UserMongoRepository userRepository;

    public UserController(UserMongoRepository userRepository){
        this.userRepository =   userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User addNewUser(@RequestBody User user){
        LOG.info("Saving User");
        return userRepository.save(user);
    }
}
