package org.example.enumApproch.service;

import java.math.BigDecimal;


public interface JobTitleService {

    int save(BigDecimal grossSalary);


    BigDecimal getAverageByJobTile(String jobTitle);

    void updateJobTitle(int id, String jobTitle);

}
