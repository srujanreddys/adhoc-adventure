package srujan.algos.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class FriendCircle {
	
	private int[][] frndMatrix ;
	HashSet<Integer> visited  = new HashSet<>();

	public FriendCircle(int[][] frndMatrix)
	{
		this.frndMatrix=frndMatrix;
	}
	public ArrayList<ArrayList<Integer>> getFriendCircle()
	{
		ArrayList<ArrayList<Integer>> finaList = new ArrayList<>();
		for(int row=0 ;row <frndMatrix.length;row++){
			if(!visited.contains(row))
			{
				ArrayList<Integer> circle = new ArrayList<>();
				circle.add(row);
				visited.add(row);
				finaList.add(recursiveCircle(row,circle));
			}
		}

		return finaList;
		 
	}
	public ArrayList<Integer> recursiveCircle(int row,ArrayList<Integer> circle)
	{
		for(int column=0 ;column <frndMatrix[row].length;column++){
			if((!(visited.contains(column)) && frndMatrix[row][column]==1))
			{
				circle.add(column);
				visited.add(column);
				recursiveCircle(column,circle);
			}
		}
		return circle;
	
		
	}
	  public static void main(String[] args) {
	        System.out.println("Hello World!");
	        int[][] matrix ={{1,1,0,0},{1,0,1,0},{0,1,0,0},{0,0,0,0}};
	        FriendCircle f = new FriendCircle(matrix);
	        System.out.println(f.getFriendCircle());
	    }
}
