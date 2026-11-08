import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PizzaPanicV2 {
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
            System.out.println("[1] Start!");
            System.out.println("[2] Rules and Instructions");
            System.out.println("[3] Credits");
            System.out.println("[4] Exit ");
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
                    for (int s = 0; s < 60; s++) {
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
                    //Values order: name, order, pepperoni, sausage, pineapple, ham, mushroom
                    Customer[] allOrders = {
                        new Customer("", "Pepperoni", true, false, false, false, false),
                        new Customer("", "Sausage", false, true, false, false, false),
                        new Customer("", "Pineapple", false, false, true, false, false),
                        new Customer("", "Ham", false, false, false, true, false),
                        new Customer("", "Mushroom", false, false, false, false, true),
                        new Customer("", "Hawaiian", false, false, true, true, false),
                        new Customer("", "Meat Lover", true, true, false, true, false),
                        new Customer("", "Subterranean", false, true, false, false, true),
                        new Customer("", "Cheese", false, false, false, false, false)
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
                    
                    for (int s = 0;s < 60; s++) {
                        System.out.println();
                    }

                    System.out.println("===================");
                    System.out.println("    Pizza Panic    ");
                    System.out.println("===================");
                    PizzaStory.storyPrologue();
                    pause(5000);
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
                        Customer.rushBanner(customersToday, maxPerDay);
                        pause(1000);
                        int dayStars = 0;
                        for (int c = 1; c <= customersToday; c++){
                            //Hardset a few things for initial gameplay run
                            String answer = "";
                            boolean valid = false;
                            //Random for customerType index, there's 9 types (picks from the whole allOrders list)
                            int customerType = rand.nextInt(allOrders.length);
                            Customer selected = allOrders[customerType];
                            selected.customerName = Customer.matchedName(rand);
                            // wanted[i] is true if customer wants ingredients[i], 
                            // copied from a selected customer's stored booleans, same order as ingredients
                            boolean[] wanted = new boolean[5];
                            wanted[0] = selected.hasPepperoni;
                            wanted[1] = selected.hasSausage;
                            wanted[2] = selected.hasPineapple;
                            wanted[3] = selected.hasHam;
                            wanted[4] = selected.hasMushroom;  

                            pause(2000);
                            for (int s = 0;s < 60; s++) {
                                System.out.println();
                            }
                            System.out.println("==============================================================");
                            System.out.println(selected.customerName + " would like: " + selected.orderName + " pizza.");
                            System.out.println("==============================================================");
                            //Shows the ASCII art of the pizza the customer ordered (from PizzaArt.java)
                            pause(7000);
                            showPizza(selected.orderName);
                            pause(3000);
                            //Timer | Start of the "Panic" of Pizza Panic
                            int timeLimit = Customer.getLimit(customersToday, maxPerDay);
                            long startTime = Customer.start(timeLimit);
                            boolean timedOut = false;
                            //Make the Pizzeria | Put the Ingredients in
                            boolean[] orderMade = new boolean[5];
                            for (int i = 0; i < ingredients.length; i++){
                                valid = false;
                                //
                                while(!valid){
                                    System.out.print("Add " + ingredients[i] + "? (y/n): ");
                                    answer = scanner.next().toUpperCase();

                                    System.out.println();
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
                                //Timer | Checks after each y/n answer, unanswered stays false
                                if (Customer.isUp(startTime, timeLimit)) {
                                    timedOut = true;
                                    break;
                                }
                            }
                            //Check orderMade with customerType's order

                    for (int s = 0;s < 60; s++) {
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
                            //Makes the list for Correct, Missing, and Wrong ingredients | ALso the timeout
                            int stars = 0;
                            if (timedOut){
                                //Customer leaves, 0 Stars in Report
                                Customer.timeoutMessage(selected.customerName);
                            }
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
                            //End of the Day Report | Logic
                            if (timedOut){
                                stars = 0;
                            }
                            else if (mistakes == 0){
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

                        //End of Day report | Per day (now in PizzaReports.java)
                        PizzaTextBlocks.dayReport(day, customersToday, dayStars);

                            pause(4000);
                        scanner.nextLine(); //clears the leftover newline from the last y/n answer
                        waitForEnter(scanner);

                    for (int s = 0;s < 60; s++) {
                        System.out.println();
                    }

                        //Next day group increase until it caps out
                        if (customersToday < maxPerDay) {
                            customersToday = customersToday + increment;
                        }
                    //Continue or Exit before next day
                        System.out.println("==================================");
                        System.out.println("Proceed to Next Day?");
                        System.out.println("Y: Proceed ");
                        System.out.println("N: Exit ");
                        System.out.println("==================================");
                        String proceed = scanner.nextLine().toUpperCase();
                        if(proceed.equals("Y")){
                            continue;
                        }
                        if(proceed.equals("N")){
                            break;
                        }
                        else{
                            System.out.println("Please enter y/n.");
                            System.out.println();
                        }
                    }

                    //Average and rank (rank now comes from PizzaReports.java)
                    double avg = (double) totalStars/served;
                    String rank = PizzaTextBlocks.getRank(avg);

                    for (int s = 0;s < 60; s++) {
                        System.out.println();
                    }
                    
                    //Final report (now in PizzaReports.java)
                    PizzaTextBlocks.finalReport(served, totalStars, avg, rank);
                    break;

                case 2:
                    PizzaTextBlocks.playerGuide();
                    pause(5000);
                    PizzaTextBlocks.howToPlay();
                    scanner.nextLine(); //clears the leftover newline from the menu choice
                    waitForEnter(scanner);
                    PizzaTextBlocks.pizzaMenuAndRecipes();
                    waitForEnter(scanner);
                    PizzaTextBlocks.scoringSystem();
                    waitForEnter(scanner);
                    PizzaTextBlocks.guideFinalReport();
                    waitForEnter(scanner);
                    PizzaTextBlocks.guideGameplay1();
                    waitForEnter(scanner);
                    PizzaTextBlocks.guideGameplay2();
                    waitForEnter(scanner);
                    PizzaTextBlocks.guideEndDayReport();
                    break;

                case 3: //Stays for Credits
                    
                    for (int s = 0;s < 60; s++) {
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
                    pause(7000);
                    for (int s = 0;s < 60; s++) {
                        System.out.println();
                    }
                    break;

                case 4:
                    PizzaLogicExtra.exitConfirmation(choice);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}