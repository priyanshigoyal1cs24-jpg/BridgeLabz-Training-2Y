package linkedList;

import java.util.Scanner;

class Item {
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id,String name,int q,double p){
        this.id=id;
        this.name=name;
        quantity=q;
        price=p;
        next=null;
    }
}

class Inventory {

    Item head=null;

    void insertEnd(int id,String name,int q,double p){

        Item newNode=new Item(id,name,q,p);

        if(head==null){
            head=newNode;
            return;
        }

        Item temp=head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next=newNode;
    }

    void delete(int id){

        if(head==null) return;

        if(head.id==id){
            head=head.next;
            return;
        }

        Item temp=head;

        while(temp.next!=null && temp.next.id!=id)
            temp=temp.next;

        if(temp.next==null){
            System.out.println("Item not found");
            return;
        }

        temp.next=temp.next.next;
    }

    void updateQuantity(int id,int q){

        Item temp=head;

        while(temp!=null){

            if(temp.id==id){
                temp.quantity=q;
                System.out.println("Quantity updated");
                return;
            }

            temp=temp.next;
        }

        System.out.println("Item not found");
    }

    void searchByID(int id){

        Item temp=head;

        while(temp!=null){

            if(temp.id==id){
                print(temp);
                return;
            }

            temp=temp.next;
        }

        System.out.println("Item not found");
    }

    void searchByName(String name){

        Item temp=head;
        boolean found=false;

        while(temp!=null){

            if(temp.name.equalsIgnoreCase(name)){
                print(temp);
                found=true;
            }

            temp=temp.next;
        }

        if(!found)
            System.out.println("Item not found");
    }

    void totalValue(){

        double total=0;

        Item temp=head;

        while(temp!=null){
            total+=temp.price*temp.quantity;
            temp=temp.next;
        }

        System.out.println("Total Inventory Value: "+total);
    }

    void display(){

        Item temp=head;

        while(temp!=null){
            print(temp);
            temp=temp.next;
        }
    }

    void sortByPrice(){

        for(Item i=head;i!=null;i=i.next){
            for(Item j=i.next;j!=null;j=j.next){

                if(i.price>j.price){

                    int id=i.id;
                    String name=i.name;
                    int q=i.quantity;
                    double p=i.price;

                    i.id=j.id;
                    i.name=j.name;
                    i.quantity=j.quantity;
                    i.price=j.price;

                    j.id=id;
                    j.name=name;
                    j.quantity=q;
                    j.price=p;
                }
            }
        }

        System.out.println("Sorted by price");
    }

    void print(Item i){
        System.out.println(i.id+" "+i.name+" "+i.quantity+" "+i.price);
    }
}

public class q4{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        Inventory inv=new Inventory();

        while(true){

            System.out.println("\n1 Add Item");
            System.out.println("2 Delete Item");
            System.out.println("3 Update Quantity");
            System.out.println("4 Search by ID");
            System.out.println("5 Search by Name");
            System.out.println("6 Display");
            System.out.println("7 Total Value");
            System.out.println("8 Sort by Price");
            System.out.println("9 Exit");

            int ch=sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:
                    System.out.println("Enter ID Name Quantity Price");
                    inv.insertEnd(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;

                case 2:
                    System.out.println("Enter ID");
                    inv.delete(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Enter ID and Quantity");
                    inv.updateQuantity(sc.nextInt(),sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter ID");
                    inv.searchByID(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Enter Name");
                    inv.searchByName(sc.next());
                    break;

                case 6:
                    inv.display();
                    break;

                case 7:
                    inv.totalValue();
                    break;

                case 8:
                    inv.sortByPrice();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}