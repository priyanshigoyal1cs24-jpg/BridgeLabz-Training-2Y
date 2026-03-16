package linkedList;
class State{

    String text;
    State next,prev;

    State(String t){
        text=t;
    }
}

class TextEditor{

    State head=null;
    State current=null;
    int size=0;
    int limit=10;

    void addState(String text){

        State newNode=new State(text);

        if(head==null){
            head=current=newNode;
            size++;
            return;
        }

        current.next=newNode;
        newNode.prev=current;
        current=newNode;
        size++;

        if(size>limit){
            head=head.next;
            head.prev=null;
            size--;
        }
    }

    void undo(){

        if(current.prev!=null)
            current=current.prev;
    }

    void redo(){

        if(current.next!=null)
            current=current.next;
    }

    void display(){
        System.out.println("Current Text: "+current.text);
    }
}
