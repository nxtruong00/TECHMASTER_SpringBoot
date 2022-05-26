package vn.techmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployerRepository {

    private ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository() {
        employers = new ConcurrentHashMap<>();
        employers.put("EMP-01", new Employer("EMP-01", "CMC Global",
                "images/cmc-global.jpg",
                "https://cmcglobal.com.vn/", "cmcglobal@gmail.com"));

        employers.put("EMP-02", new Employer("EMP-02", "FPT Software",
                "images/fsoft.png",
                "https://fpt-software.com.vn/", "fptsoftware@gmail.com"));

        employers.put("EMP-03", new Employer("EMP-03", "Savvycom",
                "images/savvycom.png",
                "https://savvycom.com.vn/", "savvycom@gmail.com"));

        employers.put("EMP-04", new Employer("EMP-04", "Softdreams",
                "images/softdreams.png",
                "https://easyinvoice.com.vn/", "softdreams@gmail.com"));

        employers.put("EMP-05", new Employer("EMP-05", "NTQ Solution",
                "images/NTQ.jpg",
                "https://ntqsolution.com.vn/", "ntq-solution@gmail.com"));
    }

    public List<Employer> getEmployers() {
        return employers.values().stream().toList();
    }

    public Employer getEmployerById(String id) {
        return employers.get(id);
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
