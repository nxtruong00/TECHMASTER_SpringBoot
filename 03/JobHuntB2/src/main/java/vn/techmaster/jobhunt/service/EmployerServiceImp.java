package vn.techmaster.jobhunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImp implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<Employer> getAllEmployer() {
        return employerRepository.getEmployers().values().stream().toList();
    }

    @Override
    public void saveEmployer(Employer employer) {
        employerRepository.getEmployers().put(employer.getId(), employer);
    }

    @Override
    public void deleteEmployer(String id) {
        employerRepository.getEmployers().remove(id);
    }

    @Override
    public Optional<Employer> findEmployerById(String id) {
        return Optional.ofNullable(employerRepository.getEmployers().get(id));
    }
}
