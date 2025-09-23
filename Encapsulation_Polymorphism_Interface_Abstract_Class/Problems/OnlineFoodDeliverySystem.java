interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) * (1 - discount / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount Applied: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private static final double NON_VEG_CHARGE = 2.50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double base = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        return base * (1 - discount / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount Applied: " + discount + "%";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            d.applyDiscount(10);
            System.out.println(d.getDiscountDetails());
        }
        System.out.println("Total Price: $" + item.calculateTotalPrice());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        FoodItem[] orders = new FoodItem[2];
        orders[0] = new VegItem("Paneer Tikka", 8.99, 2);
        orders[1] = new NonVegItem("Chicken Biryani", 10.99, 3);

        for (FoodItem item : orders) {
            processOrder(item);
        }
    }
}
