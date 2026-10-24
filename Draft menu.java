import java.util.Scanner;

public class DraftMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====================:");
            System.out.println("        Menu        :");
            System.out.println("====================:");
            System.out.println("1. Start!");
            System.out.println("2. Rules");
            System.out.println("3. Guide");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Option 1.");
                    break;
                case 2:
                    System.out.println("You selected Option 2.");
                    break;
                case 3:
                    System.out.println("You selected Option 3.");
                    break;
                case 4:
                    System.out.println("Exiting the menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
