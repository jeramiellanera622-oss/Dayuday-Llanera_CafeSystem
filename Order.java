/**
 * Manages customer orders.
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;

    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {

        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {

        if (item == null) {
            System.out.println("Invalid item!");
            return false;
        }

        if (itemCount >= 3) {
            System.out.println("Maximum of 3 items only!");
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {

        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {

        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            subtotal -= subtotal * 0.10;
        }

        return subtotal;
    }

    public double computeTotal(double voucher) {

        if (voucher < 0) {
            voucher = 0;
        }

        double total = computeTotal() - voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    private void printItem(MenuItem item) {

        System.out.printf("%-35s %.2f%n",
                item.getDescription(),
                item.computePrice());
    }

    public void printReceipt() {

        System.out.println("\n______________________________");
        System.out.println("       CAMPUS CAFE RECEIPT");
        System.out.println("________________________________");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        if (item1 != null) printItem(item1);
        if (item2 != null) printItem(item2);
        if (item3 != null) printItem(item3);

        double subtotal = computeSubtotal();
        double discount = customer.isStudent()
                ? subtotal * 0.10 : 0;

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (discount > 0) {
            System.out.printf("Discount: -%.2f%n", discount);
        }

        System.out.printf("Total: %.2f%n", computeTotal());

        customer.addPoints(computeTotal());

        System.out.println("Loyalty Points: "
                + customer.getLoyaltyPoints());

        System.out.println("________________________________");
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getItemCount() {
        return itemCount;
    }
}
