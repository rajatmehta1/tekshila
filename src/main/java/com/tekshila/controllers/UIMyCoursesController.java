package com.tekshila.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@Controller
public class UIMyCoursesController {


    @GetMapping("/mycourses/{id}")
    public String fetchMyCourses(@PathVariable("id") Integer id, Model model) {
        return "courses-grid";
    }


}
