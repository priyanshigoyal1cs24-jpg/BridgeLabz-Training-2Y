package linkedList;
class User {

    int id,age;
    String name;
    Friend friends;
    User next;

    User(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        friends=null;
        next=null;
    }
}

class Friend{
    int id;
    Friend next;

    Friend(int id){
        this.id=id;
        next=null;
    }
}

class SocialNetwork{

    User head=null;

    void addUser(int id,String name,int age){

        User newNode=new User(id,name,age);

        if(head==null){
            head=newNode;
            return;
        }

        User temp=head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next=newNode;
    }

    User findUser(int id){

        User temp=head;

        while(temp!=null){
            if(temp.id==id)
                return temp;
            temp=temp.next;
        }

        return null;
    }

    void addFriend(int id1,int id2){

        User u1=findUser(id1);
        User u2=findUser(id2);

        if(u1==null || u2==null)
            return;

        Friend f1=new Friend(id2);
        f1.next=u1.friends;
        u1.friends=f1;

        Friend f2=new Friend(id1);
        f2.next=u2.friends;
        u2.friends=f2;
    }

    void displayFriends(int id){

        User u=findUser(id);

        if(u==null) return;

        Friend f=u.friends;

        while(f!=null){
            System.out.println("Friend ID: "+f.id);
            f=f.next;
        }
    }

    void countFriends(){

        User temp=head;

        while(temp!=null){

            int count=0;
            Friend f=temp.friends;

            while(f!=null){
                count++;
                f=f.next;
            }

            System.out.println(temp.name+" has "+count+" friends");
            temp=temp.next;
        }
    }
}
