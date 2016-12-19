package srujan.alogs.strings;

import java.util.HashSet;

public class Palindromes {
	
	public   int bruteForcePalindromeCount(String s)
	{
		int count =0;
		for (int i=1 ;i <= s.length(); i++)
		{
			for(int j= 0; j <= s.length() -i; j++ )
			{
				//System.out.println(i +" "+j);
				String palString = s.substring(j, j+i);
				//System.out.println(palString);
				if(new StringBuilder(palString).reverse().toString().equals(palString))
				{
					count =count +1;
				}
			}
		}
		return count;
		
	}
	public int optimizedPalCount(String str)
	{
		int count=0;
		for(int i=0 ;i<str.length();i++)
		{
			int j=i-1;int k=i+1;
			while(j>=0 && k< str.length() && (str.charAt(j)==str.charAt(k)))
			{
				k++;j--;
				count++;
			}
			j=i-1;k=i;
			while(j>=0 && k< str.length() && (str.charAt(j)==str.charAt(k)))
			{
				k++;j--;
				count++;
			}
			
		}
		return count+str.length();
	}
	public int longestPalindorme(String str)
	{
		int maxPal=1;
		for(int i=0 ;i<str.length();i++)
		{
			int count=0;
			int j=i-1;int k=i+1;
			while(j>=0 && k< str.length() && (str.charAt(j)==str.charAt(k)))
			{
				k++;j--;
				count++;
			}
			if(maxPal<(count*2)+1)maxPal =(count*2)+1;
			j=i-1;k=i;count=0;
			while(j>=0 && k< str.length() && (str.charAt(j)==str.charAt(k)))
			{
				k++;j--;
				count++;
			}
			if(maxPal< (count*2))maxPal =count*2;
		}
		return maxPal;
	}
	
	 static int longestChain(String[] words) {
	        
	        HashSet<String> wordLibrary = new  HashSet<String>();
	        int maxChainCount=0;
	        for(int i=0;i<words.length;i++)
	            wordLibrary.add(words[i]);
	        for(int i=0;i<words.length;i++)
	            {
	            int curMaxCount =getMaxChainToWord(words[i],wordLibrary);
	            if(maxChainCount < curMaxCount)
	                maxChainCount=curMaxCount;
	        }
	     return maxChainCount +1;

	    }
	 static int getMaxChainToWord(String singleWord,HashSet<String> wordLibrary)
	     {
	       //Brute force first
	        int wordMax=0;
	        int wordLen =singleWord.length();
	        for(int i=0 ;i <wordLen;i++)
	        {
	            
	            int localLen=0;
	            String subString =singleWord.substring(0,i) +singleWord.substring(i+1,wordLen);
	            if(wordLibrary.contains(subString))
	            {
	                localLen=1+ getMaxChainToWord(subString,wordLibrary);
	            }
	            if(wordMax<localLen)
	            	wordMax=localLen;
	               
	        }
	     return wordMax ;
	      
	 }
	public static void main(String args[])
	{
		String[] str = {"a","b","ba","bca","bda","bdca"};
		 System.out.println(longestChain(str));
		//System.out.println(makeSentence("thisisawesome"));
		/*long nano =System.nanoTime();
		//System.out.println(nano);
		System.out.println(new Palindromes().bruteForcePalindromeCount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(System.nanoTime()-nano);
		nano =System.nanoTime();
		//System.out.println(nano);
		System.out.println(new Palindromes().optimizedPalCount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(System.nanoTime()-nano);
		System.out.println(new Palindromes().longestPalindorme("helol"));*/
		
		//changeBoolean(150,29,3,5);
	}

}
