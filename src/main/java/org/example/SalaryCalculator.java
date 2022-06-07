package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryCalculator {
    private final double zusPensionRate;
    private final double zusDisabilityRate;
    private final double zusSicknessRate;
    private final double healthNFZRate;
    private final BigDecimal gross;
    private int taxRate;

    public SalaryCalculator(BigDecimal gross) {

        this.zusPensionRate = 9.76d;
        this.zusDisabilityRate = 1.50d;
        this.zusSicknessRate = 2.45d;
        this.healthNFZRate = 9.0d;
        this.gross = gross;
        if (gross == null || gross.compareTo(BigDecimal.valueOf(2000.00)) < 0.0){
            System.out.println("Null value or Value less than 2000.00 cannot be passed");
        }
        else if (gross.multiply(BigDecimal.valueOf(12.0)).compareTo(BigDecimal.valueOf(120_000.00d)) > 0.0d) {
            this.taxRate = 32;
        } else {
            this.taxRate = 17;
        }
    }


    public BigDecimal getZusTotal() {
        return getZusDisability()
                .add(getZusPension())
                .add(getZusSickness())
                .setScale(2, RoundingMode.HALF_EVEN);

    }

    public BigDecimal getHealthNfzTotal() {
        return this.gross.subtract(getZusTotal())
                .multiply(BigDecimal.valueOf(healthNFZRate))
                .divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_EVEN);

    }

    public BigDecimal getAdvancePaymentTotal() {
        if (this.getAnnualSum().compareTo(BigDecimal.valueOf(120_000.00)) < 0) {
            this.taxRate = 17;
            return (this.gross.subtract((getHealthNfzTotal().add(getZusTotal()))))
                    .multiply(BigDecimal.valueOf(8.32d))
                    .divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                    .setScale(2, RoundingMode.HALF_EVEN);

        } else {
            this.taxRate = 32;
            return (this.gross.subtract((getHealthNfzTotal().add(getZusTotal()))))
                    .multiply(BigDecimal.valueOf(14.32d)).divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
    }


    public BigDecimal getNet() {
        return this.gross.subtract(getZusTotal()
                .add(getHealthNfzTotal())
                .add(getAdvancePaymentTotal()))
                .setScale(2, RoundingMode.HALF_EVEN);

    }

    public BigDecimal getZusPension() {
        return this.gross.multiply(BigDecimal.valueOf(zusPensionRate))
                .divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getZusDisability() {
        return this.gross.multiply(BigDecimal.valueOf(zusDisabilityRate))
                .divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_EVEN);


    }

    public BigDecimal getZusSickness() {
        return this.gross.multiply(BigDecimal.valueOf(zusSicknessRate))
                .divide(BigDecimal.valueOf(100.0d), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_EVEN);

    }


    public BigDecimal getAnnualSum() {
        return this.gross.multiply(BigDecimal.valueOf(12.0d))
                .setScale(2, RoundingMode.HALF_EVEN);
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

    public BigDecimal getGross() {
        return gross;
    }

    public int getTaxRate() {
        return taxRate;
    }


}
