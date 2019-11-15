package srujan.algos.tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    
    
    
}
 class Node implements Comparable<Node>{
    int pos;
    int val;
    public  Node (int pos,int val){
        this.pos =pos;
        this.val =val;
    }
    @Override
		public int compareTo(Node o1) {
			// TODO Auto-generated method stub
		
			return this.val-o1.val;
		}
	
}
