package vn.techmaster.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
    private String id;
    private String company_name;
    private List<Skill> skills;
    private String title;
    private String description;
    private List<City> city;
    private int min_salary;
    private int max_salary;
    private LocalDate created_at;

}
