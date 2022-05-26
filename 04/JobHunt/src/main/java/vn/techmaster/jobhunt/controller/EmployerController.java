package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.model.EmployerForm;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.EmployerRequest;
import vn.techmaster.jobhunt.service.StorageService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private StorageService storageService;

    @GetMapping("/list")
    public String employerList(Model model) {
        model.addAttribute("employers", employerRepository.getEmployers());
        return "employer_list";
    }

    @GetMapping("/add")
    public String addEmployer(Model model) {
        model.addAttribute("employer", new EmployerForm());
        return "employer_add";
    }

    @PostMapping("/add")
    public String submitAddEmployer(@Valid @ModelAttribute EmployerForm employerForm, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "employer_add";
        }

        String uuid = UUID.randomUUID().toString();
        storageService.uploadFile(employerForm.getImage());

        String pathImg="images/employer_logo/"+ employerForm.getImage().getOriginalFilename()+"";

        Employer employer = new Employer(uuid, employerForm.getName(), pathImg,
                employerForm.getWebsite(), employerForm.getEmail());
        employerRepository.createEmployer(employer);
        return "redirect:/employer/list";
    }

    @GetMapping("/update/{id}")
    public String updateEmployer(Model model, @PathVariable String id) {
        Employer employer = employerRepository.getEmployerById(id);
        model.addAttribute("employer", employer);
        return "employer_update";
    }

    @PostMapping("/update/{id}")
    public String submitUpdateEmployer(@PathVariable String id, @ModelAttribute EmployerRequest employerRequest) {
        Employer employer = new Employer(id, employerRequest.name(), employerRequest.logo_path(),
                employerRequest.website(), employerRequest.email());
        employerRepository.updateEmployer(employer);
        return "redirect:/employer/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployer(@PathVariable String id) {
        employerRepository.deleteEmployerById(id);
        return "redirect:/employer/list";
    }

}
