package com.example.UserInterface.userInterface.controller;

import com.example.UserInterface.userInterface.DAO.LoginDao;
import com.example.UserInterface.userInterface.model.Login;
import com.example.UserInterface.userInterface.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        String name = request.getParameter("uname");
        String pass = request.getParameter("psw");
        System.out.println(name + " " + pass);
        Users user = loginDao.findUser(name,pass);
        System.out.println(user);
        if (null != user) {
            mav = new ModelAndView("greeting");
            mav.addObject("name", request.getParameter("uname"));
        } else {
            mav = new ModelAndView("login");
            mav.addObject("name", "Username or Password is wrong!!");
        }
        return mav;
    }

}
