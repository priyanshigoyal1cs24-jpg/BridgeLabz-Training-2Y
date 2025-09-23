class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }

    public void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped (Tracking: " + trackingNumber + ")";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OrderManagementSystem {
    public static void main(String[] args) {
        Order order = new Order("ORD1001", "2025-09-10");
        ShippedOrder shipped = new ShippedOrder("ORD1002", "2025-09-11", "TRK123456");
        DeliveredOrder delivered = new DeliveredOrder("ORD1003", "2025-09-12", "TRK789012", "2025-09-14");

        System.out.println("Order Info:");
        order.displayInfo();
        System.out.println();

        System.out.println("Shipped Order Info:");
        shipped.displayInfo();
        System.out.println();

        System.out.println("Delivered Order Info:");
        delivered.displayInfo();
    }
}
