package linkedList;
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    Movie(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
        next = null;
        prev = null;
    }
}

class MovieList {

    Movie head = null;
    Movie tail = null;

    // Insert at beginning
    void insertBeginning(String t, String d, int y, double r) {
        Movie newNode = new Movie(t,d,y,r);

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    void insertEnd(String t, String d, int y, double r) {
        Movie newNode = new Movie(t,d,y,r);

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at position
    void insertPosition(int pos, String t, String d, int y, double r) {

        if(pos == 1){
            insertBeginning(t,d,y,r);
            return;
        }

        Movie newNode = new Movie(t,d,y,r);
        Movie temp = head;

        for(int i=1;i<pos-1 && temp!=null;i++){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp.next != null)
            temp.next.prev = newNode;
        else
            tail = newNode;

        temp.next = newNode;
    }

    // Delete by title
    void delete(String title){

        Movie temp = head;

        while(temp != null){

            if(temp.title.equalsIgnoreCase(title)){

                if(temp == head)
                    head = temp.next;

                if(temp == tail)
                    tail = temp.prev;

                if(temp.prev != null)
                    temp.prev.next = temp.next;

                if(temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Movie deleted");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Search by director
    void searchDirector(String director){

        Movie temp = head;
        boolean found = false;

        while(temp != null){

            if(temp.director.equalsIgnoreCase(director)){
                print(temp);
                found = true;
            }

            temp = temp.next;
        }

        if(!found)
            System.out.println("No movie found");
    }

    // Search by rating
    void searchRating(double rating){

        Movie temp = head;
        boolean found = false;

        while(temp != null){

            if(temp.rating == rating){
                print(temp);
                found = true;
            }

            temp = temp.next;
        }

        if(!found)
            System.out.println("No movie found");
    }

    // Update rating
    void updateRating(String title,double newRating){

        Movie temp = head;

        while(temp != null){

            if(temp.title.equalsIgnoreCase(title)){
                temp.rating = newRating;
                System.out.println("Rating Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    void displayForward(){

        Movie temp = head;

        if(temp == null){
            System.out.println("No movies");
            return;
        }

        while(temp != null){
            print(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse(){

        Movie temp = tail;

        if(temp == null){
            System.out.println("No movies");
            return;
        }

        while(temp != null){
            print(temp);
            temp = temp.prev;
        }
    }

    void print(Movie m){
        System.out.println("Title: "+m.title+
                " Director: "+m.director+
                " Year: "+m.year+
                " Rating: "+m.rating);
    }
}

public class q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        while(true){

            System.out.println("\n1.Insert Beginning");
            System.out.println("2.Insert End");
            System.out.println("3.Insert Position");
            System.out.println("4.Delete Movie");
            System.out.println("5.Search by Director");
            System.out.println("6.Search by Rating");
            System.out.println("7.Display Forward");
            System.out.println("8.Display Reverse");
            System.out.println("9.Update Rating");
            System.out.println("10.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:
                    System.out.println("Enter Title Director Year Rating");
                    list.insertBeginning(sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextDouble());
                    break;

                case 2:
                    System.out.println("Enter Title Director Year Rating");
                    list.insertEnd(sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Enter Position");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Title Director Year Rating");
                    list.insertPosition(pos,sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextDouble());
                    break;

                case 4:
                    System.out.println("Enter Title");
                    list.delete(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Enter Director");
                    list.searchDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Enter Rating");
                    list.searchRating(sc.nextDouble());
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.println("Enter Title and New Rating");
                    list.updateRating(sc.nextLine(),sc.nextDouble());
                    break;

                case 10:
                    System.exit(0);
            }
        }
    }
}
