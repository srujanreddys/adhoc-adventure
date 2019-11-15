package srujan.algos.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,3,7,7,7,9};
		//System.out.println(Arrays.toString(searchRange(A,7)));
		char[] tasks   = {'A','A','A','C','D','E'};
		System.out.println(leastInterval(tasks, 2));

	}
	 public static int leastInterval(char[] tasks, int n) {
	        
	        int[] taskCounter = new int[26];
	        
	        int totalCount =0;
	        for(char task: tasks) {
	        	
	            taskCounter[task-'A'] ++;
	        }
	        Arrays.sort(taskCounter);
	        while(taskCounter[25]!=0) {
	        	int curMaxCount = taskCounter[25];
	        	int i =0;
	        	int pos = 25;
	        	while(pos>=0 && taskCounter[pos]!=0
	        			&&( i<=n+1 || taskCounter[pos] == curMaxCount))
	        	{
	        		taskCounter[pos] --;
	        		totalCount++;
	        		i++;
	        		pos--;
		        	System.out.print((char)(pos+'A'+1) +"->");
	        	}

	        	if(i<n+1 && taskCounter[25]!=0) {
	        		System.out.print("I->");
	        		totalCount = totalCount + n+1-i;
	        	}
	        }
	        return totalCount;
	        
	    }
	  public static int[] searchRange(int[] nums, int target) {
	        int i = 0;
	        int j = nums.length -1;
	        int[] pos = new int[2];
	        Arrays.fill(pos, -1);
	        
	        while(i <= j ){
	            int mid = (i+j)/2;
	            if(target < nums[mid])
	            	j = mid -1;
	            else if(target == nums[mid]) {
	            	if((mid-1 >= 0 && nums[mid-1] < target)||mid==0) {
	            		pos[0] =  mid;break;
	            	}
	            	else
	            		j = mid-1;
	            }
	            else
	            	i= mid +1;
	        }
	        i = 0;
	        j = nums.length-1;
	        while(i <= j ){
	            int mid = (i+j)/2;
	            if(target < nums[mid])
	            	j = mid -1;
	            else if(target == nums[mid]) {
	            	if((mid+1 <= nums.length-1 && nums[mid+1] > target)||mid==nums.length-1)
	            		{
	            		pos[1] =  mid;break;
	            		}
	            	else
	            		i = mid+1;
	            }
	            else
	            	i= mid +1;
	        }
	        return pos;
	    }
}
