package vn.techmaster.jobhunt.service;

import vn.techmaster.jobhunt.model.Employer;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    List<Employer> getAllEmployer();

    void saveEmployer(Employer employer);

    void deleteEmployer(String id);

    Optional<Employer> findEmployerById(String id);
}
