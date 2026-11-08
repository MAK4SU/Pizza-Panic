import java.util.Scanner;
public class PizzaStory {
    static void waitForEnter(Scanner sc) {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }
    static void storyPrologue(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("For as long as you can remember, " + name + ", you`ve dreamed of a pizzeria with your name on the door.");
        System.out.println("You get to be your own boss, with nobody to order you around.");
        System.out.println("Today, after years of saving every coin, you finally hold the keys to a tiny shop on Merrywell Street in Portland.");
        waitForEnter(scanner);
        System.out.println();
        System.out.println();
        System.out.println("Your landlord, Mr. Louie, stops by offering a handshake."); 
        System.out.println("Congratulations, " + name + ". Rent is due every day, no exceptions.");
        System.out.println("You gulp. Being your own boss means no one covers for you.");
        waitForEnter(scanner);
        System.out.println();
        System.out.println();
        System.out.println("You`re also the only employee. Taking orders, making the pizza, and serving every customer yourself.");
        System.out.println("It`s exhausting sure, but that`s the thrill of it.");
        System.out.println("You don your apron and flip the sign on the door - OPEN");
        waitForEnter(scanner);
        System.out.println();
    }
}
