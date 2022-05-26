package vn.techmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Applicant;
import vn.techmaster.jobhunt.model.Skill;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ApplicantRepository {
    private final ConcurrentHashMap<String, Applicant> applicants;

    public ApplicantRepository() {
        applicants=new ConcurrentHashMap<>();
        applicants.put("APP-01",new Applicant("APP-01","J-02","Nguyễn Xuân Trường"
                ,"newtonnguyen18032000@gmail.com","0896123568"
                ,new ArrayList<>(List.of(Skill.Java,Skill.Angular,Skill.HTML_CSS,Skill.MySQL,Skill.Javascript))
                ,"Tôi có tư duy tốt và quen thuộc với ngôn ngữ lập trình"));

        applicants.put("APP-02",new Applicant("APP-02","J-01","Nguyễn Thành Nam"
                ,"newtonnguyen18032000@gmail.com","0968563664"
                ,new ArrayList<>(List.of(Skill.Java,Skill.Angular))
                ,"Tôi có tư duy tốt và quen thuộc với ngôn ngữ lập trình"));

        applicants.put("APP-03",new Applicant("APP-03","J-02","Trần Quang Tùng"
                ,"newtonnguye18032000@gmail.com","0361233695"
                ,new ArrayList<>(List.of(Skill.Java,Skill.CSharp,Skill.MySQL))
                ,"Tôi có tư duy tốt và quen thuộc với ngôn ngữ lập trình"));

        applicants.put("APP-04",new Applicant("APP-04","J-03","Phạm Thành Trung"
                ,"newtonnguyen18032000@gmail.com","0936941255"
                ,new ArrayList<>(List.of(Skill.HTML_CSS,Skill.Javascript,Skill.Angular))
                ,"Tôi có tư duy tốt và quen thuộc với ngôn ngữ lập trình"));

        applicants.put("APP-05",new Applicant("APP-05","J-04","Nguyễn Văn Nam"
                ,"newtonnguyen18032000@gmail.com","0962564856"
                ,new ArrayList<>(List.of(Skill.Java,Skill.MySQL,Skill.HTML_CSS,Skill.Javascript))
                ,"Tôi có tư duy tốt và quen thuộc với ngôn ngữ lập trình"));
    }

    public List<Applicant> getApplicants() {
        return applicants.values().stream().toList();
    }

    public Applicant getApplicantById(String id) {
        return applicants.get(id);
    }

    public void createApplicant(Applicant applicant) {
        applicants.put(applicant.getId(), applicant);
    }

    public void updateApplicant(Applicant applicant) {
        applicants.put(applicant.getId(), applicant);
    }

    public void deleteApplicantById(String id) {
        applicants.remove(id);
    }
}
