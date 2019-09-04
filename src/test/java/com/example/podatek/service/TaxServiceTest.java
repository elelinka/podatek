package com.example.podatek.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaxServiceTest {

    TaxService taxService;

    @BeforeEach
    void setUp() {
        taxService = new TaxService();
    }

    @Test
    void whenIncomeIsEqual85528_shouldTaxBeEqual14839() {
        int income = 85528;
        int expectedTax = 14839;

        int tax = taxService.countTaxForLessIncome(income);

        assertThat(tax).isEqualTo(expectedTax);
    }

    @Test
    void whenIncomeIsGreaterThan85528_shouldTaxBeEqual15159() {
        int income = 86528;
        int expectedTax = 15159;

        int tax = taxService.countTaxForGreaterIncome(income);

        assertThat(tax).isEqualTo(expectedTax);
    }
}