package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.jobhunt.model.*;
import vn.techmaster.jobhunt.repository.ApplicantRepository;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.repository.JobRepository;

import vn.techmaster.jobhunt.request.ApplicantRequest;
import vn.techmaster.jobhunt.request.JobRequest;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/list")
    public String jobList(Model model) {

        model.addAttribute("jobs", jobRepository.getJobs());
        return "job_list";
    }

    @GetMapping("/create")
    public String addJob(Model model) {
        model.addAttribute("skills", Skill.values());
        model.addAttribute("employers", employerRepository.getEmployers());
        model.addAttribute("listCity", City.values());
        model.addAttribute("job", new Job());
        return "job_create";
    }

    @PostMapping("/create")
    public String submitAddJob(@ModelAttribute JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job job = new Job(uuid, jobRequest.company_name(), jobRequest.skills(), jobRequest.title(), jobRequest.description()
                , jobRequest.city(), jobRequest.min_salary(), jobRequest.max_salary(), LocalDate.now());
        jobRepository.createJob(job);
        return "redirect:/job/list";
    }

    @GetMapping("/update/{id}")
    public String updateJob(Model model, @PathVariable String id) {
        Job job = jobRepository.getJobById(id);

        model.addAttribute("skills", Skill.values());
        model.addAttribute("employers", employerRepository.getEmployers());
        model.addAttribute("listCity", City.values());
        model.addAttribute("job", job);
        return "job_update";
    }

    @PostMapping("/update/{id}")
    public String submitUpdateJob(@PathVariable String id, @ModelAttribute JobRequest jobRequest) {
        Job searchJob = jobRepository.getJobById(id);
        Job job = new Job(id, jobRequest.company_name(), jobRequest.skills(), jobRequest.title(), jobRequest.description()
                , jobRequest.city(), jobRequest.min_salary(), jobRequest.max_salary(), searchJob.getCreated_at());
        jobRepository.updateJob(job);
        return "redirect:/job/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable String id) {
        jobRepository.deleteJobById(id);
        return "redirect:/job/list";
    }

    @GetMapping("/apply/{job_id}/applicant/add")
    public String applyJob(Model model, @PathVariable String job_id) {
        Job job = jobRepository.getJobById(job_id);

        model.addAttribute("skills", Skill.values());
        model.addAttribute("applicant", new Applicant());
        model.addAttribute("job", job);
        return "applicant_add";
    }

    @PostMapping("/apply/{job_id}/applicant/add")
    public String handelApplyJob(@PathVariable String job_id, @ModelAttribute ApplicantRequest applicantRequest) {
        Job searchJob = jobRepository.getJobById(job_id);
        Employer searchEmployer = employerRepository.getEmployerByName(searchJob.getCompany_name());
        String uuid = UUID.randomUUID().toString();

        Applicant applicant = new Applicant(uuid, searchJob.getId(), applicantRequest.name(), applicantRequest.email()
                , applicantRequest.phone(), applicantRequest.skills(), applicantRequest.introducing_letter());
        applicantRepository.createApplicant(applicant);


        //Send Email
        String applicantName = applicantRequest.name();
        String applicantEmail = applicantRequest.email();
        String skills = applicantRequest.skills().toString();
        String introducing_letter = applicantRequest.introducing_letter();

        String jobTitle = searchJob.getTitle();
        String companyName = searchEmployer.getName();
        String companyEmail = searchEmployer.getEmail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(applicantEmail);
        message.setTo(companyEmail);

        String mailSubject = applicantName + " - Ứng tuyển vị trí " + jobTitle + " - " + companyName;
        String mailContent = "Kính chào quý công ty, tôi xin ứng tuyển vào vị trí: " + jobTitle + " \n\n";
        mailContent += "Họ và tên: " + applicantName + "\n\n";
        mailContent += "Kĩ năng: " + skills + "\n\n";
        mailContent += "Thư giới thiệu: " + introducing_letter + "n\\n";
        mailContent += "Tôi xin chân thành cảm ơn";

        message.setSubject(mailSubject);
        message.setText(mailContent);

        emailSender.send(message);

        return "redirect:/applicant/list";
    }
}
