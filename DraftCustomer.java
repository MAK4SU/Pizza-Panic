public class DraftCustomer {
    public String customerName;
    public String orderName;
    public boolean hasPepperoni;
    public boolean hasSausage;
    public boolean hasPineapple;
    public boolean hasHam;
    public boolean hasMushroom;

    /* Order of the values when making a customer: name, order, pepperoni, 
    sausage, pineapple, ham, mushroom.
    We should probably give them actual names instead of just "Customer #"
    */ 
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
