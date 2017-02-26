package srujan.algos.arrays;
import java.io.*;
import java.util.*;

public class Subsequence {
	
	
	public void ConsecutiveSubsequences(int[] array)
	{
		
	}

}

//Copyright Karat, Inc. 2016-2017 - Do not distribute or republish.


/*
* Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of the rectangle -- either top-left and bottom-right; or top-left, width, and height.
*/

class Solution {


// Sample input - N x M 
static int[][] image = {  
 {1, 1, 1, 1, 1, 1, 1},
 {1, 1, 1, 1, 1, 1, 1},
 {1, 1, 1, 0, 0, 0, 1},
 {1, 0, 1, 0, 0, 0, 1},
 {1, 0, 1, 1, 1, 1, 1},
 {1, 0, 1, 0, 0, 1, 1},
 {1, 1, 1, 0, 0, 1, 1},
 {1, 1, 1, 1, 1, 1, 1},
};
static List< List<Integer>> finalList = new  ArrayList<>();

// Your function here


public static void main(String[] args) {
 // Arrays.toString(...);
 System.out.println(rectangleExtracter());

}

public static List< List<Integer>>  rectangleExtracter()
{

 int flag =0;
 int[] location = new int[4];
 int numOfRows = image.length;
 int numOfColumns =image[0].length;
 System.out.println(numOfRows +" " +numOfColumns);
 int [][] visited= new int[numOfRows][numOfColumns];
 
 //Get the starting 0 first scanning row by row
 int i=0;
 int j=0 ;
 while(i < numOfRows)
 {
     while(j <numOfColumns)
     {
       if(image[i][j]==0&& visited[i][j]!=1)
       visited= singleRectExtracter( i, j,numOfRows,numOfColumns,visited);
       
     }
 }
 return finalList;
 
}

public static int[][] singleRectExtracter(int i,int j,int numOfRows,int numOfColumns,int[][] visited)
{
  
       List< Integer> singleList = new  ArrayList<Integer>();
       int[] location = new int[4];
         location[0]=i;
         location[1]=j;
         
         System.out.println(i +" " +j);
         
          //Got Zero scan for widht and height
           for(int width=j ; width<numOfColumns && image[i][width]==0 ;width++)
           {
              visited[i][width]=1;
              location[2]++;
           }
           
          for(int height=i ; height<numOfRows && image[height][j]==0 ;height++)
           {
            visited[height][j]=1;
              location[3]++;
           }
  singleList.add( location[0]);
  singleList.add( location[1]);
  singleList.add( location[2]);
  singleList.add( location[3]);
      finalList.add(singleList);
       return visited;
}
}
