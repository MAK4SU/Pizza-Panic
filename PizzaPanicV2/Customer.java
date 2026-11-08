import java.util.Random;

public class Customer {
    String customerName;
    String orderName;
    boolean hasPepperoni;
    boolean hasSausage;
    boolean hasPineapple;
    boolean hasHam;
    boolean hasMushroom;

    /* Order of the values when making a customer: name, order, pepperoni, 
    sausage, pineapple, ham, mushroom.
    */
    Customer(String name, String order, boolean p, boolean s, boolean pi, boolean h, boolean m) {
        customerName = name;
        orderName = order;
        hasPepperoni = p;
        hasSausage = s;
        hasPineapple = pi;
        hasHam = h;
        hasMushroom = m;
    }
    //Name lists | same order, so index 0 is Ato Deli Rose, index 1 is Pedro Kayatono and so on
    static String[] firstNames = {
        "Ato", "Pedro", "Alice", "Apollo", "Harry", "Daldy", "Sarah",
        "Nanny", "Baby", "Josh", "Walk", "Tony", "Dong"
    };
    static String[] lastNames = {
        "Deli Rose", "Kayatono", "Go go go", "Miringhoy", "Rocky", "Co", "Dikaya",
        "Bigay", "Binida", "Mahika", "Walkism", "Flower", "Rebuilder"
    };

    //First name + Last name
    static String matchedName(Random rand) {
        int i = rand.nextInt(firstNames.length);
        return firstNames[i] + " " + lastNames[i];
    }
    
    //Time limits in seconds, per customer - RJ
    static int normalTime = 10;
    static int rushTime = 5;
 
    //Picks the limit | rush hour is when the group is at its max size
    static int getLimit(int customersToday, int maxPerDay) {
        int limit = normalTime;
        if (customersToday == maxPerDay) {
            limit = rushTime;
        }
        return limit;
    }
 
    //RUSH HOUR for rush days, nothing on normal days
    static void rushBanner(int customersToday, int maxPerDay) {
        if (customersToday == maxPerDay) {
            System.out.println("!!! RUSH HOUR! Shorter time limit today! !!!");
        }
    }
 
    //Prints the limit, then starts the clock and returns the start time in milliseconds
    static long start(int limit) {
        System.out.println("You have " + limit + " seconds!");
        System.out.println();
        long startTime = System.currentTimeMillis();
        return startTime;
    }
 
    //True when the time limit has passed (elapsed milliseconds vs limit in seconds * 1000)
    static boolean isUp(long startTime, int limit) {
        long elapsed = System.currentTimeMillis() - startTime;
        return elapsed > limit * 1000;
    }
 
    //Message when the customer leaves
    static void timeoutMessage(String name) {
        System.out.println();
        System.out.println("Time's up! " + name + " got tired of waiting and left!");
    }
}
