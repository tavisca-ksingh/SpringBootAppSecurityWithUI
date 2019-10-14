package com.example.UserInterface.userInterface.DAO;

import com.example.UserInterface.userInterface.model.Login;
import com.example.UserInterface.userInterface.model.Users;
import com.example.UserInterface.userInterface.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class LoginDao {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    EntityManager entityManager;
    public List<Login> reteriveAllItems(){
        return serviceRepository.findAll();
    }


    public Users findUser(String name , String pass) {
        Users user = null;
        Query query =entityManager.createQuery("SELECT u FROM Users u WHERE u.uname LIKE:name AND u.upass LIKE:pass");
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        try {
            user = (Users) query.getSingleResult();
        } catch (Exception e) {
            // Handle exception
        }
        return user;
    }
}
