package org.example.MapApproch;

public enum Operation {
    PENSION_ZUS("Pension zus"),
    DISABILITY_ZUS("Disability zus"),
    SICKNESS_ZUS("Sickness zus"),
    TOTAL_ZUS("Total zus"),
    HEALTH("Health zus"),
    GROSS_YEARLY("Gross zus"),
    TAX("Tax"),
    NET("Net monthly"),
    NET_YEARLY("Yearly net");

    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
