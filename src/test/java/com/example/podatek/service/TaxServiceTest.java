package com.example.podatek.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TaxServiceTest {

    TaxService taxService;

    @BeforeEach
    void setUp() {
        taxService = new TaxService();
    }

    @Test
    void whenIncomeIsEqual85528_shouldTaxBeGreaterThan14839() {
        BigDecimal income = BigDecimal.valueOf(85528);
        BigDecimal expectedTax = BigDecimal.valueOf(14839.02);

        BigDecimal tax = taxService.getTax(income);

        assertThat(tax).isEqualTo(expectedTax);
    }

    @Test
    void whenIncomeIsGreaterThan85528_shouldTaxBeGreaterThan15159() {
        BigDecimal income = BigDecimal.valueOf(86528);
        BigDecimal expectedTax = BigDecimal.valueOf(15159.02);

        BigDecimal tax = taxService.getTax(income);

        assertThat(tax).isEqualTo(expectedTax);
    }

    @Test
    void whenIncomeIsEqualTen_shouldTaxBeEqualZero() {
        BigDecimal income = BigDecimal.valueOf(10);
        BigDecimal expectedTax = BigDecimal.valueOf(0);

        BigDecimal tax = taxService.getTax(income);

        assertThat(tax).isEqualTo(expectedTax);
    }
}