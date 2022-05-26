package vn.techmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.City;
import vn.techmaster.jobhunt.model.Job;
import vn.techmaster.jobhunt.model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class JobRepository {

    private final ConcurrentHashMap<String, Job> jobs;

    public JobRepository() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("J-01", new Job("J-01", "Softdreams", new ArrayList<>(List.of(Skill.Java, Skill.Angular)), "Lập trình viên FullStack Angular + Java"
                , "Lập trình viên thành thạo Java và Angular", new ArrayList<>(List.of(City.HaNoi, City.HoChiMinh)), 1000
                , 2500, LocalDate.of(2022, 5, 12)));

        jobs.put("J-02", new Job("J-02", "CMC Global", new ArrayList<>(List.of(Skill.Java, Skill.CSharp, Skill.MySQL))
                , "Lập trình viên BackEnd"
                , "Lập trình viên BackEnd những người đảm nhiệm công việc viết những đoạn code và chương trình để vận hành ứng dụng, website."
                , new ArrayList<>(List.of(City.HaNoi, City.HoChiMinh)), 800, 2000
                , LocalDate.of(2022, 5, 10)));

        jobs.put("J-03", new Job("J-03", "FPT Software", new ArrayList<>(List.of(Skill.HTML_CSS, Skill.Javascript)), "Lập trình viên FrontEnd",
                "Lập trình viên Front end (Front end developer) sẽ chịu trách nhiệm phát triển giao diện bên ngoài của một website dựa vào những bản thiết kế."
                , new ArrayList<>(List.of(City.HoChiMinh, City.HaNoi, City.DaNang)), 700, 1800
                , LocalDate.of(2022, 5, 15)));

        jobs.put("J-04", new Job("J-04", "Savvycom", new ArrayList<>(List.of(Skill.HTML_CSS, Skill.Javascript, Skill.Java)), "Lập trình viên FullStack",
                "Lập trình viên Full-stack là người có thể làm các công việc liên quan tới databases, servers, systems engineering và client work."
                , new ArrayList<>(List.of(City.HaNoi)), 1200, 3000
                , LocalDate.of(2022, 5, 13)));

        jobs.put("J-05", new Job("J-05", "CMC Global", new ArrayList<>(List.of(Skill.Java, Skill.MySQL)), "Lập trình viên Java",
                "Lập trình viên Java là người phát triển ứng dụng dựa trên ngôn ngữ Java."
                , new ArrayList<>(List.of(City.HaNoi, City.HaiPhong)), 700, 2500
                , LocalDate.of(2022, 5, 10)));

    }

    public List<Job> getJobs() {
        return jobs.values().stream().toList();
    }

    public Job getJobById(String id) {
        return jobs.get(id);
    }

    public void createJob(Job job) {
        jobs.put(job.getId(), job);
    }

    public void updateJob(Job job) {
        jobs.put(job.getId(), job);
    }

    public void deleteJobById(String id) {
        jobs.remove(id);
    }

    public List<Job> filterBySkill(String skill) {
        Skill searchSkill=Skill.valueOf(skill);
        return jobs.values().stream().filter(o1 -> o1.getSkills().contains(searchSkill)).toList();
    }

    public List<Job> filterByCity(City city) {
        return jobs.values().stream().filter(o1 -> o1.getCity().contains(city)).toList();
    }
}
