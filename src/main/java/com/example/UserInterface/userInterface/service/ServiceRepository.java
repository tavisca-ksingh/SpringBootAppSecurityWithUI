package com.example.UserInterface.userInterface.service;

import com.example.UserInterface.userInterface.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Login,Integer> {
}
