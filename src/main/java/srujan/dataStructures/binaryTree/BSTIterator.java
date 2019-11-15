package srujan.dataStructures.binaryTree;

import java.util.LinkedList;

public class BSTIterator {

	  
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
   public BSTIterator(TreeNode root) {
	   while(root!=null){
		     stack.push(root);
		     root =root.left;
	   }
       
   }

   /** @return whether we have a next smallest number */
   public boolean hasNext() {
       return !stack.isEmpty();
   }

   /** @return the next smallest number */
   public int next() {
	   if(hasNext())
	   {
		   TreeNode node =stack.pop();
		   int retVal= node.val;
			node=node.right;
			while(node!=null)
			{
				stack.push(node);
				node =node.left;
			}
			return retVal;
	   }
	   else return -1;
       
   }
}
