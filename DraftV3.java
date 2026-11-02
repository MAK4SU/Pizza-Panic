import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DraftV3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Hi, Progress report at the bottom, please read it - RJ
        do {
            System.out.println("\n====================");
            System.out.println("        Menu        ");
            System.out.println("====================");
            System.out.println("1. Start!");
            System.out.println("2. Rules and Instructions");
            System.out.println("3. Credits");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            //Try catch for wrong inputs
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
                    //Customer growth settings
                    int days = 10;           // how many days in one run
                    int increment = 2;        // customers added each day
                    int customersToday = 1;   // customers on day 1
                    int maxPerDay = 10;       // the group never gets bigger than this
                    //TitleCard
                    System.out.println("===================");
                    System.out.println("    Pizza Panic    ");
                    System.out.println("===================");
                    for (int day = 1; day <= days; day++){
                        //Customer spawn cap
                        if (customersToday > maxPerDay) {
                            customersToday = maxPerDay;
                        }
                        System.out.println();
                        System.out.println("========================================");
                        System.out.println("DAY " + day + "  |  Customers today: " + customersToday);
                        System.out.println("========================================");
                        int dayStars = 0;
                        for (int c = 1; c <= customersToday; c++){
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

                            //Section 2: Make the Pizzeria | A lot of if and else statements
                            boolean[] orderMade = new boolean[5];
                            for (int i = 0; i < ingredients.length; i++){
                                valid = false;
                                //
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
                            //Check orderMade with customerType's order
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
                                            missingList = missingList + " ," + ingredients[i];
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
                                System.out.println("You were missing: " + missingList);
                            }
                            if(!wrongList.equals("")){
                                System.out.println("You got: " + wrongList + " wrong.");
                            }
                            //End of the Day Report | Calculations
                            int stars = 0;
                            if (mistakes == 0){
                                stars = 5;
                                System.out.println("Perfect " + selected.orderName + " pizza!");
                            } 
                            else if(mistakes == 1){
                                stars = 3;
                            }
                            else{
                                stars = 1;
                            }

                            //Customer Rating | Calculations
                            for(int i = 0; i < stars; i++){
                                System.out.print("[*]");
                            }
                            System.out.println(" (" + stars + " / 5 Stars)");
                            totalStars = totalStars + stars;
                            dayStars = dayStars + stars;
                            served = served + 1;
                        }

                        //End of Day report | Per day
                        System.out.println();
                        System.out.println("----------------------------------------");
                        System.out.println("End of Day " + day + " Report:");
                        System.out.println("  Served " + customersToday + " customers today");
                        System.out.println("  Stars today: " + dayStars + " / " + (customersToday * 5));
                        System.out.println("----------------------------------------");
                        for (int i = 0; i < 20; i++) {
                        System.out.println();
                        }
                        //Next day group increase until it caps out
                        if (customersToday < maxPerDay) {
                            customersToday = customersToday + increment;
                        }
                    }

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
                    System.out.println("                          FINAL REPORT");
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
                    System.out.println("[2] INPUT THE INGREDIENTS:");
                    System.out.println("    Type in all the required ingredients for that recipe.");
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
                    System.out.println("Enter ingredients: ham, pineapple");
                    System.out.println("");
                    System.out.println("Checking recipe...");
                    System.out.println("[SUCCESS] Perfect Hawaiian pizza!");
                    System.out.println("Customer Rating: ***** (5/5 Stars)");
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
                    System.out.println("Enter ingredients: pepperoni, sausage");
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

                    System.out.println("  - Hillary Joy De Jesus");
                    
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
Progress Report November 02:
Added: 
More than 1 customer per run, 10 days 10 max customers 
feel free to change between 10 or 15 depende which is better

Fixes:
Broke the customerLoop upon merging but I fixed it

Additional:
For the sake of organization, Some labels exist so you can Ctrl + F to search for sections of the code.
Next: The implementations of models. by November 03. 
Need to insert the models into prints and figure out the sizing issue
*/