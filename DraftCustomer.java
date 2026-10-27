public class DraftCustomer {
    String customerName;
    String orderName;
    boolean hasPepperoni;
    boolean hasSausage;
    boolean hasPineapple;
    boolean hasHam;
    boolean hasMushroom;

    /* Order of the values when making a customer: name, order, pepperoni, 
    sausage, pineapple, ham, mushroom.
    We should probably give them actual names instead of just "Customer #"
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
}
