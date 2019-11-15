package srujan.algos.numbers;

import java.util.*;

public class asteroids {
	 public int[] asteroidCollision(int[] asteroids) {
	        String s= "abc";
	        	char[] c =	s.toCharArray();
	        	String k = new String(c);
	        if(asteroids == null)
	            return null;
	        int maxTracker = 0;
	        int[] postiveArray = Arrays.copyOf(asteroids,asteroids.length);        
	        int[] negativeArray = Arrays.copyOf(asteroids,asteroids.length);;
	        //first iterate right to check all negative to remove
	        for(int i = 0 ;i<asteroids.length;i++ ){
	            if(asteroids[i] > 0)
	                maxTracker = Math.max(maxTracker,asteroids[i]);
	            else if(Math.abs(asteroids[i]) < maxTracker)
	                    postiveArray[i] = 0;
	            else if(Math.abs(asteroids[i]) > maxTracker)
	                maxTracker = 0;
	            else{ //if equals 
	                postiveArray[i] = 0;
	                maxTracker = 0;
	            }    
	        }
	            maxTracker = 0;
	           //second iterate from back to left eliminate positives
	        for(int i = asteroids.length -1 ;i>= 0;i-- ){
	            if(asteroids[i] < 0)
	                maxTracker = Math.max(maxTracker,Math.abs(asteroids[i]));
	            else if(Math.abs(asteroids[i]) < maxTracker)
	                    negativeArray[i] = 0;
	            else if(Math.abs(asteroids[i]) > maxTracker)
	                maxTracker = 0;
	            else{ //if equals 
	                negativeArray[i] = 0;
	                maxTracker = 0;
	            }    
	        }
	    
	        List<Integer> newList = new ArrayList<Integer>();
	        for(int i = 0 ;i<asteroids.length;i++ ){
	            if(postiveArray[i] == 0 || negativeArray[i] ==0)
	                continue;
	            if(postiveArray[i] != 0)
	                newList.add(postiveArray[i]);
	            else
	                newList.add(negativeArray[i]);
	        }
	     int[] returnArray =new int[newList.size()];
	        System.out.println(Arrays.toString(postiveArray));
	        System.out.println(Arrays.toString(negativeArray));
	        int i =0;
	        for(Integer item:newList)
	        {
	            returnArray[i] = item;
	            i++;
	        }
	        return returnArray;
	    } 
	 
	 public int uniquePaths(int m, int n) {
         if(m==0 || n==0) return 0;
        int[][] matrix = new int[m][n];
        int row =0;
        int col =0;
        Arrays.fill(matrix[row],1);
        for(int i =0 ; i <n ;i++)
            matrix[row][i] =1;
        
        for(int j =0 ; j <m ;j++)
            matrix[j][col] =1;
            
        for(int i =1 ; i <m ;i++)
        {    
        
            for(int j =1 ; j <n ;j++)
              matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        }
        return matrix[m-1][n-1];
    }
	 public static void main(String args[])
		{
		 Comparator<int[]> c = new Comparator<int[]>() {
	       	 @Override
	 	    public int compare(int[] o1, int[] o2) {
	 	        return Integer.compare(o2[0], o1[0]);
	 	    }
	  };

		}
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        
		 int[] returnArr = new int[nums.length - k];
		 Set<Integer> set = new TreeSet<Integer>();
		 for(int i = 0 ;i < k;i++)
			 set.add(nums[i]);
		 return returnArr;
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
