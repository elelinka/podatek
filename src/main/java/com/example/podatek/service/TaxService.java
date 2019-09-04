package com.example.podatek.service;

public class TaxService {

    public static final double LESS_TAX = 0.18;
    public static final double GREATER_TAX = 0.32;
    public static final double AMOUNT_TO_SUBTRACT_FROM_LESS_TAX = 556.02;
    public static final double AMOUNT_TO_ADDED_TO_GREATER_TAX = 14839.02;
    public static final int MAX_INCOME = 85528;

    public int countTaxForLessIncome(int income) {
        return (int) ((income * LESS_TAX) - AMOUNT_TO_SUBTRACT_FROM_LESS_TAX);
    }

    public int countTaxForGreaterIncome(int income) {
        return (int) (AMOUNT_TO_ADDED_TO_GREATER_TAX + ((income - MAX_INCOME) * GREATER_TAX));
    }
}
