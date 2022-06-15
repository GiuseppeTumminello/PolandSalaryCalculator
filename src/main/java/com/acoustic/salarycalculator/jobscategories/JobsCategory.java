package com.acoustic.salarycalculator.jobscategories;


import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum JobsCategory {

    IT(1, "It", Map.of(
            1,
            "DevOps Engineer",
            2,
            "Software Developer",
            3,
            "Cloud System Engineer",
            4,
            "Cloud Architect",
            5,
            "Network Engineer",
            6,
            "IT Support Specialist",
            7,
            "Database Administrator",
            8,
            "System Architect",
            9,
            "Web Administrator",
            10,
            "Software Engineer")),
    FINANCE(2, "Finance", Map.of(
            1,
            "Depositary",
            2,
            "Fund Accountant",
            3,
            "Accountant",
            4,
            "Tax Analyst",
            5,
            "Auditor",
            6,
            "Risk Analyst",
            7,
            "Business Analyst",
            8,
            "Billing Administrator",
            9,
            "Financial Controller")),

    ENGINEER(3, "Engineer", Map.of(
            1,
            "Civil Engineer",
            2,
            "Project Engineer",
            3,
            "Test Engineer",
            4,
            "Sales Engineer",
            5,
            "R&D Engineer",
            6,
            "Thermal Engineer")),

    RESTAURANT(4, "Restaurant", Map.of(
            1,
            "Executive Chef",
            2,
            "Assistant Manager",
            3,
            "General Manager",
            4,
            "Sous Chef",
            5,
            "Kitchen Manager",
            6,
            "Line Cook",
            7,
            "Bartender",
            8,
            "Cashier",
            9,
            "Dishwasher",
            10,
            "Waitress")),
    AIRLINE(5, "Airline", Map.of(
            1,
            "Airline Captain",
            2,
            "Airline Pilot",
            3,
            "Airport Manager",
            4,
            "Analyst",
            5,
            "Chief Pilot",
            6,
            "Traffic Manager"));


    private final int jobId;
    private final String description;
    private final Map<Integer, String> jobTitle;

}
