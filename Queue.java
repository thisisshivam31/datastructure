import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;
    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;

    }
    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
            return length;
    }
    public boolean isEmpty(){
            return length==0;
    }
    public void enque(int data){
            ListNode temp = new ListNode(data);
            if(isEmpty()){
                front=temp;
            }
            else{
                rear.next=temp;
            }
            rear=temp;
            length++;
    }
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return front.data;

    }
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return rear.data;

    }
    public void printQueue(){
            if(isEmpty()){
                return;
            }
            ListNode current = front;
            while(current!=null){
                System.out.print(current.data+"-->");
                current=current.next;
            }
        System.out.println("null");
    }
    public int dequeue(){
        int result= front.data;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        front=front.next;
        if(front==null){
            rear =null;
        }
        length--;
        return result;
    }



    public static void main(String[] args) {
        Queue qu=new Queue();
        qu.enque(5);
        qu.enque(6);
        qu.dequeue();
        qu.enque(55);
        qu.enque(2);
        System.out.println(qu.first());
        System.out.println(qu.last());
        qu.printQueue();




    }
}
