import java.util.Locale;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    public void insert(String word){

        if(word==null || word.isEmpty()){
            throw new IllegalArgumentException();
        }
        word = word.toLowerCase(Locale.ROOT);
        TrieNode current = root;
        for(int i =0; i<word.length();i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(current.children[index]==null){
                TrieNode node = new TrieNode();
                current.children[index]=node;
                current=node;
            }
            else{
                current = current.children[index];
            }

        }
        current.isWord = true;

    }
    public boolean search(String word){
        return false;

    }
    public static void main(String[] args) {
        Trie tr =new Trie();
        tr.insert("cat");
        tr.insert("cab");
        System.out.println("You inserted successfully !!!");

    }
}
