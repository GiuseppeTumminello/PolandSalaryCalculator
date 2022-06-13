package org.example.enumApproch.enums;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobFields {

    IT(1, "It", new ArrayList<>(List.of("DevOps Engineer", "Software Developer", "Software Engineer"))),
    FINANCE(2, "Finance", new ArrayList<>(List.of("Fund Accountant", "Depositary"))),
    ENGINEER(3, "Engineer",new ArrayList<>(List.of("Mechanic Engineer", "Civil Engineer")));


    private final int jobId;
    private final String Description;
    private final List<String> jobTitle;


}
