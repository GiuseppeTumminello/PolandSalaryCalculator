package org.example.enumApproch.Service;

import java.math.BigDecimal;

public interface AverageSalaryService {

    void save(BigDecimal grossSalary);
    BigDecimal getById(int id);


}
