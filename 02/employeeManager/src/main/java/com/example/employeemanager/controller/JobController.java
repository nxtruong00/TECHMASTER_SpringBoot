package com.example.employeemanager.controller;

import com.example.employeemanager.dto.JobRequest;
import com.example.employeemanager.model.Job;
import com.example.employeemanager.model.Location;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;

    public JobController() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("J-01", new Job("J-01", "Lập trình viên BackEnd", "Lập trình viên BackEnd những người đảm nhiệm công việc viết những đoạn code và chương trình để vận hành ứng dụng, website.",
                Location.HaNoi, 15000000, 100000000, "truong@hr.com"));
        jobs.put("J-02", new Job("J-02", "Lập trình viên FrontEnd", "Lập trình viên Front end (Front end developer) sẽ chịu trách nhiệm phát triển giao diện bên ngoài của một website dựa vào những bản thiết kế.",
                Location.DaNang, 10000000, 80000000, "nam@hr.com"));
        jobs.put("J-03", new Job("J-03", "Lập trình viên FullStack", "Lập trình viên Full-stack là người có thể làm các công việc liên quan tới databases, servers, systems engineering và client work.",
                Location.HaNoi, 20000000, 110000000, "son@hr.com"));
        jobs.put("J-04", new Job("J-04", "Lập trình viên Java", "Lập trình viên Java là người phát triển ứng dụng dựa trên ngôn ngữ Java.",
                Location.HoChiMinh, 12000000, 80000000, "truong@hr.com"));
    }

    @GetMapping()
    public List<Job> getAllJobs() {
        return jobs.values().stream().toList();
    }

    @PostMapping
    public Job creatJob(@RequestBody JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email());
        jobs.put(uuid, newJob);
        return newJob;
    }

    @GetMapping(value = "/find")
    public Job findById(@RequestParam("id") String id) {
        return jobs.get(id);
    }

    @PostMapping(value = "/update")
    public Job updateJobByID(@RequestParam("id") String id, @RequestBody JobRequest jobRequest) {
        Job updateJod = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email());
        jobs.put(id, updateJod);
        return updateJod;
    }

    @DeleteMapping(value = "/delete")
    public String deleteById(@RequestParam("id") String id) {
        jobs.remove(id);
        return "Xoá thành công";
    }

    @GetMapping(value = "/sortbylocation")
    public List<Job> sortByLocation() {
        return jobs.values().stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
    }

    @GetMapping(value = "/salary/{salary}")
    public List<Job> findJobBySalary(@PathVariable("salary") int salary) {
        return jobs.values().stream().filter(o1 -> o1.getMax_salary() >= salary && o1.getMin_salary() <= salary).collect(Collectors.toList());
    }

    @GetMapping(value = "/keyword/{keyword}")
    public List<Job> findJobByKeyWord(@PathVariable("keyword") String keyword) {
        return jobs.values()
                .stream()
                .filter(o1 -> o1.getTitle().toLowerCase().contains(keyword)
                        || o1.getDescription().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/query")
    public List<Job> findJobByLocation(@RequestParam("keyword") String keyword, @RequestParam("location") Location location) {
        return jobs.values()
                .stream()
                .filter(o1 -> (o1.getTitle().toLowerCase().contains(keyword)
                        || o1.getDescription().toLowerCase().contains(keyword))
                        && o1.getLocation() == location)
                .collect(Collectors.toList());
    }
}
