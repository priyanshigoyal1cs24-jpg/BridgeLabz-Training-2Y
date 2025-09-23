interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        displayInfo();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Prepares meals and manages kitchen operations.");
    }
}

class Waiter extends Person implements Worker {
    private String section;

    public Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        displayInfo();
        System.out.println("Section: " + section);
        System.out.println("Duties: Takes orders and serves food to customers.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Worker chef = new Chef("Gordon Ramsay", 101, "French Cuisine");
        Worker waiter = new Waiter("John Smith", 201, "Dining Hall A");

        chef.performDuties();
        System.out.println();

        waiter.performDuties();
    }
}
