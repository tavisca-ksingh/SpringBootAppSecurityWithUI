package com.example.UserInterface.userInterface.DAO;

import com.example.UserInterface.userInterface.model.Users;
import com.example.UserInterface.userInterface.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UserDao {


    @Autowired
    UserRepository userRepository;


    public Users createUser(@RequestBody Users user) {
      return userRepository.save(user);
    }

}
