package linkedList;

class Process {
    int id, burst, priority;
    int remaining;
    Process next;

    Process(int id,int burst,int p){
        this.id=id;
        this.burst=burst;
        this.priority=p;
        this.remaining=burst;
        next=null;
    }
}

class RoundRobin {

    Process head=null;

    void addProcess(int id,int burst,int p){

        Process newNode=new Process(id,burst,p);

        if(head==null){
            head=newNode;
            newNode.next=head;
            return;
        }

        Process temp=head;
        while(temp.next!=head)
            temp=temp.next;

        temp.next=newNode;
        newNode.next=head;
    }

    void simulate(int quantum){

        if(head==null) return;

        Process temp=head;

        int time=0;
        int totalWait=0;
        int totalTurn=0;
        int count=0;

        do{

            if(temp.remaining>0){

                int exec=Math.min(quantum,temp.remaining);
                time+=exec;
                temp.remaining-=exec;

                if(temp.remaining==0){
                    count++;
                    totalTurn+=time;
                    totalWait+=time-temp.burst;
                    System.out.println("Process "+temp.id+" finished at "+time);
                }
            }

            temp=temp.next;

        }while(temp!=head || count==0);

        System.out.println("Average Waiting Time: "+(totalWait/(double)count));
        System.out.println("Average Turnaround Time: "+(totalTurn/(double)count));
    }
}
