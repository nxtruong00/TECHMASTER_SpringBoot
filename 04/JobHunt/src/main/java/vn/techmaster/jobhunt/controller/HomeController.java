package vn.techmaster.jobhunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping(value = "template")
    public String showTemplate() {
        return "template";
    }

    @GetMapping(value = "job")
    public String getJobs() {
        return "job";
    }


    @GetMapping(value = "applicant")
    public String getApplicants() {
        return "applicant";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
}
