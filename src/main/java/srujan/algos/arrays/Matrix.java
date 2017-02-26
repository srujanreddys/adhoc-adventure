package srujan.algos.arrays;

import java.util.ArrayList;
import java.util.List;



public class Matrix {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
	        if(matrix.length==0)
	          return new ArrayList<Integer>();
	        return spiralOrderRec(matrix,0,matrix.length-1,0,matrix[0].length-1);
	    }
	    
	     public List<Integer> spiralOrderRec(int[][] matrix,int startRow,int endRow,int startCol,int endCol) {
	          
	          List<Integer> list = new ArrayList<Integer>();
	          int row =startRow;int col = endCol;
	          for(int j=startCol;j<=endCol; j++)
	            list.add(matrix[row][j]);
	          for(int i=startRow +1 ;i <= endRow ;i++)
	            list.add(matrix[i][col]);
	          if(startRow !=endRow){
	           row= endRow;
	          for(int j=endCol-1;j>=startCol; j--)
	            list.add(matrix[row][j]);
	          }
	          if(startCol!=endCol){
	           col=startCol;
	          for(int i=endRow -1 ;i >= startRow +1 ;i--)
	            list.add(matrix[i][col]);
	          }
	          if(endRow-startRow >1 && endCol - startCol >1)
	              list.addAll(spiralOrderRec(matrix,startRow+1,endRow-1,startCol+1,endCol-1));
	          return list;
	     }
	     public static void main(String[] args)
	 	{
	    	 Matrix s = new Matrix();
	    	 int[][] twoArray ={{2,5,8},
	    			 			{4,0,-1}};
	 		System.out.println(s.spiralOrder(twoArray));
	 	}

}
