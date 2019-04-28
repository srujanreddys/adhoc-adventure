package srujan.dataStructures.trie;

import java.util.LinkedList;
class Trie {

    /** Initialize your data structure here. */
    Node firstNode;
    public Trie() {
        firstNode = new Node('a');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = firstNode;
        int i = 0;
        int wordLen = word.length();
        while( i < wordLen )
        {
            int charLoc = word.charAt(i) - 97;
            if(node.childArray[charLoc] == null){
                node.isArrayEmpty = false;
                node.childArray[charLoc] =  new Node(word.charAt(i));
            }
            node = node.childArray[charLoc];
            i++;
        }
        node.isItEndofWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = firstNode;
        int i = 0;
        int wordLen = word.length();
         while( i < wordLen )
        {
            int charLoc = word.charAt(i) - 97;
            if(node.childArray[charLoc] == null)
                return false;
            node = node.childArray[charLoc];    
             i++;
        }
        return node.isItEndofWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = firstNode;
        int i = 0;
        int wordLen = prefix.length();
         while( i < wordLen )
        {
            int charLoc = prefix.charAt(i) - 97;
            if(node.childArray[charLoc] == null)
                return false;
            node = node.childArray[charLoc];   
             i++;
        }
        return true;
        
    }

    public static void main(String[] args) {
    	 Trie obj = new Trie();
    	 String word = "hello";
    	  obj.insert(word);
    	  boolean param_2 = obj.search(word);
    	  boolean param_3 = obj.startsWith("h");
    	  System.out.println(param_2);
    	  System.out.println(param_3);
    }
}

class Node {
    char val ;
    Node[] childArray = new Node[26];
    boolean isArrayEmpty = true;
    boolean isItEndofWord = false;
    public  Node(char letter){
        this.val = letter;

    }
}