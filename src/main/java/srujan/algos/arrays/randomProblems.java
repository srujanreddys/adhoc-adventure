package srujan.algos.arrays;

import java.util.Arrays;

public class randomProblems {
	
	public int maxArea(int[] height) {
        int maxArea=0;
        for (int i=0 ;i<height.length ; i++)
        {
            for (int j=0 ;j<height.length ; j++)
            {
            	int curArea =Math.abs(j-i) * Math.min(height[i],height[j]) ;
                if( curArea >maxArea)
                	maxArea= curArea;
            }
        }
        return maxArea;
        
    }
	
public String convertToTitle(int n) {
	
	 
	 int i=n-1;
	 StringBuilder column=new StringBuilder();
	 while(i>0)
	 {
		// System.out.println(i%26);
		 char c=  (char) ((char) (i%26)+97);
		column =column.append( c);
		i=i/26-1;
		
		 //factor++;
	 }
	 if(i==0)
		 column.append("A");
	 System.out.println(column.reverse().toString().toUpperCase());
	 return column.reverse().toString().toUpperCase();
        
    }

public String recConvertToTitle(int n) {

	Character c=  (char) ((char) ((n-1)%26)+ 'A');
	 return  n==0 ? "" :recConvertToTitle((n-1)/26) +c.toString();
	}

public int numDecodings(String s) {
	
	
	 int n = s.length();
     if (n == 0) return 0;
     
     int[] memo = new int[n+1];
     memo[0]  = 1;
     memo[1] = s.charAt(0) != '0' ? 1 : 0;
     
     for (int i = 1; i <= n+1; i++)
         if (s.charAt(i-1) == '0') continue;
         else memo[i-1] = (Integer.parseInt(s.substring(i-1,i+1))<=26) ? memo[i-1]+memo[i-2] : memo[i-1];
     
     return memo[n];
 
    
    
}

    


public static void main(String[] args)
{
	int[]nums1={1,2,3,4,5,6,7,8};
	randomProblems r = new randomProblems();
	System.out.println(r.numDecodings("100"));
	//r.convertToTitle(26*26*26 +26*26 +26);
	//System.out.println(r.recConvertToTitle(26));
	//return n == 0 ? "" : recConvertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
	
}
}
