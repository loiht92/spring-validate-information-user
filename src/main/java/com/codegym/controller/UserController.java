package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/a")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/a")
    public String checkValidation (@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("phoneNumber", user.getPhoneNumber());
            model.addAttribute("age", user.getAge());
            model.addAttribute("email", user.getEmail());
            return "result";
        }
    }
}
