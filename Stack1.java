import java.util.NoSuchElementException;
import java.util.Stack;

public class Stack1 {
    private ListNode top;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode(int data){
            this.data=data;
        }

    }
    public Stack1(){
        top = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        if(length==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result = top.data;
        top =  top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw  new NoSuchElementException();
        }
        return top.data;
    }
    public  String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars =str.toCharArray();
        for(char c:chars){
            stack.push(c);
        }
        for (int i = 0;i<str.length();i++){
            chars[i]=stack.pop();
        }
return new String(chars);
    }
    public static void main(String[] args) {
        Stack1 st=new Stack1();
        String str = "ABCD";
        st.push(5);
        st.push(0);
        st.push(500);
        st.pop();
        System.out.println(st.peek());
        System.out.println(st.reverseString(str));

    }
}
