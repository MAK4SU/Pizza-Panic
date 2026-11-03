import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PizzaPanic {
    //Short delay so text does not appear all at once
    static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //Waits for the player to press Enter
    static void waitForEnter(Scanner sc) {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    //Connects each customer order to its matching ASCII art in PizzaArt.java
    static void showPizza(String orderName) {
        switch (orderName) {
            case "Mushroom":     PizzaArt.part1(); break;
            case "Pepperoni":    PizzaArt.part2(); break;
            case "Pineapple":    PizzaArt.part3(); break;
            case "Sausage":      PizzaArt.part4(); break;
            case "Meat Lover":   PizzaArt.part5(); break;
            case "Hawaiian":     PizzaArt.part6(); break;
            case "Ham":          PizzaArt.part7(); break;
            case "Subterranean": PizzaArt.part9(); break;
            case "Cheese":       PizzaArt.part8(); break;
            default: break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
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
                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }

                    System.out.print("\n       Loading the game");

                    pause(1000);
                    System.out.print(".");
                    pause(1000);
                    System.out.print(".");
                    pause(1000); 
                    
                    System.out.println(".");

                    pause(1000);

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
                        new Customer("Customer 8", "Subterranean", false, true, false, false, true),
                        new Customer("Customer 9", "Cheese", false, false, false, false, false)
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
                            pause(1000);
                    //TitleCard
                    
                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }

                    System.out.println("===================");
                    System.out.println("    Pizza Panic    ");
                    System.out.println("===================");
                    for (int day = 1; day <= days; day++){
                        //Customer spawn cap
                        if (customersToday > maxPerDay) {
                            customersToday = maxPerDay;
                        }
                        
                            pause(1000);
                        System.out.println();
                        System.out.println("========================================");
                        System.out.println("DAY " + day + "  |  Customers today: " + customersToday);
                        System.out.println("========================================");

                        pause(1000);
                        int dayStars = 0;
                        for (int c = 1; c <= customersToday; c++){
                            //Hardset a few things for initial gameplay run
                            String answer = "";
                            boolean valid = false;
                            //Random for customerType index, there's 9 types (picks from the whole allOrders list)
                            int customerType = rand.nextInt(allOrders.length);
                            Customer selected = allOrders[customerType];
                            // wanted[i] is true if customer wants ingredients[i], 
                            // copied from a selected customer's stored booleans, same order as ingredients
                            boolean[] wanted = new boolean[5];
                            wanted[0] = selected.hasPepperoni;
                            wanted[1] = selected.hasSausage;
                            wanted[2] = selected.hasPineapple;
                            wanted[3] = selected.hasHam;
                            wanted[4] = selected.hasMushroom;  

                            pause(2000);
                            System.out.println("======================================");
                            System.out.println(selected.customerName + " would like: " + selected.orderName + " pizza.");
                            System.out.println("======================================");
                            //Shows the ASCII art of the pizza the customer ordered (from PizzaArt.java)
                            pause(5000);
                            showPizza(selected.orderName);
                            pause(3000);

                            //Make the Pizzeria | Put the Ingredients in
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

                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }
                            //Recipe Check | List check
                            System.out.print("Checking recipe");

                                pause(800);
                                
                            System.out.print(".");
                                pause(800);
                                
                            System.out.print(".");
                                pause(800);
                                
                            System.out.println(".");

                                pause(800);
                            String correctList = "";
                                pause(800);
                            String missingList = "";
                                pause(800);
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
                            //Makes the list for Correct, Missing, and Wrong ingredients
                            if(!correctList.equals("")){
                                pause(800);
                                System.out.println("You got: " + correctList + " right.");
                                pause(800);
                            }
                            if(!missingList.equals("")){
                                System.out.println("You were missing: " + missingList);
                                pause(800);
                            }
                            if(!wrongList.equals("")){
                                System.out.println("You got: " + wrongList + " wrong.");
                                pause(800);
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

                                pause(1000);
                            //Customer Rating | Calculations
                            for(int i = 0; i < stars; i++){
                                System.out.print("[*]");
                            }
                            System.out.println(" (" + stars + " / 5 Stars)");
                            totalStars = totalStars + stars;
                            dayStars = dayStars + stars;
                            served = served + 1;
                            pause(1500);
                        }

                        //End of Day report | Per day
                        System.out.println("----------------------------------------");
                                pause(500);
                        System.out.println("End of Day " + day + " Report:");
                                pause(500);
                        System.out.println("  Served " + customersToday + " customers today");
                                pause(500);
                        System.out.println("  Stars today: " + dayStars + " / " + (customersToday * 5));
                        System.out.println("----------------------------------------");

                            pause(4000);
                        scanner.nextLine(); //clears the leftover newline from the last y/n answer
                        waitForEnter(scanner);

                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }

                        //Next day group increase until it caps out
                        if (customersToday < maxPerDay) {
                            customersToday = customersToday + increment;
                        }
                    }

                    //End of the Day Report | Ranks
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

                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }
                    
                    pause(1500);
                    System.out.println();
                    System.out.println("===================================================================");
                    System.out.println("                          FINAL REPORT");
                    System.out.println("===================================================================");
                    pause(700);
                    System.out.println("Total Customers Served: " + served);
                    pause(700);
                    System.out.println("Total Stars Earned: " + totalStars + " / " + (served * 5));
                    pause(700);
                    System.out.printf("Average Rating: %.1f / 5.0%n", avg);
                    pause(1200);
                    System.out.println("Final Rank: " + rank);
                    System.out.println("===================================================================");
                    pause(4000);
                    System.out.println(" ");
                    break;


                case 2:
                    System.out.println("===================================================================");
                    System.out.println("                    PIZZA PANIC - PLAYER GUIDE                     ");
                    System.out.println("===================================================================");
                    System.out.println("");
                    System.out.println("WELCOME TO PIZZA PANIC!");
                    System.out.println("Customers are hungry, orders are coming in fast, and it is up to ");
                    System.out.println("you to assemble every pizza correctly before your shift ends.");
                    System.out.println("");
                    pause(5000);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                           HOW TO PLAY");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("[1] RECEIVE THE ORDER:");
                    System.out.println("    A customer will arrive and ask for a specific pizza type ");
                    System.out.println("    (e.g., Hawaiian, Meat Lovers, or Subterranean).");
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

                    scanner.nextLine(); //clears the leftover newline from the menu choice
                    waitForEnter(scanner);

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                        PIZZA MENU & RECIPES");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("| PIZZA NAME        | REQUIRED INGREDIENTS                        |");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("| Meat Lovers       | pepperoni, sausage, ham                     |");
                    System.out.println("| Hawaiian          | ham, pineapple                              |");
                    System.out.println("| Subterranean      | sausage, mushroom                           |");
                    System.out.println("| Cheese            | no toppings (answer n to everything)        |");
                    System.out.println("+-------------------+---------------------------------------------+");
                    System.out.println("");
                    System.out.println("Note: Leaving out an ingredient or adding an incorrect ingredient ");
                    System.out.println("will lower your score for that order.");
                    System.out.println("");

                    waitForEnter(scanner);

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

                    waitForEnter(scanner);

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
                    
                    waitForEnter(scanner);

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

                    waitForEnter(scanner);

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

                    waitForEnter(scanner);

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
                    
                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }
                    
                    System.out.println("===================================================================");
                    System.out.println("                      PIZZA PANIC - CREDITS                         ");
                    System.out.println("===================================================================");

                    pause(5000);

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("                  DEVELOPMENT & PRODUCTION TEAM                    ");
                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------");
                    pause(3000);

                    System.out.println("  MAIN PROGRAM LOGIC & SYSTEM ARCHITECTURE");

                    pause(2000);

                    System.out.println("  - Marcus Jamir G. Rufin");

                    pause(3000);

                    System.out.println("");
                    System.out.println("  ORDER VALIDATION & QUALITY ASSURANCE");

                    pause(2000);

                    System.out.println("  - Reiben John Calumag");

                    pause(3000);

                    System.out.println("");
                    System.out.println("  CUSTOMER DIALOG & REQUEST ENCODER");

                    pause(2000);

                    System.out.println("  - Hillary Joy De Jesus");
                    
                    pause(3000);

                    System.out.println("");
                    System.out.println("  PIZZA RECIPE & MENU DESIGN");
                    pause(2000);

                    System.out.println("  - Dion Michael Literato");
                    pause(3000);

                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("                Thank you for playing Pizza Panic!");
                    System.out.println("===================================================================");
                    break;

                case 4:

                    for (int i = 0; i < 40; i++) {
                        System.out.println();
                    }

                    pause(500);
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