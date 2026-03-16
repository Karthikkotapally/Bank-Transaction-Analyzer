package com.blank.transaction_analyzer.dto;

public class MonthlySummaryDTO {

    private double totalDebit;
    private double totalCredit;

    public MonthlySummaryDTO(double totalDebit, double totalCredit) {
        this.totalDebit = totalDebit;
        this.totalCredit = totalCredit;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public double getTotalCredit() {
        return totalCredit;
    }
}