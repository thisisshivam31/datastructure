public class MaxPQ {
    int [] heap;
    int n;
    public MaxPQ(int capacity){
        heap = new int[capacity+1];
        n=0;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void insert(int x){
        if(n==heap.length-1){
            resize(2* heap.length);
        }
        n++;
        heap[n]=x;
        swim(n);
    }
    private void swim(int k){
        while (k>1 && heap[k/2]<heap[k]){
            int temp = heap[k];
            heap[k]=heap[k/2];
            heap[k/2]=temp;
            k= k/2;
        }
    }



    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i =0; i < heap.length;i++){
            temp[i]=heap[i];
        }
        heap = temp;

    }
    public int search(int x){
        for(int i =0;i<n;i++){
            if(heap[i]==x){
                return i;
            }
        }
        return -1;
    }
    public void prinMaxHeap(){
        for(int i =1;i<=n;i++){
            System.out.print(heap[i]+" ");
        }
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
//        System.out.println(pq.size() + "is the size of priority queue") ;
//        System.out.println(pq.isEmpty());
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        pq.prinMaxHeap();
        System.out.println(" ");
        System.out.println("the value at index - "+pq.search(6));


    }
}
