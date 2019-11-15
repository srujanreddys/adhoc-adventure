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
	    public TreeNode deserialize(String data,String del) {
	    	Queue<TreeNode> q = new LinkedList<TreeNode>();
	    	String[]  str = data.split(del);
	    	for(int i= 0;i<str.length;i++)
	    	System.out.print(str[i]+" ");
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
	
	    
	    public List<Integer> recRightSideView(TreeNode root,int toGoDepth) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(root==null)
	           return list;
	        if(toGoDepth <=0)
	            list.add(root.val);
	        List<Integer> rightList =recRightSideView(root.right,toGoDepth-1);
	        list.addAll(rightList);
	        list.addAll(recRightSideView(root.left,Math.max(rightList.size(),toGoDepth-1)));
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
			String testS= "-64,12,18,-4,-53,#,76,#,-51,#,#,-93,3,#,-31,47,#,3,53,-81,33,4,#,-51,-44,-60,11,#,#"
					+ ",#,#,78,#,-35,-64,26,-81,-31,27,60,74,#,#,8,-38,47,12,-24,#,-59,-49,-11,-51,67,#,#,#,#,#,"
					+ "#,#,-67,#,-37,-19,10,-55,72,#,#,#,-70,17,-4,#,#,#,#,#,#,#,3,80,44,-88,-91,#,48,-90,-30,#,#"
					+ ",90,-34,37,#,#,73,-38,-31,-85,-31,-96,#,#,-18,67,34,72,#,-17,-77,#,56,-65,-88,-53,#,#,#,-33,"
					+ "86,#,81,-42,#,#,98,-40,70,-26,24,#,#,#,#,92,72,-27,#,#,#,#,#,#,-67,#,#,#,#,#,#,#,-54,-66,-36,"
					+ "#,-72,#,#,43"
					+ ",#,#,#,-92,-1,-98,#,#,#,#,#,#,#,39,-84,#,#,#,#,#,#,#,#,#,#,#,#,#,-93,#,#,#,98";
			SerialDeSerial s = new SerialDeSerial();
			TreeNode node =s.deserialize(testS, ",");
			 System.out.println(s.recRightSideView(node,0));
			 String str =s.serialize(null);
             System.out.println(str);
             System.out.println(s.serialize(s.deserialize(str," ")));
             List<Integer> list = new ArrayList<Integer>();
             System.out.println(s.preorderTraversal(three));
		}

}




