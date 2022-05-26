package vn.techmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployerRepository {

    private final ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository() {
        employers = new ConcurrentHashMap<>();
        employers.put("EMP-01", new Employer("EMP-01", "CMC Global",
                "images/employer_logo/cmc-global.jpg",
                "https://cmcglobal.com.vn", "xuantruong18032000@gmail.com"));

        employers.put("EMP-02", new Employer("EMP-02", "FPT Software",
                "images/employer_logo/fsoft.png",
                "https://fpt-software.com", "xuantruong18032000@gmail.com"));

        employers.put("EMP-03", new Employer("EMP-03", "Savvycom",
                "images/employer_logo/savvycom.png",
                "https://savvycom.vn", "xuantruong18032000@gmail.com"));

        employers.put("EMP-04", new Employer("EMP-04", "Softdreams",
                "images/employer_logo/softdreams.png",
                "https://easyinvoice.vn", "xuantruong18032000@gmail.com"));

        employers.put("EMP-05", new Employer("EMP-05", "NTQ Solution",
                "images/employer_logo/NTQ.jpg",
                "https://ntq.com.vn", "xuantruong18032000@gmail.com"));
    }

    public List<Employer> getEmployers() {
        return employers.values().stream().toList();
    }

    public Employer getEmployerById(String id) {
        return employers.get(id);
    }

    public Employer getEmployerByName(String company_name) {
        for (Employer employer:employers.values()
             ) {
            if(employer.getName().equals(company_name)){
                return employer;
            }
        }
        return null;
    }
    public void createEmployer(Employer employer) {
        employers.put(employer.getId(), employer);
    }

    public void updateEmployer(Employer employer) {
        employers.put(employer.getId(), employer);
    }

    public void deleteEmployerById(String id) {
        employers.remove(id);
    }
}
