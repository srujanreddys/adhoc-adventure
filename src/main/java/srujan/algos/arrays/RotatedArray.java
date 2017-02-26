package srujan.algos.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class RotatedArray {
	
	
	public int findMin(int[] nums) {
    
		int start = 0;
		int end =nums.length-1;
		while(start <end)
		{
			int mid= start + (end-start)/2;
			System.out.println(mid);
			if(nums[mid] < nums[end])
			{
				end=mid;
			}
			else
			{
				start =mid+1;
				
			}
		}
		
		return nums[start];
	}
	public int search(int[] nums, int target) {
	
		int start = 0;
		int end =nums.length-1;
		while(start <end)
		{
			int mid= start + (end-start)/2;
			if(target ==nums[mid])
				return mid;   //{4, 5, 6, 7, 0, 1, 2}; //4,5,6,7,8,1,2,3
			//System.out.println(mid);
			if(nums[mid] >= nums[start])
			{
			  if(target <nums[mid] && target >=nums[start])
				  end =mid-1;
			  else
				  start =mid+1;
			}
			
			else if(nums[mid] <= nums[end])
			{
				if(target >nums[mid] && target <=nums[end])
					  start =mid+1;
				else
					end =mid-1;
			}
			
			
		}
		if(nums[start]==target)
			return start;
		else
			return -1;
	}
	

	public int findMinWithDup(int[] nums) {
    
		int start = 0;
		int end =nums.length-1;
		while(start <end)
		{
			int mid= start + (end-start)/2;
			System.out.println(mid);
			if(nums[mid] <= nums[end])
				end=mid;
			else
				start =mid+1;
		}
		
		return nums[start];
	}
	
	 
    char[][] landGrid ;
    public int numIslands(char[][] grid) {
        landGrid = grid;
        int islandCount =0 ;
        for(int i =0; i < landGrid.length ; i++)
        {
            for(int j = 0; j < landGrid[0].length ; j++)
            {
                if(landGrid[i][j] == '1')
                {
                    cleanIsland(i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    public void cleanIsland(int i ,int j)
    {
        if(!(i >= landGrid.length ||i < 0|| j >= landGrid[0].length || j< 0|| landGrid[i][j] == '0') )
        {
            landGrid[i][j] = '0';
            cleanIsland(i+1,j);cleanIsland(i,j+1);
            cleanIsland(i-1,j);cleanIsland(i,j-1);
        }
        
        //pq.p
    }
	
	public static void main(String[] args)
	{
		char[][] nums = {{'1','1','1'},
						{'0','1','0'},
						{'1','1','1'}	}; 
		int[]nums1={4,5,6,7,8,1,2,3};
		int[]nums2={3,1};
		int[]nums3={5,1,3};
		RotatedArray r = new RotatedArray();
		//System.out.println(r.lengthOfLongestSubstring("abdvdabf"));
		System.out.println(new RotatedArray().numIslands(nums));
		System.out.println(Integer.toBinaryString(-999999002));
		System.out.println(Integer.toBinaryString(-999999002>>>1));
		System.out.println(Integer.toBinaryString(-999999002>>1));
	/*	 int rowLen = 2;
		  int k =2;
	        int colLen = 2;
	        int rem = k % colLen;
	        int qot = rem==0? (k/colLen)-1:(k/colLen);
	        rem = rem==0?colLen-1:rem-1;
	        
		System.out.println(qot +" "+rem);
		System.out.println(8/3 +" "+8%3);
		System.out.println(9/3 +" "+9%3);
		
		System.out.println(1/3 +" "+1%3);
		System.out.println(2/3 +" "+2%3);
		System.out.println(3/3 +" "+3%3);*/
		 StringBuilder sb = new StringBuilder();
		 sb.append("1");
		 String[] str = sb.toString().split("\\s+");
		 System.out.println(str.length);
		 List<Integer> list = new ArrayList<>();
		 
		
		//System.out.println(new RotatedArray().findMin(nums));
		//System.out.println(new RotatedArray().findMin(nums1));
	//	System.out.println(new RotatedArray().search(nums2,1));
		//System.out.println(new RotatedArray().search(nums3,3));
	//	System.out.println(new RotatedArray().search(nums1,8));
	}

}
