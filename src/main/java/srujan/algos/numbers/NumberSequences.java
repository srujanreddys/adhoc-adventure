package srujan.algos.numbers;

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
		   System.out.println(new NumberSequences().countNumbersWithUniqueDigits(3));
		}
		

}
