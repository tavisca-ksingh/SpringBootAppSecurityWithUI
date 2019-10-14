package com.example.UserInterface.userInterface.controller;

import com.example.UserInterface.userInterface.DAO.UserDao;
import com.example.UserInterface.userInterface.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name= "name", required=false ,defaultValue = "Hakuna Matata") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("signup");
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("user") Users user) {
        ModelAndView mav = null;
        System.out.println(userDao.createUser(user));
        mav = new ModelAndView("signup");
        return mav;
    }


}
