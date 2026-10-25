import java.util.Random;

class Customer {
    String customerName;
    String orderName;
    boolean hasPepperoni;
    boolean hasSausage;
    boolean hasPineapple;
    boolean hasHam;
    boolean hasMushroom;

    public Customer(String name, String order, boolean p, boolean s, boolean pi, boolean h, boolean m) {
        customerName = name;
        orderName = order;
        hasPepperoni = p;
        hasSausage = s;
        hasPineapple = pi;
        hasHam = h;
        hasMushroom = m;
    }
}

public class DraftCustomer {
    public static void main(String[] args) {
        Random random = new Random();

        Customer[] allOrders = {
            new Customer("Customer 1", "Pepperoni", true, false, false, false, false),
            new Customer("Customer 2", "Sausage", false, true, false, false, false),
            new Customer("Customer 3", "Pineapple", false, false, true, false, false),
            new Customer("Customer 4", "Ham", false, false, false, true, false),
            new Customer("Customer 5", "Mushroom", false, false, false, false, true),
            new Customer("Customer 6", "Hawaiian", false, false, true, true, false),
            new Customer("Customer 7", "Meat Lover", true, true, false, true, false),
            new Customer("Customer 8", "Subterranean", false, true, true, true, true)
        };

        for (int i = 0; i < 5; i++) {
            int pick = random.nextInt(allOrders.length);
            Customer selected = allOrders[pick];

            System.out.println("I want " + selected.orderName + " Pizza!");
            System.out.println("From: " + selected.customerName);
            System.out.println("  Pepperoni: " + (selected.hasPepperoni ? "YES" : "NO"));
            System.out.println("  Sausage: " + (selected.hasSausage ? "YES" : "NO"));
            System.out.println("  Pineapple: " + (selected.hasPineapple ? "YES" : "NO"));
            System.out.println("  Ham: " + (selected.hasHam ? "YES" : "NO"));
            System.out.println("  Mushroom: " + (selected.hasMushroom ? "YES" : "NO"));
            System.out.println();
        }

       
    }
}
