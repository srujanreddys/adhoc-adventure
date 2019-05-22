package srujan.dataStructures.binaryTree;

public class SortedArrayToBinaryTree {
	
	static int[] nums ;
	    
	    public static void main(String[] args) {
	        System.out.println("Hello World!");
	        nums = new int[] {};
	        
	         recTreeBST(0,nums.length-1); 
	       
	    }
	 public static  TreeNode recTreeBST(int startIndex ,int EndIndex){
		 
	        int mid = (startIndex + EndIndex)/2;
	        System.out.println(startIndex +":"+ EndIndex +" : "+ mid);
	        TreeNode node = new TreeNode(nums[mid]);
	        if(startIndex != EndIndex ) {
	        	if(startIndex != mid)
	        		node.left = recTreeBST(startIndex , mid-1);
	        	if((EndIndex != mid ))
	            node.right = recTreeBST(mid +1  ,EndIndex );
	        }
	        return node;
	    }

}
