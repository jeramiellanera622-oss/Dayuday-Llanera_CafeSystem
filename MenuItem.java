/**
 * Parent class for all cafe menu items.
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    public MenuItem() {
        name = "Unknown";
        basePrice = 0;
        itemCode = "000";
    }

    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " (" + itemCode + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Invalid price!");
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
