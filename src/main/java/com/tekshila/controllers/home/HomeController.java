package com.tekshila.controllers.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tekshila.dao.CourseRepository;
import com.tekshila.domain.Course;
import com.tekshila.domain.TekUser;
import com.tekshila.dtos.SubscriberDto;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/t")
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    @Value("${USER_SESSION_ATTR}")
    private String session_store_name;

    @RequestMapping("/home")
    public String home(Model model, HttpSession httpSession) {
        List<Course> courses = courseRepository.findAll();
        TekUser u = (TekUser) httpSession.getAttribute(session_store_name);
            model.addAttribute("courses", courses);
            model.addAttribute("user",u);
            model.addAttribute("subscribeDto",new SubscriberDto());
            return "thome";
    }


}
