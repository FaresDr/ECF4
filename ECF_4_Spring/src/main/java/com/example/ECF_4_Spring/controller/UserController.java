package com.example.ECF_4_Spring.controller;

import com.example.ECF_4_Spring.entity.User;
import com.example.ECF_4_Spring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession httpSession;



    public UserController(UserService userService, HttpSession httpSession) {this.userService = userService;
        this.httpSession = httpSession;
    }
    @GetMapping("/")
    public String home(){
        httpSession.setAttribute("user", new User());
        httpSession.setAttribute("logged", false);
        return "redirect:/login";

    }

    @GetMapping("/signin")
    public String signin(Model model) {
        if (httpSession.getAttribute("logged").equals(false)) {
            model.addAttribute("user", new User());
            return "signinForm";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute("user") User user) {
        if (userService.findByMailAndPassword(user.getEmail(), user.getPassword()) == null) {
            userService.save(user);
        }else {
            return "redirect:/signin";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (httpSession.getAttribute("logged").equals(false)) {
            model.addAttribute("user", new User());
            return "loginForm";
        }else {
            return "redirect:/";
        }
    }
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user") User user) {
//        System.out.println(user);
//        System.out.println(userService.findByNameAndPassword(user.getUsername(), user.getPassword()));
        if(userService.findByMailAndPassword(user.getEmail(), user.getPassword())!=null){
            httpSession.setAttribute("logged", true);
            httpSession.setAttribute("user", user);
            return "redirect:/joboffer";
        }else {
            return "redirect:/signin";
        }
    }


    @GetMapping("/logout")
    public String logout() {
        httpSession.setAttribute("logged", false);
        httpSession.setAttribute("user", null);
        return "redirect:/login";
    }
}
