package com.tekshila.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Controller for the login page
 */
@Controller
public class UILoginController {

//    LoginService

    @GetMapping("/login2")
    public String login(Model model) {
        return "login";
    }

}
