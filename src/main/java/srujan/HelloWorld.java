package srujan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import srujan.algos.*;
import srujan.dataStructures.lists.ListNode;

public class HelloWorld {
 
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String s= "A man, a plan, a canal: Panama";
        int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] B = {1,2,3};
        
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node4.next = node2;node2.next = node1;node1.next=node3;
        //sol.sortList(node4);
       // sol.subsets(B);
       // System.out.println(sol.recCombiner(1, 5, 2).toString());
        //System.out.println(isPalindrome(s));
       
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