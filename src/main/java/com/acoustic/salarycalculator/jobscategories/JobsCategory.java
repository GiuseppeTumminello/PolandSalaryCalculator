package com.acoustic.salarycalculator.jobscategories;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobsCategory {

    IT(1, "It", List.of("DevOps Engineer",
            "Software Developer",
            "Cloud System Engineer",
            "Cloud Architect",
            "Network Engineer",
            "IT Support Specialist",
            "Database Administrator",
            "System Architect",
            "Web Administrator",
            "Software Engineer")),
    FINANCE(2, "Finance", List.of("Depositary",
            "Fund Accountant",
            "Accountant",
            "Tax Analyst",
            "Auditor",
            "Risk Analyst",
            "Business Analyst",
            "Billing Administrator",
            "Financial Controller")),
    ENGINEER(3, "Engineer", List.of("Civil Engineer",
            "Project Engineer",
            "Test Engineer",
            "Sales Engineer",
            "R&D Engineer",
            "Thermal Engineer")),
    RESTAURANT(4, "Restaurant", List.of("Executive Chef",
            "Assistant Manager",
            "General Manager",
            "Sous Chef",
            "Kitchen Manager",
            "Line Cook",
            "Bartender",
            "Cashier",
            "Dishwasher",
            "Waitress")),
    AIRLINE(5,
            "Airline",
            List.of("Airline Captain",
                    "Airline Pilot",
                    "Airport Manager",
                    "Analyst",
                    "Chief Pilot",
                    "Traffic Manager"));


    private final int jobId;
    private final String description;
    private final List<String> jobTitle;

}
