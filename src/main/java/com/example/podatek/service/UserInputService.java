package com.example.podatek.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInputService {

    public static String getIncomeFromUser() throws InputMismatchException {
        TaxService taxService = new TaxService();
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        BigDecimal income = BigDecimal.valueOf(input.nextDouble());
        input.nextLine();
        input.close();

        BigDecimal roundedIncome = income.round(new MathContext(income.toBigInteger().toString().length(), RoundingMode.HALF_UP));
        BigDecimal tax = taxService.getTax(roundedIncome);
        BigDecimal roundedTax = tax.round(new MathContext(tax.toBigInteger().toString().length(), RoundingMode.HALF_UP));

        return "Podatek do zapłaty (w zaokrągleniu do pełnych zł): " + roundedTax.toPlainString();
    }
}
