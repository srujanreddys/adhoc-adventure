package srujan.algos.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class SerialDeSerial {
	

	 // Definition for a binary tree node.
	  

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	       Queue<TreeNode> q = new LinkedList<TreeNode>();
	       StringBuilder sb = new StringBuilder();
	       if(root==null){
	        	sb.append("#");
	        	return sb.toString();
	       }
	       q.add(root);
	       while(q.isEmpty()!=true)
	       {
	    	   TreeNode node = q.poll();
	    	   if(node!=null)
	    	   {
		    	   sb.append(node.val).append(" ");
		    	   q.add(node.left);		       
			       q.add(node.right);
	    	   }
		        else
		        	sb.append("#").append(" ");
	    	   
	       }
	        return sb.toString();
	        
	    }

	    //Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	Queue<TreeNode> q = new LinkedList<TreeNode>();
	    	String[]  str = data.split(" ");
	    	if(data==null || str[0].equals("#"))
	    		return null;
	    	TreeNode root =new TreeNode(Integer.parseInt(str[0]));
	    	q.add(root);
	    	int i=1;
	    	while (i<str.length)
	    	{
	    		TreeNode node = q.poll();
	    		if(str[i].equals("#"))
	    			node.left=null;
	    		else
	    		{
	    			node.left =new TreeNode(Integer.parseInt(str[i]));
	    			q.add(node.left);
	    		}
	    		i++;
	    		if(str[i].equals("#"))
	    			node.right=null;
	    		else
	    		{
	    			node.right =new TreeNode(Integer.parseInt(str[i]));
	    			q.add(node.right);
	    		}
	    		i++;	
	    	}
	    
	        return root;
	    }
	    
	    
	    public List<Integer> preorderTraversal(TreeNode root) {
	            
	            List<Integer> list = new ArrayList<Integer>();
	            if(root==null)
	                return list;
	            else
	            {
	                list.add(root.val);
	            	list.addAll(preorderTraversal(root.left));
	            	list.addAll(preorderTraversal(root.right));
	            	
	            }
	            return list;
	            
	        }
	
	    public static void main(String args[])
		{
			TreeNode root_left = new TreeNode(9);
			TreeNode root_right = new TreeNode(8);
			TreeNode root = new TreeNode(10);
			TreeNode one = new TreeNode(1);
			TreeNode two = new TreeNode(2);
			TreeNode three = new TreeNode(3);
			root.left=root_left;
			root.right=root_right;
			root_left.left=one;
			one.left=two;
			SerialDeSerial s = new SerialDeSerial();
			 String str =s.serialize(null);
             System.out.println(str);
             System.out.println(s.serialize(s.deserialize(str)));
             List<Integer> list = new ArrayList<Integer>();
             System.out.println(s.preorderTraversal(three));
		}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


