package linkedList;
import java.util.Scanner;

class Book{

    int id;
    String title;
    String author;
    String genre;
    String status;

    Book next;
    Book prev;

    Book(int id,String t,String a,String g,String s){
        this.id=id;
        title=t;
        author=a;
        genre=g;
        status=s;
        next=null;
        prev=null;
    }
}

class Library{

    Book head=null;
    Book tail=null;

    void insertEnd(int id,String t,String a,String g,String s){

        Book newNode=new Book(id,t,a,g,s);

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    void delete(int id){

        Book temp=head;

        while(temp!=null){

            if(temp.id==id){

                if(temp==head)
                    head=temp.next;

                if(temp==tail)
                    tail=temp.prev;

                if(temp.prev!=null)
                    temp.prev.next=temp.next;

                if(temp.next!=null)
                    temp.next.prev=temp.prev;

                System.out.println("Book removed");
                return;
            }

            temp=temp.next;
        }

        System.out.println("Book not found");
    }

    void searchTitle(String title){

        Book temp=head;

        while(temp!=null){

            if(temp.title.equalsIgnoreCase(title)){
                print(temp);
                return;
            }

            temp=temp.next;
        }

        System.out.println("Book not found");
    }

    void searchAuthor(String author){

        Book temp=head;
        boolean found=false;

        while(temp!=null){

            if(temp.author.equalsIgnoreCase(author)){
                print(temp);
                found=true;
            }

            temp=temp.next;
        }

        if(!found)
            System.out.println("Book not found");
    }

    void updateStatus(int id,String s){

        Book temp=head;

        while(temp!=null){

            if(temp.id==id){
                temp.status=s;
                System.out.println("Status updated");
                return;
            }

            temp=temp.next;
        }
    }

    void displayForward(){

        Book temp=head;

        while(temp!=null){
            print(temp);
            temp=temp.next;
        }
    }

    void displayReverse(){

        Book temp=tail;

        while(temp!=null){
            print(temp);
            temp=temp.prev;
        }
    }

    void countBooks(){

        int count=0;

        Book temp=head;

        while(temp!=null){
            count++;
            temp=temp.next;
        }

        System.out.println("Total books: "+count);
    }

    void print(Book b){
        System.out.println(b.id+" "+b.title+" "+b.author+" "+b.genre+" "+b.status);
    }
}

public class q5{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        Library lib=new Library();

        while(true){

            System.out.println("\n1 Add Book");
            System.out.println("2 Delete Book");
            System.out.println("3 Search by Title");
            System.out.println("4 Search by Author");
            System.out.println("5 Update Status");
            System.out.println("6 Display Forward");
            System.out.println("7 Display Reverse");
            System.out.println("8 Count Books");
            System.out.println("9 Exit");

            int ch=sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:
                    System.out.println("Enter ID Title Author Genre Status");
                    lib.insertEnd(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next());
                    break;

                case 2:
                    System.out.println("Enter ID");
                    lib.delete(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Enter Title");
                    lib.searchTitle(sc.next());
                    break;

                case 4:
                    System.out.println("Enter Author");
                    lib.searchAuthor(sc.next());
                    break;

                case 5:
                    System.out.println("Enter ID and Status");
                    lib.updateStatus(sc.nextInt(),sc.next());
                    break;

                case 6:
                    lib.displayForward();
                    break;

                case 7:
                    lib.displayReverse();
                    break;

                case 8:
                    lib.countBooks();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
