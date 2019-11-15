package srujan.algos.numbers;

import java.util.HashSet;
import java.util.Set;

public class NumberSequences {
	
	/**
	 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10n.
	 * Example: Given n = 2, return 91. (The answer should be the total numbers in the range of 0 <= x < 100, 
	 * excluding [11,22,33,44,55,66,77,88,99])
	 * 
	 * Can be improved by storing the data-- to avoid repeating -DP
	 * @param n
	 * @return
	 */
	  public int countNumbersWithUniqueDigits(int n) {
		  
		  int k=9;
		  int total=1;
		  if(n==0)
		    return 1;
		  if(n==1)
		    return 10;
		  for(int i =0 ; i< n ; i++)
		  {
			  total = total*k;
			  if(i!=0)
				  k--;
		  }
		  total = total +countNumbersWithUniqueDigits(n-1);
		  return total;
		  
	        
	    }
	  public static void main(String args[])
		{
		  int i = 1;
		  int j = 4;
		  String s = i +""+ j;
		  System.out.println(s);	  
		   System.out.println(new NumberSequences().countNumbersWithUniqueDigits(3));
		}
	  public boolean traverse(char[][] board,Set<String> visited,String word,int curPos,int row,int col){
	        // try finding the word
	        if(curPos > word.length()-1)
	            return true;
	        if(row  >= board.length || row < 0 || col >= board[0].length || col < 0 || visited.contains(row +""+col) 
	           ||word.charAt(curPos)  != board[row][col])
	            return false;
	        
	        boolean status = false;
	        visited.add(row +""+col);
	        System.out.println(row +" "+col);//"ABCESEEEFS"
	         if(traverse(board,visited,word,curPos+1,row+1,col) ||traverse(board,visited,word,curPos+1,row-1,col)
	            ||traverse(board,visited,word,curPos+1,row,col+1) ||traverse(board,visited,word,curPos+1,row,col-1))
	             return true;
	         else 
	             visited.remove(row +""+col);
	        return false;
	        
	        
	    }
	    public boolean exist(char[][] board, String word) {
	        if(board == null || word == null || word.length() ==0 )
	            return false;
	        Set<String>  visited = new HashSet<>();
	        for(int i =0 ;i < board.length ;i++){
	            for(int j =0 ;j < board[0].length ;j++){
	                if(word.charAt(0) == board[i][j]){
	                    visited.clear();
	                    if(traverse(board,visited,word,0,i,j))
	                        return true;
	                }
	                    
	            }
	        }
	        return false;
	       
	    }

}
