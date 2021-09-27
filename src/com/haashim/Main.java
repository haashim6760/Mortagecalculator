package com.haashim;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        var mortgage = new Mortgage();

        System.out.println("Mortgage calculator");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal(£1K-£1M): ");
            mortgage.principal = scanner.nextInt();
            if (mortgage.principal >= 1000 && mortgage.principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual interest rate: ");
            mortgage.aInterestRate = scanner.nextFloat();
            mortgage.mInterestRate = mortgage.aInterestRate / 100 / 12;
            if (mortgage.aInterestRate > 0 && mortgage.aInterestRate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal than 30");
        }

        while (true) {
            System.out.print("Period(years): ");
            mortgage.period = scanner.nextInt();
            if (mortgage.period >= 1 && mortgage.period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        mortgage.numberOfPayments = mortgage.period * 12;

        mortgage.fullMortgage = (int) (mortgage.principal * (mortgage.mInterestRate * Math.pow(1 + mortgage.mInterestRate, mortgage.numberOfPayments))
        / (Math.pow(1 + mortgage.mInterestRate, mortgage.numberOfPayments) - 1));

        String FullMortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage.fullMortgage);
        System.out.println("Mortgage: " + FullMortgageFormatted);

    }
}
