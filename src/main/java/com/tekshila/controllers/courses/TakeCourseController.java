package com.tekshila.controllers.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for users to start taking a written course
@Controller
public class TakeCourseController {

    @GetMapping("/t/ecourse")
    public String takeCourse(Model model) {
        return "/courses/preparing_for_system_design/design_mint";
    }


}
