package com.acoustic.salarycalculator.jobscategories;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobsCategory {

    IT(1, "It", new ArrayList<>(List.of("DevOps Engineer",
            "Software Developer",
            "Software Engineer",
            "Cloud System Engineer",
            "Cloud Architect",
            "IT Analyst",
            "Network Engineer",
            "IT Support Specialist",
            "Database Administrator",
            "System Architect",
            "Web Administrator"))),
    FINANCE(2, "Finance", new ArrayList<>(List.of("Fund Accountant",
            "Depositary",
            "Accountant",
            "Tax Analyst",
            "Auditor",
            "Risk Analyst",
            "Business Analyst",
            "Billing Administrator",
            "Financial Controller"))),
    ENGINEER(3, "Engineer", new ArrayList<>(List.of("Mechanic Engineer",
            "Civil Engineer",
            "Project Engineer",
            "Test Engineer",
            "Sales Engineer",
            "R&D Engineer",
            "Thermal Engineer "))),
    RESTAURANT(4, "Restaurant", new ArrayList<>(List.of("Executive Chef",
            "Assistant Manager",
            "General Manager",
            "Sous Chef",
            "Pastry Chef",
            "Kitchen Manager",
            "Line Cook",
            "Bartender",
            "Cashier",
            "Dishwasher",
            "Waitress"))),
    AIRLINE(5, "Airline", new ArrayList<>(List.of("Air Crew",
            "Airline Captain",
            "Airline Pilot",
            "Airport Manager",
            "Analyst",
            "Chief Pilot",
            "Traffic Manager")));


    private final int jobId;
    private final String description;
    private final List<String> jobTitle;

}
