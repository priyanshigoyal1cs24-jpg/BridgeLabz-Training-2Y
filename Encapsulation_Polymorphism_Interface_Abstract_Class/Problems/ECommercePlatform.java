interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

class Electronics extends Product implements Taxable {
    private int warrantyMonths;

    public Electronics(String productId, String name, double price, int warrantyMonths) {
        super(productId, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "15% tax on electronics";
    }
}

class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "5% tax on clothing";
    }
}

class Groceries extends Product {
    private int shelfLife;

    public Groceries(String productId, String name, double price, int shelfLife) {
        super(productId, name, price);
        this.shelfLife = shelfLife;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void calculateAndPrintFinalPrice(Product product) {
        double price = product.getPrice();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
        }

        double finalPrice = price + tax - discount;

        product.displayDetails();
        System.out.println("Discount: $" + discount);
        System.out.println("Tax: $" + tax);
        System.out.println("Final Price: $" + finalPrice);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Electronics("E101", "Smartphone", 999.99, 24);
        products[1] = new Clothing("C205", "Jacket", 149.99, "M");
        products[2] = new Groceries("G012", "Organic Apples", 19.99, 10);

        for (Product product : products) {
            calculateAndPrintFinalPrice(product);
        }
    }
}
