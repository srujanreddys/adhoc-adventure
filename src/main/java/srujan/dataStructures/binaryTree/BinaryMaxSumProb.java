package srujan.dataStructures.binaryTree;

import java.util.Arrays;

public class BinaryMaxSumProb {
	
	static int findMax(int n, String tree) {
	     
        String[] treeArray = tree.split("\\s+");
        System.out.println(Arrays.toString(treeArray));
        if(n<=0)
            return 0;
        int[] twoSum= twoMaxGetter(treeArray,0);
        return Math.max(twoSum[0],twoSum[1]);
        
        
    }
 
     static int[] twoMaxGetter(String[] treeArray, int curNode)
     {
         int[] twoSum  = new int[2];
         if(curNode >=treeArray.length || treeArray[curNode].equals("#"))
             return twoSum;
        // System.out.println(curNode +" "+(curNode*2) + " ");
          int[] leftSum = twoMaxGetter(treeArray,(curNode*2)+1);
          int[] rightSum = twoMaxGetter(treeArray,(curNode*2)+2);
          //Current Portfolio is included so left  and right child Portfolios not included
         twoSum[0] = leftSum[1] + rightSum[1] + Integer.parseInt(treeArray[curNode]);
         
         //Current not inluded so getting max of Children 
         twoSum[1] = Math.max(leftSum[0],leftSum[1]) + Math.max(rightSum[0],rightSum[1]);
		 
         
         return twoSum;
          
     }
     
     public static void main(String[] args)
     {
    	 System.out.println(findMax(6,"3 4 5 2 3 2 6 # # # # # # 8 "));
     }


}
