package srujan.algos;


import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;


import srujan.algos.arrays.HistoGramMaxArea;
import srujan.dataStructures.binaryTree.*;
import  srujan.algos.permutations.combinations;;

public class combinationTest {


	@Test
		public void testReverseWords()
		{
		String s = "leetcode";
		int[] taskCounter = new int[26];
		int[][] A = {{5,2},{3,4}};
		Arrays.sort(A, (a,b)->a[0] -b[0]);
		Arrays.sort(taskCounter, (a,b)-> b-a);

		for(int[] t : A)
			System.out.println(Arrays.toString(t));
		//System.out.println("Hello  "+s.substring(0,8));
			//System.out.println(combinations.subs(new int [] {1,2,2,3}).toString());
			//Assert.assertSame("blue is sky the","blue is sky the");
		}
	@Test
	public void solutions()
	{
	
	int[] A = {2,1,3,1};
	HistoGramMaxArea sol = new HistoGramMaxArea();
	System.out.println(sol.largestRectangleArea(A));
	}
	
	@Test
	public void BinaryTree()
	{
	
	String s  = "7,4,3,5,6,12,10,11,13,14";
	BinaryTree sol = new BinaryTree();
	BSTIterator bt = new BSTIterator(sol.bstFromPreOrder(s));
	while(bt.hasNext())
		System.out.println(bt.next());

	
	}
	
	
	
        
    
	
	
}
