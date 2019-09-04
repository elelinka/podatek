package com.example.podatek.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputService {

    public static final int MAX_INCOME = 85528;

    public static String getIncomeFromUser() throws InputMismatchException {
        TaxService taxService = new TaxService();
        Scanner input = new Scanner(System.in);
        double income = input.nextDouble();
        input.nextLine();
        input.close();
        int tax;

        if (income <= MAX_INCOME) {
            tax = taxService.countTaxForLessIncome((int) income);
            return "Podatek do zapłaty (w zaokrągleniu do pełnych zł): " + tax;
        } else {
            tax = taxService.countTaxForGreaterIncome((int) income);
            return "Podatek do zapłaty (w zaokrągleniu do pełnych zł): " + tax;
        }
    }
}
