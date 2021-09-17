package com.tekshila.controllers.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/t")
public class CourseContentController {


    @RequestMapping(value = "/c/{courseId}/p/{pageId}", method = RequestMethod.GET)
    public String openCoursePage(@PathVariable(name = "courseId") String courseId,
                                 @PathVariable(name = "pageId") String pageId, Model model) {
         if(isUserValid()) {
             return "mycourses/c" + courseId + "/" + pageId;
         } else {
             return "login";
         }
    }

    @RequestMapping(value = "/cc/{courseId}", method = RequestMethod.GET)
    public String test(Model model) {
        return "test.html";
    }

    public boolean isUserValid() {
        return true;
    }

}
