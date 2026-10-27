import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DraftV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //Hi, Progress report at the bottom - RJ
        //Rename DraftCustomer into Customer for testing, has to be in the same folder.
        do {
            System.out.println("\n====================");
            System.out.println("        Menu        ");
            System.out.println("====================");
            System.out.println("1. Start!");
            System.out.println("2. Rules and Instructions");
            System.out.println("3. Credits");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");

            try{
            choice = scanner.nextInt();
            }
            catch(InputMismatchException error){
                scanner.next();
                choice = 0;
            }
            //Choices Section
            switch (choice) {
                case 1:
                    for (int i = 0; i < 20; i++) {
                        System.out.println();
                    }

                    System.out.print("\nLoading the game");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(".");
                    //Initialization | Gameplay Section
                    Random rand = new Random();
                    //customerTypes reorganized here into allOrders
                    //Values order: name, order, pepperoni, sausage, pineapple, ham, mushroom
                    //We should probably give them actual names instead of just "Customer #"
                    Customer[] allOrders = {
                        new Customer("Customer 1", "Pepperoni", true, false, false, false, false),
                        new Customer("Customer 2", "Sausage", false, true, false, false, false),
                        new Customer("Customer 3", "Pineapple", false, false, true, false, false),
                        new Customer("Customer 4", "Ham", false, false, false, true, false),
                        new Customer("Customer 5", "Mushroom", false, false, false, false, true),
                        new Customer("Customer 6", "Hawaiian", false, false, true, true, false),
                        new Customer("Customer 7", "Meat Lover", true, true, false, true, false),
                        new Customer("Customer 8", "Subterranean", false, true, false, false, true)
                    };
                    String[] ingredients = {"pepperoni", "sausage", "pineapple", "ham", "mushroom"};
                    //Gameplay stuffs
                    int totalStars = 0;
                    int served = 0; 
                    String playAgain = "y";
                    //TitleCard
                    System.out.println("===================");
                    System.out.println("    Pizza Panic    ");
                    System.out.println("===================");
                    do{
                        //Hardset a few things for initial gameplay run
                        String answer = "";
                        boolean valid = false;
                        //Random for customerType index, there's 8 types
                        int customerType = rand.nextInt(8);
                        Customer selected = allOrders[customerType];
                        // wanted[i] is true if customer wants ingredients[i], 
                        // copied from a selected customer's stored booleans, same order as ingredients
                        boolean[] wanted = new boolean[5];
                        wanted[0] = selected.hasPepperoni;
                        wanted[1] = selected.hasSausage;
                        wanted[2] = selected.hasPineapple;
                        wanted[3] = selected.hasHam;
                        wanted[4] = selected.hasMushroom;  
                        //Dialogue goes here, Sample first, 
                        System.out.println("======================================");
                        System.out.println(selected.customerName + " would like: " + selected.orderName + " pizza.");
                        System.out.println("======================================");

                        //Make the Pizza | y/n per ingredient
                        boolean[] orderMade = new boolean[5];
                        for (int i = 0; i < ingredients.length; i++){
                            valid = false;

                            while(!valid){
                                System.out.print("Add " + ingredients[i] + "? (y/n): ");
                                answer = scanner.next().toUpperCase();
                                //if-else logic
                                if(answer.equals("Y")){
                                    orderMade[i] = true;
                                    valid = true;
                                }
                                else if(answer.equals("N")){
                                    valid = true;
                                }
                                else{
                                    System.out.println("Please enter y or n");
                                }
                            }
                        }
                        //Check orderMade with selected customer's order
                        System.out.println();
                        //You can add delays for the dots, this just does it instantly
                        //Recipe Check | Basically makes the list for printing later
                        System.out.println("Checking recipe...");
                        String correctList = "";
                        String missingList = "";
                        String wrongList = "";
                        int mistakes = 0;
                        for(int i = 0; i < ingredients.length; i++){
                            if(orderMade[i] != wanted[i]){
                                mistakes++;
                                //Wanted but missing
                                if(wanted[i]){
                                    if(missingList.equals("")){
                                        missingList = ingredients[i];
                                    }
                                    else{
                                        missingList = missingList + ", " + ingredients[i];
                                    }
                                }
                                //Added but not wanted
                                else{
                                    if(wrongList.equals("")){
                                        wrongList = ingredients[i];
                                    }
                                    else{
                                        wrongList = wrongList + ", " + ingredients[i];
                                    }
                                }
                            }
                            //Matching wants with what's there
                            else{
                                if(wanted[i]){
                                    if(correctList.equals("")){
                                        correctList = ingredients[i];
                                    }
                                    else{
                                        correctList = correctList + ", " + ingredients[i];
                                    }
                                }
                            }
                        }
                        /*This prints everything in one line instead of:
                        Correct: Ham
                        Correct: Pineapple
                        Wrong: Sausage
                        etc*/
                        if(!correctList.equals("")){
                            System.out.println("You got: " + correctList + " right.");
                        }
                        if(!missingList.equals("")){
                            System.out.println("[WARNING] Missing ingredient: " + missingList + "!");
                        }
                        if(!wrongList.equals("")){
                            System.out.println("You added the wrong ingredients: " + wrongList);
                        }
                        //Customer Rating | Star Calculations
                        int stars = 0;
                        if (mistakes == 0){
                            stars = 5;
                            System.out.println("[SUCCESS] Perfect " + selected.orderName + " pizza!");
                        } 
                        else if(mistakes == 1){
                            stars = 3;
                        }
                        else{
                            stars = 1;
                        }

                        //Customer Rating | Display
                        for(int i = 0; i < stars; i++){
                            System.out.print("[*]");
                        }
                        System.out.println(" (" + stars + " / 5 Stars)");
                        totalStars = totalStars + stars;
                        served = served + 1;

                        //Play again prompt
                        valid = false;
                        while(!valid){
                        System.out.println("Play again? (y/n): ");
                        playAgain = scanner.next().toUpperCase();
                        if(playAgain.equals("Y") || playAgain.equals("N")){
                            valid = true;
                        }
                        else{
                            System.out.println("Please enter y or n: ");
                        }
                        }
                    } while(!playAgain.equals("N"));

                    //End of the Day Report, idk if I got the titles right
                    double avg = (double) totalStars/served;
                    String rank = "";
                    if(avg >= 4.5){
                        rank = "Master Chef";
                    }
                    else if(avg >= 3.0){
                        rank = "Line Cook";
                    }
                    else{
                        rank = "Trainee";
                    }

                    System.out.println();
                    System.out.println("===================================================================");
                    System.out.println("                        END OF DAY REPORT");
                    System.out.println("===================================================================");
                    System.out.println("Total Customers Served: " + served);
                    System.out.println("Total Stars Earned: " + totalStars + " / " + (served * 5));
                    System.out.printf("Average Rating: %.1f / 5.0%n", avg);
                    System.out.println("Final Rank: " + rank);
                    System.out.println("===================================================================");
                    break;
                    //Maybe add a short delay before the break so you can read the end report before seeing the menu again.


                case 2:
                    System.out.println("===================================================================");
                    System.out.println("                    PIZZA PANIC - PLAYER GUIDE                     ");
                    System.out.println("===================================================================");
                    System.out.println("");
                    System.out.println("WELCOME TO PIZZA PANIC!");
                    System.out.println("Customers are hungry, orders are coming in fast, and it is up to ");
                    System.out.println("you to assemble every pizza correctly before your shift ends.");
                    System.out.println("");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                           HOW TO PLAY");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("[1] RECEIVE THE ORDER:");
                    System.out.println("    A customer will arrive and ask for a specific pizza type ");
                    System.out.println("    (e.g., Hawaiian, Meat Lovers, or Sausage Mushroom).");
                    System.out.println("");
                    System.out.println("[2] ADD THE INGREDIENTS:");
                    System.out.println("    The game asks you about each ingredient, for example:");
                    System.out.println("    Add ham? (y/n): ");
                    System.out.println("    Type y to add it, or n to leave it off.");
                    System.out.println("");
                    System.out.println("[3] AVAILABLE INGREDIENTS LIST:");
                    System.out.println("    - pepperoni");
                    System.out.println("    - sausage");
                    System.out.println("    - ham");
                    System.out.println("    - pineapple");
                    System.out.println("    - mushroom");
                    System.out.println("");

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                        PIZZA MENU & RECIPES");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("| PIZZA NAME        | REQUIRED INGREDIENTS                        |");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("| Meat Lovers       | pepperoni, sausage, ham                     |");
                    System.out.println("| Hawaiian          | ham, pineapple                              |");
                    System.out.println("| Sausage Mushroom  | sausage, mushroom                           |");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("");
                    System.out.println("Note: Leaving out an ingredient or adding an incorrect ingredient ");
                    System.out.println("will lower your score for that order.");
                    System.out.println("");

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                           SCORING SYSTEM");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("After submitting your ingredients, the customer will rate your ");
                    System.out.println("pizza out of 5 stars:");
                    System.out.println("");
                    System.out.println("- [5 / 5 Stars] PERFECT! All correct ingredients included.");
                    System.out.println("- [3 / 5 Stars] PARTIAL! Missing an ingredient or added wrong one.");
                    System.out.println("- [1 / 5 Star ] INCORRECT! Wrong recipe entirely.");
                    System.out.println("");

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                        END OF DAY SUMMARY");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("At the end of your shift (after serving all customers for the day):");
                    System.out.println("- The game will calculate your Total Stars and Average Rating.");
                    System.out.println("- Performance Ranks:");
                    System.out.println("    * 4.5 - 5.0 Stars: Master Chef");
                    System.out.println("    * 3.0 - 4.4 Stars: Line Cook");
                    System.out.println("    * Below 3.0 Stars: Trainee");
                    System.out.println("");
                    
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("===================================================================");
                    System.out.println("                         EXAMPLE GAMEPLAY");
                    System.out.println("===================================================================");
                    System.out.println("");
                    System.out.println("Customer #1: \"Hi! I would like a Hawaiian pizza, please!\"");
                    System.out.println("");
                    System.out.println("Add pepperoni? (y/n): n");
                    System.out.println("Add sausage? (y/n): n");
                    System.out.println("Add pineapple? (y/n): y");
                    System.out.println("Add ham? (y/n): y");
                    System.out.println("Add mushroom? (y/n): n");
                    System.out.println("");
                    System.out.println("Checking recipe...");
                    System.out.println("[SUCCESS] Perfect Hawaiian pizza!");
                    System.out.println("Customer Rating: [*][*][*][*][*] (5/5 Stars)");
                    System.out.println("");

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Customer #2: \"Give me a Meat Lovers!\"");
                    System.out.println("");
                    System.out.println("Add pepperoni? (y/n): y");
                    System.out.println("Add sausage? (y/n): y");
                    System.out.println("Add pineapple? (y/n): n");
                    System.out.println("Add ham? (y/n): y");
                    System.out.println("Add mushroom? (y/n): n");
                    System.out.println("");
                    System.out.println("Checking recipe...");
                    System.out.println("[WARNING] Missing ingredient: ham!");
                    System.out.println("Customer Rating: *** (3/5 Stars)");
                    System.out.println("");

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("===================================================================");
                    System.out.println("                        END OF DAY REPORT");
                    System.out.println("===================================================================");
                    System.out.println("Total Customers Served: 2");
                    System.out.println("Total Stars Earned: 8 / 10");
                    System.out.println("Average Rating: 4.0 / 5.0 Stars");
                    System.out.println("Final Rank: Line Cook");
                    System.out.println("===================================================================");
                    break;



                case 3:
                    System.out.println("===================================================================");
                    System.out.println("                      PIZZA PANIC - CREDITS                         ");
                    System.out.println("===================================================================");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("                  DEVELOPMENT & PRODUCTION TEAM                    ");
                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("  MAIN PROGRAM LOGIC & SYSTEM ARCHITECTURE");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("  - Marcus Jamir G. Rufin");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("");
                    System.out.println("  ORDER VALIDATION & QUALITY ASSURANCE");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("  - Reiben John Calumag");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("");
                    System.out.println("  CUSTOMER DIALOG & REQUEST ENCODER");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println(" - Hillary Joy De Jesus");
                    
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("");
                    System.out.println("  PIZZA RECIPE & MENU DESIGN");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("  - Dion Michael Literato");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                Thank you for playing Pizza Panic!");
                    System.out.println("===================================================================");
                    break;



                case 4:
                    System.out.println("Exiting the menu.");
                    break;



                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);



        scanner.close();
    }
}
/*
Progress Report October 27:
Added: 
Merged the customerList into Gameplay, 
Put Gameplay into case 1 for Main
Made it so the corrects/mistakes actually print in one line and not in multiple.
Try-catch for the switch case scanner input since if you type a letter on the menu, it crashes.

Fixes:
Fixed the while part at the end so it continues running unless you Exit
Adjusted the Draft Customer variables to match with DraftGameV1's

Additional:
For the sake of organization, SOme labels exist so you can Ctrl + F to search for sections of the code.
Once we're finalizing stuff na, I'll fix the comments/remove these sections of yapping
Next task: Yung random(?) number of customers per gameplay loop instead na singles lang.
The implementations of models too.
*/
