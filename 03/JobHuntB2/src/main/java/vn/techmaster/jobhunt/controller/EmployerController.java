package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.EmployerRequest;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public String getAllEmployers(Model model) {
        List<Employer> employers = employerRepository.getEmployers();
        model.addAttribute("employers", employers);
        return "employer";
    }

    @GetMapping("/add")
    public String addEmployer(Model model) {
        model.addAttribute("employer", new Employer());
        return "add";
    }

    @PostMapping("/add")
    public String handleAddEmployer(EmployerRequest employerRequest, RedirectAttributes redirect) {
        String uuid=UUID.randomUUID().toString();
        Employer employer = new Employer(uuid, employerRequest.name(),employerRequest.logo_path()
                ,employerRequest.website(),employerRequest.email());
        employerRepository.createEmployer(employer);
        return "redirect:/employer";
    }

    @GetMapping("/update/{id}")
    public String updateEmployer(Model model, @PathVariable String id) {
        Employer employer = employerRepository.getEmployerById(id);
        model.addAttribute("employer", employer);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String submitUpdateEmployer(@PathVariable String id, @ModelAttribute EmployerRequest employerRequest) {
        Employer employer = new Employer(id, employerRequest.name(), employerRequest.logo_path(),
                employerRequest.website(), employerRequest.email());
        employerRepository.updateEmployer(employer);
        return "redirect:/employer";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployer(@PathVariable String id) {
        employerRepository.deleteEmployerById(id);
        return "redirect:/employer";
    }
}
