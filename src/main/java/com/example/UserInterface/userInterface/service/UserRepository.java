package com.example.UserInterface.userInterface.service;

import com.example.UserInterface.userInterface.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
