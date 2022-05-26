package vn.techmaster.jobhunt.request;

import vn.techmaster.jobhunt.model.City;
import vn.techmaster.jobhunt.model.Skill;

import java.util.List;

/**
 * private String id;
 * private String emp_id;
 * private String title;
 * private String description;
 * private City city;
 */

public record JobRequest(
        String id,
        String company_name,
        String title,
        List<Skill> skills,
        String description,
        List<City> city,
        int min_salary,
        int max_salary) {
}
