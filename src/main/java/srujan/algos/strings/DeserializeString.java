package srujan.algos.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DeserializeString {

	/*
	Deserialize multiple n-ary trees
	Input 1: "Apple, Car[Key,Trunk[Cart,Bike]], Box[Pen,Earaser,Paper]"
	1 tree input: "Car[Key,Trunk[Cart,Bike]]"

	Output: list of n-ary trees:

	Apple           Car                         Box
	               /   \                     /   |    \
	          Key    Trunk               Pen  Earaser   Paper
	                  /  \
	              Cart    Bike
	*/
	


	    public static int pos =0;
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        deserialize( "Car[Key,Trunk[Cart,Bike]]");
	    }
	    
	     
	    public  static void deserialize(String input){
	    	
	    	
	        List<Node> finaliList = new ArrayList<Node>();
	        System.out.println(input.length());
	        Node node = recursiveDeserialize(input);
	        
	        System.out.println(node.val);
	        
	    }
	    
	    public  static Node recursiveDeserialize(String input){
	    		if(pos>= input.length())
	    			return null;
	        	Node curNode = new Node();
	        	curNode.childList = new ArrayList<Node>();
	        	StringBuilder sb = new StringBuilder();

	            while(Character.isAlphabetic(input.charAt(pos))) {
	                sb.append(input.charAt(pos));pos++;}
	                
	            
	            curNode.val = sb.toString();
	            System.out.println(curNode.val);
	            
	            if(input.charAt(pos)  == '['){pos++;
	               while(input.charAt(pos) != ']')
	                    curNode.childList.add(recursiveDeserialize(input));
	            }
	            if(input.charAt(pos)  == ']')
	            	return curNode;
	            pos++;	 
	            
	            return curNode;
	        }
	    }
	    


	//1 tree input: "Car[Key,Trunk[Cart,Bike]]"




class Node{
    public String val;
    public List<Node> childList;
}
