interface Refuelable {
    void refuel();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging Electric Vehicle...");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }

    public void displayVehicle() {
        System.out.println("Type: Electric Vehicle");
        displayInfo();
        charge();
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelTankCapacity;

    public PetrolVehicle(int maxSpeed, String model, double fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling Petrol Vehicle...");
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }

    public void displayVehicle() {
        System.out.println("Type: Petrol Vehicle");
        displayInfo();
        refuel();
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S", 100);
        PetrolVehicle toyota = new PetrolVehicle(180, "Toyota Corolla", 50);

        tesla.displayVehicle();
        System.out.println();

        toyota.displayVehicle();
    }
}
