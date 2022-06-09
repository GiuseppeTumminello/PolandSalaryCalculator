package org.example.enumApproch.Service;

import java.math.BigDecimal;
import java.util.List;

public interface DatabaseService {

    void save(BigDecimal grossSalary);
    BigDecimal getDataByJobTitle(String jobTitle, String position);


}
