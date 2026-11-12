/**
 * Main application of Campus Cafe.
 */
public class CafeApp {

    public static void main(String[] args) {

        // FIRST CUSTOMER
        Customer customer1 =
                new Customer("Rinalyn Dayuday ", true);

        Order order1 =
                new Order("2001", customer1);

        // FIRST ORDER ITEMS
        Beverage coffee =
                new Beverage("Iced Coffee", 75,
                        "B-10", "M");

        Beverage milkTea =
                new Beverage("Milk Tea", 60,
                        "B-11", "L");

        Pastry donut =
                new Pastry("Chocolate Donut", 35,
                        "P-10", true);

        Meal chickenRice =
                new Meal("Chicken Rice", 120,
                        "M-10", true, 2);

        // ADD ITEMS
        order1.addItem(coffee);
        order1.addItem(milkTea);
        order1.addItem(donut);

        // TEST FOURTH ITEM
        order1.addItem(chickenRice);

        // FIRST RECEIPT
        order1.printReceipt();


        // SECOND CUSTOMER
        Customer customer2 =
                new Customer("John Michael Tarona", false);

        Order order2 =
                new Order("2002", customer2);

        // SECOND ORDER ITEMS
        Pastry sandwich =
                new Pastry("Cheese Sandwich", 85,
                        "P-11", false);

        Meal porkRice =
                new Meal("Pork Rice Meal", 130,
                        "M-11", false, 1);

        Beverage fruitJuice = new Beverage();

        fruitJuice.setName("Orange Juice");
        fruitJuice.setBasePrice(50);
        fruitJuice.setItemCode("B-12");
        fruitJuice.setSize("S");

        // ADD ITEMS
        order2.addItem(sandwich);
        order2.addItem(porkRice);
        order2.addItem(fruitJuice);

        // SECOND RECEIPT
        order2.printReceipt();

        // VOUCHER
        System.out.printf(
                "Total with voucher: %.2f%n",
                order2.computeTotal(25)
        );
    }
}
