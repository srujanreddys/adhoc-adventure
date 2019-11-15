package srujan.algos.arrays;

import java.util.Arrays;

import srujan.Learn;

public class MaximalSquare {
	
public static void main(String[] args) {
		
	   char[][] c = new char[][]{
		   {'1','0','1','0','0'},
		   {'1','0','1','1','1'},
		   {'1','1','1','1','1'},
		   {'1','0','1','1','0'}};
		System.out.println(new MaximalSquare().maximalSquare(c));
		
		
		
	}
	  
	    
	    public int maxSquareFrom(int x,int y,char[][] matrix){
	        int len = 0 ;
	        while(x+len < matrix.length && y+len < matrix[0].length){
	            int i = 0;
	            while(i <= len){
	                if(matrix[x+i][y+len]=='1' && matrix[x+len][y+i]=='1')
	                    i++;
	                else
	                    return len;
	            }
	            len++;
	        }	        
	        return len;
	    }
	    public int maximalSquare(char[][] matrix) {
	        int maxLen = 0;
	        for(int i =0;i<matrix.length ;i++){
	            for(int j =0;j<matrix[0].length ;j++){
	                if(matrix[i][j]=='1') {	                	
	                    maxLen = Math.max(maxLen,maxSquareFrom(i,j,matrix));
	                    System.out.println(maxLen +" "+ i +":" +j);
	                }
	            }
	        }
	        return maxLen*maxLen;
	        
	    }
}
