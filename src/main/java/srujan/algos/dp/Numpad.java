package srujan.algos.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;import java.util.Map;
import java.util.Map.Entry;

public class Numpad {
	
	private static HashMap<Integer,List<Integer>> numPad = new HashMap<>();
	public int knightOnNumpad(int len)
	{
		//int[][] numPad = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
		
		
		/*numPad.put(1,new ArrayList<Integer>(Arrays.asList(6,8)));
		numPad.put(2,new ArrayList<Integer>(Arrays.asList(7,9)));
		numPad.put(3,new ArrayList<Integer>(Arrays.asList(4,8)));
		numPad.put(4,new ArrayList<Integer>(Arrays.asList(3,9,0)));
		numPad.put(5,new ArrayList<Integer>(Arrays.asList()));
		numPad.put(6,new ArrayList<Integer>(Arrays.asList(1,7,0)));
		numPad.put(7,new ArrayList<Integer>(Arrays.asList(2,6)));
		numPad.put(8,new ArrayList<Integer>(Arrays.asList(1,3)));
		numPad.put(9,new ArrayList<Integer>(Arrays.asList(2,4)));
		numPad.put(0,new ArrayList<Integer>(Arrays.asList(6,4)));*/
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
		if(len==0)return 1;
		if(array[loc][len-1]!=0)return array[loc][len-1];
		
		else
		{
			for(int i:numPad.get(loc))
				count = count+recursiveKnightOnNumpad(len-1,i,array);
			array[loc][len-1]=count;
			return count;
		}
	}
	
	public void generateMap()
	{
		int[][] matrix = new int[4][3];
		int row = matrix.length;
		int col = matrix[0].length;
		matrix[0][0]=1;matrix[0][1]=2;matrix[0][2]=3;
		matrix[1][0]=4;matrix[1][1]=5;matrix[1][2]=6;
		matrix[2][0]=7;matrix[2][1]=8;matrix[2][2]=9;
		matrix[3][0]=-1;matrix[3][1]=0;matrix[3][2]=-1;
		for(int i=0 ;i <row; i++)
		{
			for(int j=0 ;j <col; j++)
			{
				List<Integer> indiList = new ArrayList<Integer>();
				System.out.println(i +" " +j);
				//8 possible moves
				//up
				 if(i-2>=0)
				 {
					 //left
					 if(j-1>=0)
						 indiList.add(matrix[i-2][j-1]);
					 if(j+1<col) //right
						 indiList.add(matrix[i-2][j+1]);
				 }
				 //down
				 if(i+2<row)
				 {
					//left
					 if(j-1>=0)
						 indiList.add(matrix[i+2][j-1]);
					 if(j+1<col) //right
						 indiList.add(matrix[i+2][j+1]);
				 }
				 //left
				  if(j-2>=0)
				  {
					  if(i-1>=0)
							 indiList.add(matrix[i-1][j-2]);
					  if(i+1<row) 
							 indiList.add(matrix[i+1][j-2]);
				  }
				  //right
				  if(j+2<col)
				  {
					 
					  if(i-1>=0)
							 indiList.add(matrix[i-1][j+2]);
					  if(i+1<row) 
							 indiList.add(matrix[i+1][j+2]);
				  }
				 
				// left-right
				//left
				//up-down
				//right
				//up-down
				 numPad.put(matrix[i][j],indiList);
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		Numpad n1 = new Numpad();
		n1.generateMap();
		for(Entry<Integer, List<Integer>> list: numPad.entrySet())
		{
			System.out.println(list);
		}
		long nano =System.nanoTime();
		//System.out.println(nano);
		//System.out.println(n1.knightOnNumpad(23));
		System.out.println(System.nanoTime()-nano);
		/*
		 * 97656250
1739058700
		 */
		
	}
}
