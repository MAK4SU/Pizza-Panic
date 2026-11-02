import java.util.Scanner;

public class CustomerGrowth {
    public static void main(String[] args) {
        int days = 15;
        int increment = 2;
        int customersToday = 2;
        int maxPerDay = 15;

        System.out.println("===== CUSTOMER GROWTH SYSTEM =====");
        System.out.println("Start: " + customersToday + " customers");
        System.out.println("Daily increase: +" + increment + " customers");
        System.out.println("Max per day: " + maxPerDay + " customers");
        System.out.println("Total days: " + days + "\n");

        for (int day = 1; day <= days; day++) {
            if (customersToday > maxPerDay) {
                customersToday = maxPerDay;
            }

            System.out.println("----------------------------------------");
            System.out.println("DAY " + day);
            System.out.println("----------------------------------------");
            System.out.println("Customers today: " + customersToday);

            for (int c = 1; c <= customersToday; c++) {
                System.out.println("  Processing Customer " + c + "...");
            }

            System.out.println("\nEnd of Day " + day + " Report:");
            System.out.println("  Served " + customersToday + " customers today");
            System.out.println("----------------------------------------\n");

            if (customersToday < maxPerDay) {
                customersToday += increment;
            }
        }

        System.out.println("========================================");
        System.out.println("All " + days + " days completed!");
        System.out.println("Final Total: " + maxPerDay + " customers (max reached)");
        System.out.println("========================================");
    }
}
