package com.tekshila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tekshila.dao.CourseRepository;
import com.tekshila.domain.Course;
import com.tekshila.domain.enums.Status;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/taxila/courses")
public class CourseControllerRest {

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "/create")
    public @ResponseBody String createCourse() {
        return "course created";
    }

    @RequestMapping(value = "/list")
    public @ResponseBody List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @RequestMapping(value = "/create/sample")
    public String createCourse1() {
        Course c = new Course();
            c.setName("Preparing for System Design");
            c.setStatus(Status.ACTIVE);
            c.setCreatedBy(1);
            c.setDescription("Preparing for system design interview ourse");
            c.setCreateDate(new Date());
            courseRepository.save(c);
            return "Success - Created Course";
    }

}
