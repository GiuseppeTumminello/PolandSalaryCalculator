package org.example.enumApproch.service;

import org.example.enumApproch.entity.JobTitle;

import java.util.List;

public interface JobTitleService {

    //void save(BigDecimal grossSalary);
    JobTitle getJobTitleById(int id);
    List<JobTitle> getJobTitles();


}
