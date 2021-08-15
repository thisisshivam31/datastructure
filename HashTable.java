public class HashTable {
    private   HashNode [] buckets;
    private int numOfBuckets;
    private int size;
    private Integer key;
    private String value;

    public HashTable(){
        this(10);
    }
    public HashTable(int capacity){
        this.numOfBuckets=capacity;
        buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }
    private class HashNode{
         private  Integer key;
        private String value;
        private HashNode next;


        public HashNode(Integer key, String value) {
            this.key=key;
            this.value=value;
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void put(Integer key,String value){
        if(key==null||value==null){
            throw new IllegalArgumentException();
        }
        int BucketIndex = getBucketIndex(key);
        HashNode head = buckets[BucketIndex];
        while(head!=null){
            if(head.key==key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[BucketIndex];
        HashNode node = new HashNode(key,value);
        node.next=head;
        buckets[BucketIndex]=node;
    }
    private int getBucketIndex(Integer key){
        return key%numOfBuckets;

    }
    public String get(Integer key){
        if(key==null){
            throw new IllegalArgumentException();
        }
        int BucketIndex = getBucketIndex(key);
        HashNode head = buckets[BucketIndex];
        while(head!=null) {
            if (head.key==(key)) {
                return head.value;
            }
            head=head.next;
        }
       return null;
    }
    public String remove(Integer key){
        int bucketindex = getBucketIndex(key);
        HashNode head = buckets[bucketindex];
        HashNode previous = null;
        while(head!=null){
            if(head.key==key){
                break;
            }
            previous=head;
            head=head.next;
        }
        size--;
        if(head==null){
            return null;
        }
        if(previous!=null){
            previous.next=head.next;
        }
        else{
            buckets[bucketindex]=head.next;
        }
        return head.value;
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.put(3,"Siddharth");
        ht.put(33,"Ram");
        ht.put(43,"ok");
        ht.put(1,"hello");
        ht.put(5,"jabe");
//        System.out.println(ht.size);
        System.out.println(ht.get(5));
        System.out.println( ht.size);
        System.out.println(ht.remove(1));
        System.out.println(ht.size);

    }
}
