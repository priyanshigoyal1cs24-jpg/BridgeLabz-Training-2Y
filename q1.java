package linkedList;

import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    // Insert at beginning
    void insertBeginning(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at position
    void insertAtPosition(int pos, int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search by roll number
    void search(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Student Found:");
                System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Display all students
    void display() {
        Student temp = head;

        if (temp == null) {
            System.out.println("No records");
            return;
        }

        while (temp != null) {
            System.out.println("Roll: " + temp.roll +
                    " Name: " + temp.name +
                    " Age: " + temp.age +
                    " Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update grade by roll number
    void updateGrade(int roll, char newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }
}

public class q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("\n1.Insert Beginning");
            System.out.println("2.Insert End");
            System.out.println("3.Insert Position");
            System.out.println("4.Delete by Roll");
            System.out.println("5.Search by Roll");
            System.out.println("6.Display");
            System.out.println("7.Update Grade");
            System.out.println("8.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter roll name age grade:");
                    list.insertBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 2:
                    System.out.println("Enter roll name age grade:");
                    list.insertEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 3:
                    System.out.println("Enter position:");
                    int pos = sc.nextInt();
                    System.out.println("Enter roll name age grade:");
                    list.insertAtPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 4:
                    System.out.println("Enter roll to delete:");
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Enter roll to search:");
                    list.search(sc.nextInt());
                    break;

                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.println("Enter roll and new grade:");
                    list.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}