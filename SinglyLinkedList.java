import java.util.Scanner;

public class SinglyLinkedList {
    public  ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;

        }

    }

    public void display(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }
    public int length(){
        if(head == null){
            return 0;
        }
        int count =0;
        ListNode current = head;
        while (current!=null){
            count++;
            current=current.next;
        }
        return count;

    }
    public  void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head==null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null!=current.next){
            current = current.next;
        }
        current.next=newNode;
    }
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp =head;
        head =  head.next;
        temp.next=null;
        return temp;
    }
    public ListNode deleteLAst(){
        if (head==null||head.next==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next=null;
        return current;
    }

    public void delete(int position){
        if (position==1){
            head = head.next;
        }
        else{
            ListNode previous =head;
            int count =1;
            while(count<position-1){
                previous =previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }
    public boolean search(ListNode head, int searchkey){
        ListNode current = head;
        if(head==null){
            return false;
        }
        while(current!=null){
            if(current.data==searchkey){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public ListNode reverse(ListNode head){

        if (head==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current!=null){
           next = current.next;
           current.next = previous;
           previous=current;
           current=next;
        }
        return previous;
    }
    public  ListNode middleElem(){
        if(head==null){
            return null;
        }
        ListNode slowPtr =head;
        ListNode fastPtr =head;
        while (fastPtr!=null&&fastPtr.next!=null){
            slowPtr =slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;

    }
    public ListNode nthelem(int n){
        if(head==null){
            return null;
        }
        if(n<=0){
            throw new IllegalArgumentException("the value is less than 0");
        }
        ListNode refPtr =head;
        ListNode mainPtr = head;
        int count =0;
        while(count<n){
            refPtr=refPtr.next;
            count++;
        }
        while (refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;

    }
    public void removeDuplicate(){
        if(head==null){
            return ;
        }
        ListNode current = head;
        while (current!=null && current.next!=null){
               if(current.data==current.next.data){
                   current.next=current.next.next;
               }
               else {
                   current=current.next;
               }
        }
    }
    public ListNode inserelemSorted(int value){
        ListNode newNode = new ListNode(value);
        ListNode current =head;
        ListNode temp =null;
        if(head==null){
            return null;
        }
        while (current !=null && current.data<newNode.data){
            temp =current;
            current = current.next;
        }
        newNode.next=current;
        temp.next=newNode;
        return head;

    }
    public void deleteElem(int key){
        ListNode current = head;
        ListNode temp =null;
        if(current!=null&&current.data==key){
            head = current.next;
        }
        while (current!=null&& current.data!=key){
            temp = current;
            current =current.next;
        }
        if(current==null)return ;
        temp.next=current.next;
    }
    public boolean detectLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&& fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }

        }
        return false;

    }
    public ListNode detectLoopStart(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&& fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return getStartingnode(slowPtr);
            }

        }
        return null;

    }
    private ListNode getStartingnode(ListNode slowPtr){
        ListNode temp = head;
        while(slowPtr!=temp){
            temp = temp.next;
            slowPtr =slowPtr.next;
        }
        return temp;
    }
    public void detectToRemoveLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&& fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                removeLoop(slowPtr);
                return ;
            }
        }
    }
    private void removeLoop(ListNode slowPtr){
        ListNode temp = head;
        while(slowPtr.next!=temp.next){
            temp = temp.next;
            slowPtr =slowPtr.next;
        }
        slowPtr.next=null;
    }



    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();



       sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(6);
////        now we have to connect all the  nodes
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next =fifth;
        fifth.next = third;


//        System.out.println("the value of length is "+ sll.length());
//        sll.insertLast(2);
//        sll.insertLast(3);
//        sll.insertLast(5);
//        sll.deleteFirst();
//        sll.insertLast(11);
//        sll.insertFirst(22);
//        sll.deleteFirst();
//        sll.deleteLAst();
//        sll.deleteFirst();
//        sll.deleteLAst();
//        sll.deleteFirst();
//        sll.deleteLAst();
//        sll.insertFirst(7);
//        sll.insertFirst(8);
//        sll.insertFirst(6);
//        sll.insertFirst(6);


//        sll.display();
//      ListNode mid = sll.middleElem();
////        System.out.println(mid.data);
//        ListNode elem= sll.nthelem(4);
//        System.out.println(elem.data);
//sll.removeDuplicate();
//sll.display();
//        sll.display();
//        sll.inserelemSorted(2);
//        sll.display();

//sll.deleteElem(7);
//sll.display();
        System.out.println(sll.detectLoop());
        System.out.println(sll.detectLoopStart().data);
        sll.detectToRemoveLoop();
        sll.display();
    }
}

//