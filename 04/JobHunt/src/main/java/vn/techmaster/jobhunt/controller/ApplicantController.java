package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.techmaster.jobhunt.model.Applicant;
import vn.techmaster.jobhunt.model.Skill;
import vn.techmaster.jobhunt.repository.ApplicantRepository;
import vn.techmaster.jobhunt.repository.JobRepository;
import vn.techmaster.jobhunt.request.ApplicantRequest;


@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/list")
    public String applicantList(Model model) {
        model.addAttribute("applicants", applicantRepository.getApplicants());
        return "applicant_list";
    }

    @GetMapping("/update/{id}")
    public String updateApplicant(Model model, @PathVariable String id) {
        Applicant applicant = applicantRepository.getApplicantById(id);

        model.addAttribute("jobs",jobRepository.getJobs());
        model.addAttribute("skills",Skill.values());
        model.addAttribute("applicant", applicant);
        return "applicant_update";
    }

    @PostMapping("/update/{id}")
    public String submitUpdateApplicant(@PathVariable String id, @ModelAttribute ApplicantRequest applicantRequest) {
        Applicant applicant = new Applicant(id,applicantRequest.job_id(), applicantRequest.name(),applicantRequest.email()
                ,applicantRequest.phone(),applicantRequest.skills(),applicantRequest.introducing_letter());
        applicantRepository.updateApplicant(applicant);
        return "redirect:/applicant/list";
    }

//    @GetMapping("/find/{keyword}")
//    public String searchApplicant(Model model, @PathVariable String keyword) {
//
//
//        model.addAttribute("jobs",jobRepository.getJobs());
//        model.addAttribute("skills",Skill.values());
//        model.addAttribute("applicant", applicant);
//        return "applicant_update";
//    }

    @GetMapping("/delete/{id}")
    public String deleteApplicant(@PathVariable String id) {
        applicantRepository.deleteApplicantById(id);
        return "redirect:/applicant/list";
    }


}
