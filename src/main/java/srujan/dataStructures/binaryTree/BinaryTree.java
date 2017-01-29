package srujan.dataStructures.binaryTree;

import java.util.LinkedList;



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
			if(node.left!=null){
				stack.push(root.left);
				continue;
			}
			System.out.println(node);
			if(node.right!=null){
				stack.push(root.right);
				continue;
			}
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		l2.left=l1;
		BSTIterator it = new BSTIterator(l2);
		while(it.hasNext())
		{
			System.out.println("Loop");
			System.out.println(it.next());
		}
	}
	

}


 
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class BSTIterator {

  
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
