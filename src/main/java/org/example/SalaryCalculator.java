package org.example;

public class SalaryCalculator {
    private final double zusPensionRate;
    private final double zusDisabilityRate;
    private final double zusSicknessRate;
    private final double healthNFZRate;
    private double gross;
    private int taxRate;

    public SalaryCalculator(double gross) {

        this.zusPensionRate = 9.76d;
        this.zusDisabilityRate = 1.50d;
        this.zusSicknessRate = 2.45d;
        this.healthNFZRate = 9.0d;
        this.gross  = gross;
        if (gross * 12 > 120_000.0){
            this.taxRate = 32;
        } else {
            this.taxRate = 17;
        }
    }



    public double getZusTotal() {
        return getZusDisability() + getZusPension() + getZusSickness();

    }

    public double getHealthNfzTotal() {
        return (this.gross - getZusTotal()) * healthNFZRate / 100;
    }

    public double getAdvancePaymentTotal() {
        if (this.gross * 12 < 120_000.00) {
            this.taxRate = 17;
            return (this.gross - (getHealthNfzTotal() + getZusTotal())) * 8.32d / 100;

        } else {
            this.taxRate = 32;
            return (this.gross - (getHealthNfzTotal() + getZusTotal())) * 14.32d / 100;
        }
    }


    public double getNet() {
        return this.gross - (getZusTotal() + getHealthNfzTotal() + getAdvancePaymentTotal());

    }

    public double getZusPension() {
        return this.gross * zusPensionRate / 100;
    }

    public double getZusDisability() {
        return this.gross * zusDisabilityRate / 100;

    }

    public double getZusSickness() {

        return this.gross * zusSicknessRate / 100;

    }


    public double getAnnualSum(){
        return this.gross * 12;
    }


    public double getZusPensionRate() {
        return zusPensionRate;
    }

    public double getZusDisabilityRate() {
        return zusDisabilityRate;
    }

    public double getZusSicknessRate() {
        return zusSicknessRate;
    }

    public double getHealthNFZRate() {
        return healthNFZRate;
    }

    public double getGross() {
        return gross;
    }

    public int getTaxRate() {
        return taxRate;
    }



}
