package srujan.algos.strings;

import java.util.HashSet;

public class GenericStringAlgos {
	
	public static void main(String args[])
	{
		 String[] str = {"a","b","ba","bca","bda","bdca"};
		 longestChain(str);
		 GenericStringAlgos g = new GenericStringAlgos();
		}


	 public String reverseWords(String s) {
	        
		 if(!s.matches("\\s+"))  
	     { 
    		 StringBuilder sb = new StringBuilder();
    		 String[] sArray = s.split("\\s+");
    		 for(int i=sArray.length-1 ;i > 0;i--)
    		 {
    			sb.append(sArray[i]).append(" "); 
    		 }
    		// sb.append(sArray[0]);
    	        System.out.println(sb +"test");
    	      return sb.toString();  
	     }
	     else return s;
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
	     return maxChainCount;

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
	     return wordMax +1;
	      
	 }
	 
	
}
