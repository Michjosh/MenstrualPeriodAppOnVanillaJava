package PresentationLayer;

import ServiceLayer.MenstrualPeriodService;
import ServiceLayer.MenstrualPeriodServiceImpl;

import java.util.Scanner;

public class MenstrualPeriodApp {

    private static Scanner scanner = new Scanner(System.in);
    private static MenstrualPeriodService menstrualPeriodService = new MenstrualPeriodServiceImpl();

    public static void main(String[] args) {
        System.out.println("Welcome to the Menstrual Period App!");

        while (true) {
            System.out.println("Please enter the date of your last period (YYYY-MM-DD):");
            String lastPeriodDate = scanner.nextLine();

            System.out.println("Please enter the length of your menstrual cycle (in days):");
            int cycleLength = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter the length of your period (in days):");
            int periodLength = Integer.parseInt(scanner.nextLine());

            // Call the application layer to calculate the next period date
            String nextPeriodDate = menstrualPeriodService.calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
            System.out.println("Your next period is expected on: " + nextPeriodDate);

            // Call the application layer to get a one-year list of estimated period dates
            String[] estimatedPeriodDates = menstrualPeriodService.getEstimatedPeriodDates(nextPeriodDate, cycleLength, periodLength);
            System.out.println("Here are your estimated period dates for the 6 months:");

            for (String date : estimatedPeriodDates) {
                System.out.println(date);
            }

            System.out.println("Do you want to calculate another period? (y/n)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thank you for using the Menstrual Period App!");
    }
}
