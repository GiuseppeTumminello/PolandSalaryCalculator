package com.acoustic.salarycalculator.jobscategories;


import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobsCategory {

    IT(1, "It", Map.ofEntries(Map.entry(1, "DevOps Engineer"),
            Map.entry(2, "Software Developer"),
            Map.entry(3, "Cloud System Engineer"),
            Map.entry(4, "Cloud Architect"),
            Map.entry(5, "Network Engineer"),
            Map.entry(6, "IT Support Specialist"),
            Map.entry(7, "Database Administrator"),
            Map.entry(8, "System Architect"),
            Map.entry(9, "Web Administrator"),
            Map.entry(10, "value-10"),
            Map.entry(11, "value-11"))),
    FINANCE(2, "Finance", Map.ofEntries(Map.entry(1, "Depositary"),
            Map.entry(2, "Fund Accountant"),
            Map.entry(3, "Accountant"),
            Map.entry(4, "Tax Analyst"),
            Map.entry(5, "Auditor"),
            Map.entry(6, "Risk Analyst"),
            Map.entry(7, "Business Analyst"),
            Map.entry(8, "Billing Administrator"),
            Map.entry(9, "Financial Controller"))),

    ENGINEER(3, "Engineer", Map.ofEntries(Map.entry(1, "Civil Engineer"),
            Map.entry(2, "Project Engineer"),
            Map.entry(3, "Test Engineer"),
            Map.entry(4, "Sales Engineer"),
            Map.entry(5, "R&D Engineer"),
            Map.entry(6, "Thermal Engineer"))),

    RESTAURANT(4, "Restaurant", Map.ofEntries(Map.entry(1, "Executive Chef"),
            Map.entry(2, "Assistant Manager"),
            Map.entry(3, "General Manager"),
            Map.entry(4, "Sous Chef"),
            Map.entry(5, "Kitchen Manager"),
            Map.entry(6, "Line Cook"),
            Map.entry(7, "Bartender"),
            Map.entry(8, "Cashier"),
            Map.entry(9, "Dishwasher"),
            Map.entry(10, "Waitress"))),
    AIRLINE(5, "Airline", Map.ofEntries(Map.entry(1, "Airline Captain"),
            Map.entry(2, "Airline Pilot"),
            Map.entry(3, "Airport Manager"),
            Map.entry(4, "Analyst"),
            Map.entry(5, "Chief Pilot"),
            Map.entry(6, "Traffic Manager")));


    private final int jobId;
    private final String description;
    private final Map<Integer, String> jobTitle;

}
