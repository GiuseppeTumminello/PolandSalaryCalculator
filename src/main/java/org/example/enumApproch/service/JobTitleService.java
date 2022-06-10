package org.example.enumApproch.service;

import org.example.enumApproch.entity.JobTitle;

import java.math.BigDecimal;
import java.util.List;

public interface JobTitleService {

    int save(BigDecimal grossSalary);
    JobTitle getJobTitleById(int id);
    BigDecimal getAverageByJobTile(String jobTitle);
    boolean updateJobTitle(int id, String jobTitle);





}
