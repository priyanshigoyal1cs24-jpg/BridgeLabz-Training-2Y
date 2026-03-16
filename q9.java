package linkedList;
class Ticket{

    int id;
    String customer,movie,seat,time;
    Ticket next;

    Ticket(int id,String c,String m,String s,String t){
        this.id=id;
        customer=c;
        movie=m;
        seat=s;
        time=t;
    }
}

class TicketSystem{

    Ticket head=null;

    void addTicket(int id,String c,String m,String s,String t){

        Ticket newNode=new Ticket(id,c,m,s,t);

        if(head==null){
            head=newNode;
            newNode.next=head;
            return;
        }

        Ticket temp=head;
        while(temp.next!=head)
            temp=temp.next;

        temp.next=newNode;
        newNode.next=head;
    }

    void delete(int id){

        if(head==null) return;

        Ticket temp=head;
        Ticket prev=null;

        do{

            if(temp.id==id){

                if(prev!=null)
                    prev.next=temp.next;
                else
                    head=temp.next;

                System.out.println("Ticket removed");
                return;
            }

            prev=temp;
            temp=temp.next;

        }while(temp!=head);
    }

    void display(){

        if(head==null) return;

        Ticket temp=head;

        do{
            System.out.println(temp.id+" "+temp.customer+" "+temp.movie+" "+temp.seat+" "+temp.time);
            temp=temp.next;
        }while(temp!=head);
    }

    void count(){

        int count=0;

        Ticket temp=head;

        if(temp==null) return;

        do{
            count++;
            temp=temp.next;
        }while(temp!=head);

        System.out.println("Total Tickets: "+count);
    }
}