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
                "../static/images/cmc-global.jpg",
                "https://cmcglobal.com.vn/", "cmcglobal@gmail.com"));

        employers.put("EMP-02", new Employer("EMP-02", "FPT Software",
                "https://www.fpt-software.com/wp-content/uploads/sites/2/2017/06/logofsoft.png",
                "https://fpt-software.com.vn/", "fptsoftware@gmail.com"));

        employers.put("EMP-03", new Employer("EMP-03", "Savvycom",
                "https://images.glints.com/unsafe/glints-dashboard.s3.amazonaws.com/company-logo/848067444ce863cf3555b2100fa5fd73.jpg",
                "https://savvycom.com.vn/", "savvycom@gmail.com"));

        employers.put("EMP-04", new Employer("EMP-04", "Softdreams",
                "https://media-exp1.licdn.com/dms/image/C560BAQGdiPgW18wOKA/company-logo_200_200/0/1591244702925?e=2147483647&v=beta&t=_qRpdJzbghIDLCAsv3Ruwrdmy7JjFq2qYRt5divSyTU",
                "https://easyinvoice.com.vn/", "softdreams@gmail.com"));

        employers.put("EMP-05", new Employer("EMP-05", "NTQ Solution",
                "https://media.graphassets.com/glo1PqMJTpG5Ut6EZqCW",
                "https://ntqsolution.com.vn/", "ntq-solution@gmail.com"));
    }

    public ConcurrentHashMap<String,Employer> getEmployers() {

        return employers;
    }
}
