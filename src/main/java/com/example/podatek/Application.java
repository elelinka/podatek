package com.example.podatek;

import com.example.podatek.service.UserInputService;

import java.util.InputMismatchException;

public class Application {
    public static void main(String[] args) {

        System.out.println("Podaj swój przychód roczny:");
        try {
            String userInput = UserInputService.getIncomeFromUser();
            System.out.println(userInput);
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono błędne dane.");
        }

    }
}
