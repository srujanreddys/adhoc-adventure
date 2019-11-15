package srujan;

import java.util.*;

import srujan.algos.*;
import srujan.algos.tree.*;
import srujan.dataStructures.lists.ListNode;

public class HelloWorld {
 
    public static void main(String[] args) {
     
       
    }
   
    public static boolean isPalindrome1(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]","");
        int len = newString.length();
        System.out.println(newString);
        for(int i= 0 ; i < len-1/2 ; i++ ){
        	System.out.println(newString.charAt(i));
            if(Character.toLowerCase(newString.charAt(i)) != Character.toLowerCase(newString.charAt(len-1-i))) 
            	return false;
        }
        //return newString.equalsIgnoreCase(new StringBuilder(newString).reverse().toString());
        return true;
    }
    public static boolean isPalindrome(String newString) {
        
        int len = newString.length();
        int j = len-1; 
        int i = 0;
        System.out.println(newString);
        while(i <= j){
        	System.out.println(newString.charAt(i));
        	if(!Character.isAlphabetic(newString.charAt(i)))
            if(Character.toLowerCase(newString.charAt(i)) != Character.toLowerCase(newString.charAt(len-1-i))) 
            	return false;
        }
        //return newString.equalsIgnoreCase(new StringBuilder(newString).reverse().toString());
        return true;
    }

	
    public void canFinish(int numCourses, int[][] prerequisites) {
    	HashMap<Integer,List<Integer>> adjListMap = new HashMap<>();
        for (int i = 0; i < numCourses ;i++ )
            adjListMap.put(i,new ArrayList<Integer>());
        
        
        
    }
    
}

//Definition for a Node.
class Node {
 public int val;
 public List<Node> neighbors;

 public Node() {}

 public Node(int _val,List<Node> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }
};
