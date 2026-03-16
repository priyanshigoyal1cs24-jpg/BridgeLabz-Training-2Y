package linkedList;
import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;

    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        next = null;
    }
}

class CircularTaskList {

    Task head = null;
    Task current = null;

    // Insert at beginning
    void insertBeginning(int id, String name, int priority, String date) {

        Task newNode = new Task(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int id, String name, int priority, String date) {

        Task newNode = new Task(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at position
    void insertPosition(int pos, int id, String name, int priority, String date) {

        if (pos == 1) {
            insertBeginning(id, name, priority, date);
            return;
        }

        Task newNode = new Task(id, name, priority, date);
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by Task ID
    void delete(int id) {

        if (head == null)
            return;

        Task temp = head;
        Task prev = null;

        // if head is to be deleted
        if (head.id == id) {

            Task last = head;
            while (last.next != head)
                last = last.next;

            if (head.next == head) {
                head = null;
                return;
            }

            head = head.next;
            last.next = head;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.id == id) {
                prev.next = temp.next;
                System.out.println("Task deleted");
                return;
            }

        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task
    void viewCurrent() {

        if (current == null) {
            System.out.println("No tasks");
            return;
        }

        System.out.println("Current Task:");
        print(current);
    }

    // Move to next task
    void nextTask() {

        if (current != null)
            current = current.next;
    }

    // Display all tasks
    void display() {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;

        do {
            print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchPriority(int priority) {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {

            if (temp.priority == priority) {
                print(temp);
                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found)
            System.out.println("No task found with that priority");
    }

    void print(Task t) {
        System.out.println("ID: " + t.id +
                " Name: " + t.name +
                " Priority: " + t.priority +
                " Due: " + t.dueDate);
    }
}

public class q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularTaskList list = new CircularTaskList();

        while (true) {

            System.out.println("\n1.Insert Beginning");
            System.out.println("2.Insert End");
            System.out.println("3.Insert Position");
            System.out.println("4.Delete Task");
            System.out.println("5.View Current Task");
            System.out.println("6.Move To Next Task");
            System.out.println("7.Display Tasks");
            System.out.println("8.Search by Priority");
            System.out.println("9.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.println("Enter ID Name Priority DueDate");
                    list.insertBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 2:
                    System.out.println("Enter ID Name Priority DueDate");
                    list.insertEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 3:
                    System.out.println("Enter Position");
                    int pos = sc.nextInt();
                    System.out.println("Enter ID Name Priority DueDate");
                    list.insertPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 4:
                    System.out.println("Enter Task ID");
                    list.delete(sc.nextInt());
                    break;

                case 5:
                    list.viewCurrent();
                    break;

                case 6:
                    list.nextTask();
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Enter Priority");
                    list.searchPriority(sc.nextInt());
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
