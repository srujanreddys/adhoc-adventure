package srujan.dataStructures.cache;

import java.util.*;

public class LFUCache {

    int capacity = 0; 
    int curCapacity = 0;
    Map<Integer,Node> nodeMap = new HashMap<Integer,Node>();
    Map<Integer,Node> freqMap = new HashMap<Integer,Node>();
    Node headNode = new Node();
    Node tailNode = new Node();
    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap.put(0, tailNode);
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }
    
    public int get(int key) {
    	int toReturn = -1;
        if(nodeMap.containsKey(key)) {
        	toReturn = nodeMap.get(key).val;
        	Node node = nodeMap.get(key);
        	int nextFreq = ( node.prev.freq==node.freq || node.next.freq == node.freq ) ? node.freq : node.next.freq ;       	
        	removeNode(node);
    		node.freq++;
    		addNode(node,nextFreq);
        			
        }
        return toReturn;
    }
    
    public void put(int key, int value) {
    	
    	if(capacity<=0)return;
        if(!nodeMap.containsKey(key)) {
        	if(curCapacity == capacity ) 
        		removeNode(tailNode.prev);
        	else
        		curCapacity++;
        	addNode(new Node(key,value,1),0);
        }
        else {
        	get(key);
        	nodeMap.get(key).val = value;        	
        }
    }
    
    public void removeNode(Node node){        
        nodeMap.remove(node.key);
        if(freqMap.get(node.freq) == node) {
        	if(node.freq != node.next.freq)
        		freqMap.remove(node.freq);
        	else
        		freqMap.put(node.next.freq, node.next);
        }
        	
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addNode(Node node,int nextFreq) {
    	nodeMap.put(node.key,node);    	
    	Node curNode = freqMap.getOrDefault(node.freq, freqMap.get(nextFreq));    		    	
		node.next = curNode;
		node.prev = curNode.prev;
		curNode.prev.next = node;
		curNode.prev = node;
		freqMap.put(node.freq, node);
    }
    public void print() {
    	Node node = headNode;
    	while(node!= null) {
    		System.out.print(node.val +"("+ node.freq +")-->");
    		node = node.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args)
    {
    	 LFUCache cache = new LFUCache(1);
    	 cache.print();
    	 cache.put(3, 1);
    	 cache.put(2, 1);
    	 cache.put(2, 2);
    	 cache.put(4, 4);
    	 cache.print();
    	 System.out.println(cache.get(2));       // returns 1
    	 cache.print();
    	 cache.put(3, 3);    // evicts key 2
    	 cache.print();
    	 System.out.println(cache.get(2));      // returns -1 (not found)
    	 System.out.println(cache.get(3));       // returns 3.
    	 cache.print();
    	 cache.put(4, 4);    // evicts key 1.
    	 System.out.println(cache.get(1));       // returns -1 (not found)
    	 System.out.println(cache.get(3)); // returns 3
    	 System.out.println(cache.get(4));// returns 4
    	 cache.print();
    	  
    }
}
class Node{
    int key;
    int val;
    int freq;
    Node next;
    Node prev;
    public Node(int key,int val,int freq)
    {
        this.key = key;
        this.val = val;
        this.freq =freq;
    }
    public Node(){};
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */