package com.tekshila.controllers.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import com.tekshila.dao.EnrolCourseRepository;
import com.tekshila.domain.EnrolledCourse;
import com.tekshila.domain.TekUser;
import com.tekshila.enums.CourseStatus;

import javax.servlet.http.HttpSession;

@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @Autowired
    private EnrolCourseRepository enrolCourseRepository;

    @Value("${USER_SESSION_ATTR}")
    private String session_store_name;

    @PostMapping("/t/course/charge")
    public String charge(ChargeRequest chargeRequest, Model model, HttpSession httpSession)
            throws StripeException {

        System.out.println(" ---------------->>>>>>> " + chargeRequest.getCourseId());

        chargeRequest.setDescription("Charging for Course ");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());

        if(charge != null && "succeeded".equalsIgnoreCase(charge.getStatus())) {
            EnrolledCourse enrolledCourse = new EnrolledCourse();
                enrolledCourse.setCourseId(chargeRequest.getCourseId());
                TekUser tusr = (TekUser) httpSession.getAttribute(session_store_name);

                    if(null == tusr) {
                        model.addAttribute("forward_url","forward:/t/courses/view/" + chargeRequest.getCourseId());
                        return "forward:/t/user/login";
                    }

                    enrolledCourse.setUserIdentity("" + tusr.getUserId());
                    enrolledCourse.setStatus(CourseStatus.ENROLLED.toString());
                    enrolCourseRepository.save(enrolledCourse);
            return "forward:/" + tusr.getUserId() + "/mycourses/view/" + chargeRequest.getCourseId();
        }
        else return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }

}
