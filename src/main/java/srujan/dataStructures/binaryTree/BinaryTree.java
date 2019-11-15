package srujan.dataStructures.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;




public class BinaryTree {
	public void preOrder(TreeNode root)
	{
		//preOrder(root.left);
		System.out.println();
		//preOrder(root.right);
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode node =stack.pop();
			System.out.println(node.val);
			if(node.left!=null){
				stack.push(node.left);
				continue;
			}
			
			if(node.right!=null){
				stack.push(node.right);
				continue;
			}
		}
	}
	
	public TreeNode bstFromPreOrder(String str) {
		String[] s = str.split(",");
		Stack<TreeNode> stack  = new Stack<>();
		int curPos = 1;
		TreeNode root = new TreeNode(Integer.parseInt(s[0]));
		stack.push(root);
		while(!stack.isEmpty() && curPos < s.length) {
			TreeNode node = stack.pop();
			int value = Integer.parseInt(s[curPos]);
			if(node.val > value)
			{
				node.left = new TreeNode(value);
				stack.push(node);
				stack.push(node.left);
			}
			else {
				while(!stack.isEmpty() && stack.peek().val < value) {
					node = stack.pop();
				}
				node.right = new TreeNode(value);
				stack.push(node.right);
			}
			curPos++;
		}
		return root;
	}
public List<Integer> inorderTraversal(TreeNode root) {
        
	 
    List<Integer>  list= new ArrayList<>();
    if(root==null) return list;
   LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
   while(root!=null)
	{
		stack.push(root);
		root =root.left;
	}
	while(!stack.isEmpty())
	{
		TreeNode node =stack.pop();
		   int retVal= node.val;
			node=node.right;
			while(node!=null)
			{
				stack.push(node);
				node =node.left;
			}
			list.add(retVal);
		
	}
		return list;    
    }
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root==null)
        return null;
    if(root.val > p.val){
        TreeNode left  = inorderSuccessor(root.left,p);            
        return (left == null)? root : left;
        
        
       
        
    }
    else {
        TreeNode right = inorderSuccessor(root.right,p);
        return (right == null) ?null : right;
        
    }

}
	
public boolean isValidBST(TreeNode root) {
	System.out.println(Integer.MIN_VALUE +" "+Integer.MAX_VALUE);
    boolean ret= checkBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    System.out.println(ret);
    return ret;
}
public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> finalList = new ArrayList<>(); 
    List<Integer> localList = new ArrayList<>(); 
    TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
    if(root==null)
    	return finalList;
    queue.add(root);
    //localList.add(root.val);
    queue.add(dummyNode);
    while(!queue.isEmpty())
    {
    	TreeNode node =queue.remove();
    	if(node==dummyNode){
    		finalList.add(localList);
    		localList = new ArrayList<>(); 
    		queue.add(dummyNode);
    	}
    	else{
    		localList.add(node.val);
	    	if(node.left!=null)
	    		queue.add(node.left);
	    	if(node.right!=null)
	    		queue.add(node.right);
    	}
    	
    }
    return finalList;
    
    

}
public boolean checkBST(TreeNode root, Long min,Long max)
{
	 
    if(root==null)
        return true;
   // System.out.println(root.val);
    if(root.val<=min ||root.val>=max)
        return false;
    return checkBST(root.left,min,(long) root.val) && checkBST(root.right,(long) root.val,max);
}

public void findMode(TreeNode root) {
    
	 //if(root==null) return null;
	   LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	   while(root!=null)
		{
			stack.push(root);
			root =root.left;
		}
		while(!stack.isEmpty())
		{
			TreeNode node =stack.pop();
			   int retVal= node.val;
				node=node.right;
				while(node!=null)
				{
					stack.push(node);
					node =node.left;
				}
				//list.add(retVal);
			
		}
			  
	    }

public TreeNode invertTree(TreeNode root) {
    if(root==null)
       return root;
    invertTreeRec(root.left,root.right);
    return root;
}

 public void invertTreeRec(TreeNode n1 ,TreeNode n2) {
  if(n1!=null || n2!=null){
        if(n1==null || n2 ==null){
            if(n1==null){
            	 n1=new TreeNode(n2.val);n2=null;invertTreeRec(n1.left,n1.right);
            }
            else{
            	n2=new TreeNode(n1.val);n1=null;invertTreeRec(n2.left,n2.right);
            }
        }
        else {
            int temp =n1.val;
            n1.val =n2.val;
            n2.val =temp;
            invertTreeRec(n1.left,n2.right);
            invertTreeRec(n1.right,n2.left);
        }
  }
    
}
 

	public static void main(String[] args)
	{
		int k=20;
		System.out.println(k++);
		System.out.println(k);
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(2147483647);
		l1.left=l2;
		//l2.right=l3;
		BinaryTree bn = new BinaryTree();
		bn.invertTree(l1);
		//bn.isValidBST(l4);
		//System.out.println(bn.inorderTraversal(l2));
		
	//	System.out.println(bn.inorderTraversal(l1));
		//BSTIterator it = new BSTIterator(l2);
	//	while(it.hasNext())
	//	{
	//		System.out.println("Loop");
	//		System.out.println(it.next());
	//	}
	}
	

}


 
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

