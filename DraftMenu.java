import java.util.Scanner;

public class DraftMenu {
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
            choice = scanner.nextInt();

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
        } while (choice < 1 || choice > 4);



        scanner.close();
    }
}
