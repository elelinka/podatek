package com.example.podatek.service;

import java.math.BigDecimal;

public class TaxService {

    public static final BigDecimal LESS_TAX = BigDecimal.valueOf(0.18);
    public static final BigDecimal GREATER_TAX = BigDecimal.valueOf(0.32);
    public static final BigDecimal AMOUNT_TO_SUBTRACT_FROM_LESS_TAX = BigDecimal.valueOf(556.02);
    public static final BigDecimal AMOUNT_TO_ADDED_TO_GREATER_TAX = BigDecimal.valueOf(14839.02);
    public static final BigDecimal MAX_INCOME_FOR_LESS_TAX = BigDecimal.valueOf(85528);
    public static final BigDecimal TAX_FREE_ALLOWANCE = BigDecimal.valueOf(3091);

    public BigDecimal getTax(BigDecimal income) {
        BigDecimal tax = BigDecimal.valueOf(0);

        if (income.compareTo(TAX_FREE_ALLOWANCE) > 0) {
            if (income.compareTo(MAX_INCOME_FOR_LESS_TAX) <= 0) {
                tax = countTaxForLessIncome(income);
                return tax;
            } else {
                tax = countTaxForGreaterIncome(income);
                return tax;
            }
        }
        return tax;
    }

    private BigDecimal countTaxForLessIncome(BigDecimal income) {
        BigDecimal tax = income.multiply(LESS_TAX).subtract(AMOUNT_TO_SUBTRACT_FROM_LESS_TAX);
        return tax;
    }

    private BigDecimal countTaxForGreaterIncome(BigDecimal income) {
        BigDecimal tax = income.subtract(MAX_INCOME_FOR_LESS_TAX).multiply(GREATER_TAX).add(AMOUNT_TO_ADDED_TO_GREATER_TAX);
        return tax;
    }
}
