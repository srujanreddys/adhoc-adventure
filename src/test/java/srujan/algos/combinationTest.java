package srujan.algos;


import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert; 
import  srujan.algos.permutations.combinations;;

public class combinationTest {


	@Test
		public void testReverseWords()
		{
		String s = "leetcode";
		int[][] A = {{5,2},{3,4}};
		Arrays.sort(A, (a,b)->a[0] -b[0]);

		for(int[] t : A)
			System.out.println(Arrays.toString(t));
		//System.out.println("Hello  "+s.substring(0,8));
			//System.out.println(combinations.subs(new int [] {1,2,2,3}).toString());
			//Assert.assertSame("blue is sky the","blue is sky the");
		}
	
        
    
	
	
}
