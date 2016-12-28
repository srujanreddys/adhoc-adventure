package srujan.algos.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Numpad {
	
	private HashMap<Integer,ArrayList<Integer>> numPad = new HashMap<>();
	public int knightOnNumpad(int len)
	{
		//int[][] numPad = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
		
		
		numPad.put(1,new ArrayList<Integer>(Arrays.asList(6,8)));
		numPad.put(2,new ArrayList<Integer>(Arrays.asList(7,9)));
		numPad.put(3,new ArrayList<Integer>(Arrays.asList(4,8)));
		numPad.put(4,new ArrayList<Integer>(Arrays.asList(3,9,0)));
		numPad.put(5,new ArrayList<Integer>(Arrays.asList()));
		numPad.put(6,new ArrayList<Integer>(Arrays.asList(1,7,0)));
		numPad.put(7,new ArrayList<Integer>(Arrays.asList(2,6)));
		numPad.put(8,new ArrayList<Integer>(Arrays.asList(1,3)));
		numPad.put(9,new ArrayList<Integer>(Arrays.asList(2,4)));
		numPad.put(0,new ArrayList<Integer>(Arrays.asList(6,8)));
		int[][] array = new int[10][len];
		return recursiveKnightOnNumpad(len,1,array);
		// 1 2 3
		// 4 5 6
		// 7 8 9 
		// . 0 .
		//for all possible 
		//1-6-1,1-6-7,1-6-0
	}
	public int recursiveKnightOnNumpad(int len,int loc,int[][] array)
	{
		//get all possible i,j--iterate over them
		int count =0;
		if(len==0)
			return 1;
		if(array[loc][len-1]!=0)
			return array[loc][len-1];
		
		else
		{
			for(int i:numPad.get(loc))
			{
				count = count+recursiveKnightOnNumpad(len-1,i,array);
			}
			array[loc][len-1]=count;
			return count;
		}
		
		
	}
	
	
	public static void main(String[] args)
	{
		Numpad n1 = new Numpad();
		long nano =System.nanoTime();
		//System.out.println(nano);
		System.out.println(n1.knightOnNumpad(23));
		System.out.println(System.nanoTime()-nano);
		/*
		 * 97656250
1739058700
		 */
		
	}
}
