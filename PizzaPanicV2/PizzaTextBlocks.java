public class PizzaTextBlocks {
    //Short delay so text does not appear all at once (same as the one in the main file)
    static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    /*
    Credits are in the main code
    Legend for Ctrl + F Search restrict to exact case
    End of the Day Report (Gameplay)
    Rank Calc
    Final Report (Gameplay)
    Player Guide
    How to Play
    Menu and Recipes
    Scoring System
    Final Report (Guide)
    Example Gamplay (Guide) | Part 1 and 2
    End of Day Report (Guide)
    */
    //End of Day Report (Gameplay)
    static void dayReport(int day, int customersToday, int dayStars) {
        System.out.println("----------------------------------------");
        pause(500);
        System.out.println("End of Day " + day + " Report:");
        pause(500);
        System.out.println("  Served " + customersToday + " customers today");
        pause(500);
        System.out.println("  Stars today: " + dayStars + " / " + (customersToday * 5));
        System.out.println("----------------------------------------");
    }

    //Rank Calc from avg rating
    static String getRank(double avg) {
        String rank = "";
        if (avg >= 4.5) {
            rank = "Master Chef";
        }
        else if (avg >= 3.0) {
            rank = "Line Cook";
        }
        else {
            rank = "Trainee";
        }
        return rank;
    }

    //Final Report (Gameplay)
    static void finalReport(int served, int totalStars, double avg, String rank) {
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
    }
    //Player Guide - Case 2
    static void playerGuide(){
        System.out.println("===================================================================");
        System.out.println("                    PIZZA PANIC - PLAYER GUIDE                     ");
        System.out.println("===================================================================");
        System.out.println("");
        System.out.println("WELCOME TO PIZZA PANIC!");
        System.out.println("Customers are hungry, orders are coming in fast, and it is up to ");
        System.out.println("you to assemble every pizza correctly before your shift ends.");
        System.out.println("");
    }
    //How to Play
    static void howToPlay(){
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
    }
    //Menu and Recipes
    static void pizzaMenuAndRecipes(){
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
    }
    //Scoring System
    static void scoringSystem(){
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
    }
    //Final Report (Guide)
    static void guideFinalReport(){
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
    }
    //Example Gamplay (Guide) | Part 1 and 2
    static void guideGameplay1(){
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
    }
    static void guideGameplay2(){
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
    }
    //End of Day Report (Guide)
    static void guideEndDayReport(){
        System.out.println("===================================================================");
        System.out.println("                        END OF DAY REPORT");
        System.out.println("===================================================================");
        System.out.println("Total Customers Served: 2");
        System.out.println("Total Stars Earned: 8 / 10");
        System.out.println("Average Rating: 4.0 / 5.0 Stars");
        System.out.println("Final Rank: Line Cook");
        System.out.println("===================================================================");
        for (int s = 0;s < 5; s++) {
            System.out.println();
        }
    }
}