package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.EmployerRequest;
import vn.techmaster.jobhunt.service.EmployerService;
import vn.techmaster.jobhunt.service.EmployerServiceImp;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public String getAllEmployers(Model model) {
        List<Employer> employers = employerService.getAllEmployer();
        model.addAttribute("employers", employers);
        return "employer";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("employer", new Employer());
        return "add";
    }

    @PostMapping("/save")
    public String save(Employer employer, RedirectAttributes redirect) {
        employer.setId(UUID.randomUUID().toString());
        employerService.saveEmployer(employer);
        redirect.addFlashAttribute("success", "Saved employer successfully!");
        return "redirect:/employer";
    }

    
//    @RequestMapping(value = { "/", "/addEmployer" }, method = RequestMethod.GET)
//    public String addEmployee(Model model) {
//        model.addAttribute("employer", new Employer());
//        return "add";
//    }
//    @RequestMapping(value = "/addEmployer", method = RequestMethod.POST)
//    public String doAddEmployee(@ModelAttribute("employee") Employer employer, ModelMap modelMap) {
//        modelMap.addAttribute("employee", employer);
//        return "redirect:/employer";
//    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        employerService.deleteEmployer(id);
        return "redirect:/employer";
    }
}
