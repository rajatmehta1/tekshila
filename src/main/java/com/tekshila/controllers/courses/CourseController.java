package com.tekshila.controllers.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tekshila.controllers.stripe.ChargeRequest;
import com.tekshila.dao.CourseRepository;
import com.tekshila.dao.UserRepository;
import com.tekshila.domain.Course;
import com.tekshila.domain.TekUser;
import com.tekshila.domain.enums.Status;
import com.tekshila.dtos.CourseDto;
import com.tekshila.dtos.User;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/t/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    UserRepository userRepository;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Value("${USER_SESSION_ATTR}")
    private String session_store_name;

    @Autowired
    public CourseController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewAllCourses(Model model) {
        List<Course> courses = courseRepository.findAll();
            model.addAttribute("courses", courses);
            return "fixed-student-courses";
    }

    @RequestMapping(value = "/view/{courseID}", method = {RequestMethod.GET,RequestMethod.POST})
    public String viewCourse(@PathVariable(name = "courseID") int courseID, Model model, HttpSession httpSession) {
        Course course = courseRepository.findCourseByCourseIdEquals(courseID);
        TekUser instructor = userRepository.findTekUserByUserId(course.getCreatedBy());
            System.out.println("\n\n ----------> " + course.getDescription() + "\n\n");

        TekUser tusr = (TekUser) httpSession.getAttribute(session_store_name);

            model.addAttribute("course",course);
            model.addAttribute("instructor",instructor);
            model.addAttribute("login_url_with_courseid","/t/user/login?cid=" + courseID);
            model.addAttribute("amount", 1 * 100); // in cents
            model.addAttribute("stripePublicKey", stripePublicKey);
            model.addAttribute("currency", ChargeRequest.Currency.USD);
            if(null == tusr) {
                model.addAttribute("logged_in","n");
            } else {
                model.addAttribute("logged_in","y");
            }
                return "course_detail";
    }


    @RequestMapping(value = "/view/create", method = RequestMethod.GET)
    public String viewCreateCourse(CourseDto courseDto) {
        return "fixed-student-courses";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCourse(CourseDto courseDto) {
        Course c = new Course();
                c.setName(courseDto.getName());
                c.setStatus(Status.ACTIVE);
                c.setCreatedBy(courseDto.getCreatedBy());
                c.setDescription(courseDto.getDescription());
                c.setCreateDate(new Date());
                courseRepository.save(c);
        return "fixed-student-courses";
    }


}
