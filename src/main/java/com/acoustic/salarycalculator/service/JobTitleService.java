package com.acoustic.salarycalculator.service;

import java.math.BigDecimal;


public interface JobTitleService {

    void save(BigDecimal grossSalary, String jobTitle);

    BigDecimal getAverageByJobTile(String jobTitle);

}
