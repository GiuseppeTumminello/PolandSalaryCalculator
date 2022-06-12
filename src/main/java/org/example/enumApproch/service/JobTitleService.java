package org.example.enumApproch.service;

import java.math.BigDecimal;

import org.example.enumApproch.entity.JobTitle;


public interface JobTitleService {

    int save(BigDecimal grossSalary);

    JobTitle getJobTitleById(int id);

    BigDecimal getAverageByJobTile(String jobTitle);

    boolean updateJobTitle(int id, String jobTitle);

}
