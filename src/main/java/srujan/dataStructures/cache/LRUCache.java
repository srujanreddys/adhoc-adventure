package srujan.dataStructures.cache;

import java.util.HashMap;



public class LRUCache {
	 HashMap<Integer, DoubleNode> hmap ;
	 DoubleNode head; //Most Recently used
	 DoubleNode tail; //Least recently used
	 int capacity;
	 int curCapcity;
    public LRUCache(int capacity) {
    	this.capacity =capacity; 
    	hmap = new HashMap<>();
    	head = new DoubleNode(0, 0);
    	tail = new DoubleNode(0, 0);
    	head.next=tail;tail.prev=head;
    	
    }
    
    public int get(int key) {
    	 System.out.println("Cap="+curCapcity);
    	DoubleNode node = hmap.get(key);
    	if(node==null)
    		return -1;
    	else{
    		moveToHead(node);
    		return node.val;
    	}
        
    }
    public void moveToHead(DoubleNode node){removeNode(node);addNode(node);}
    public void removeNode(DoubleNode node){
    	
    	node.prev.next=node.next;
    	node.next.prev=node.prev;
    }
    public void addNode(DoubleNode node){
    	node.next=head.next;
    	node.prev=head;
    	head.next.prev=node;
    	head.next=node;
    }
   
    public void put(int key, int value) {
        
    	DoubleNode node = hmap.get(key);
    	if(node==null)
    	{
    		DoubleNode newNode = new DoubleNode(key,value);
    		hmap.put(key, newNode);
    		addNode(newNode);
    		curCapcity++;
    		if(curCapcity>capacity)
    		{
    			hmap.remove(tail.prev.key);
    			removeNode(tail.prev);
    			curCapcity--;
    		}
    	}
    	else{
    		node.val=value;
    		moveToHead(node);
    	}
    }
    
    

    class DoubleNode{
    	 int val;
    	 int key;
    	 DoubleNode next;
    	 DoubleNode prev;
    	 DoubleNode(int x,int y) { val = x; key=y; }
    }
    
    
    public static void main(String[] args)
    {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	 System.out.print(cache.get(1) +",");       // returns 1
    	 cache.put(3, 3);
    	 //cache.put(4, 1);
    	 System.out.print(cache.get(2)+",");  
    	 System.out.print(cache.get(1)+",");  
    	 System.out.print(cache.get(3)+",");   
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));      // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));;       // returns 4
    	LRUCache cache1 = new LRUCache(1);
    	System.out.println("#####################");
    	cache1.put(2, 1);
    	System.out.println(cache1.get(2));
    	cache1.put(3, 2);
    	System.out.println(cache1.get(2));
    	System.out.println(cache1.get(3));
    	System.out.println(cache1.get(2));
    	System.out.println(cache1.get(3));
    	
    	/*
    	 * ["LRUCache","put","get","put","get","get"]
[[1],[2,1],[2],[3,2],[2],[3]]

["LRUCache","put","put","get","put","put","get"]
[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
    	 */
    }
}

