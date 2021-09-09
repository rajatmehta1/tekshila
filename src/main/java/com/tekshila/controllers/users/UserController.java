package com.tekshila.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tekshila.dao.CountersRepository;
import com.tekshila.dao.UserRepository;
import com.tekshila.domain.Counters;
import com.tekshila.domain.TekUser;
import com.tekshila.dtos.EnrolCourseDto;
import com.tekshila.dtos.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/t/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CountersRepository countersRepository;

    @Value("${SESSION_INACTIVE_TIME}")
    private int sessionInactiveTime;

    @Value("${USER_SESSION_ATTR}")
    private String session_store_name;


    public @ResponseBody String hello() {
        return "hello from student";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(@RequestParam(name="cid", required = false) String cid, Model model) {

        User u = new User();
        //course id
        if(null != cid && !"".equalsIgnoreCase(cid)) {
//            model.addAttribute("redirect_url","forward:/t/courses/view/" + cid);
            u.setRedirect_url("/t/courses/view/" + cid);
        }

        model.addAttribute("user", u);
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, User user, HttpSession httpSession) {
        TekUser tuser = userRepository.findTekUserByEmailAndPassword(user.getEmail(), user.getPwd());
        System.out.println("tuser.email --------->"+ tuser.getEmail());
        if(null != tuser) {
            model.addAttribute("loggedInUser",tuser);
                httpSession.setMaxInactiveInterval(sessionInactiveTime);
                httpSession.setAttribute(session_store_name, tuser);

                if(null != user.getRedirect_url() && !"".equalsIgnoreCase(user.getRedirect_url())) {
                    return "forward:" + user.getRedirect_url();
                }
                return "forward:/t/" + tuser.getUserId() + "/mycourses";
        }
        else {
            model.addAttribute("error","Invalid Credential. Please try again");
            return "login";
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, User user) {

        Counters cs = countersRepository.findBySequenceName("users_seq");
        if(null == cs) {
            cs = new Counters();
        }
           cs.setSequenceName("users_seq");
           cs.setSequenceValue(cs.getSequenceValue() + 1);

        TekUser s = new TekUser();
            s.setEmail(user.getEmail());
            s.setName(user.getName());
            s.setPassword(user.getPwd());

            userRepository.save(s);
            countersRepository.save(cs);
        return "test";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @RequestMapping(value = "/enrol", method = RequestMethod.POST)
    public String enrolInCourse(Model model, EnrolCourseDto ec) {
        model.addAttribute("user", new User());
        return "enrol";
    }

}
