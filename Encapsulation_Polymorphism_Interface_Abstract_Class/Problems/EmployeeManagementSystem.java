interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String departmentName;
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }

    public void displayDetails() {
        System.out.println("Employee Type: Full-Time");
        super.displayDetails();
        System.out.println("Bonus: $" + bonus);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String departmentName;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }

    public void displayDetails() {
        System.out.println("Employee Type: Part-Time");
        super.displayDetails();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        FullTimeEmployee f1 = new FullTimeEmployee(101, "Alice", 5000, 1000);
        f1.assignDepartment("Engineering");

        PartTimeEmployee p1 = new PartTimeEmployee(102, "Bob", 0, 20, 25);
        p1.assignDepartment("Support");

        FullTimeEmployee f2 = new FullTimeEmployee(103, "Charlie", 6000, 1200);
        f2.assignDepartment("Finance");

        employees[0] = f1;
        employees[1] = p1;
        employees[2] = f2;

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}
