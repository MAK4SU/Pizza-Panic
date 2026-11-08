import java.util.Scanner;
import java.util.InputMismatchException;
public class PizzaLogicExtra {
    //Short delay so text does not appear all at once (same as the one in the main file)
    static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    static void exitConfirmation(int choice){
        Scanner scanner = new Scanner(System.in);
        for (int s = 0;s < 60; s++) {
                System.out.println();
            }
        boolean answered = false;
        while(!answered){
            System.out.println("Are you sure you want to exit?");
            System.out.println("[1] Yes, Exit the game");
            System.out.println("[2] No, Resume the game");
            try {
                int confirm = scanner.nextInt();
                if(confirm == 1){
                    System.out.print("Exiting the game");
                    pause(700);
                    System.out.print(".");
                    pause(700);
                    System.out.print(".");
                    pause(700);
                    System.out.print(".");

                    answered = true;
                }
                else if(confirm == 2){
                    
                    for (int s = 0;s < 60; s++) {
                        System.out.println();
                    }
                    choice = 0;
                    answered = true;
                }
                else{
                    System.out.println("Please enter 1 or 2.");
                }
            } catch(InputMismatchException e) {
                scanner.next(); // Clear the invalid input
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
