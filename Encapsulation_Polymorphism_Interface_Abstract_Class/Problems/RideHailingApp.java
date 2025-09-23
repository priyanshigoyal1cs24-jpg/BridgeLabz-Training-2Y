interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // base fee
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base fee
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 10; // small base fare
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

public class RideHailingApp {
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        if (vehicle instanceof GPS) {
            GPS gps = (GPS) vehicle;
            System.out.println("Current Location: " + gps.getCurrentLocation());
        }
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: $" + vehicle.calculateFare(distance));
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        Vehicle[] rides = new Vehicle[3];

        rides[0] = new Car("CAR123", "Alice", 15.0, "Downtown");
        rides[1] = new Bike("BIKE456", "Bob", 5.0, "Mall Road");
        rides[2] = new Auto("AUTO789", "Charlie", 8.0, "Station");

        for (Vehicle v : rides) {
            processRide(v, 10); // Assume 10 km ride
        }
    }
}
