package srujan.algos.arrays;

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
	
	public static void main(String[] args)
	{
		int[] nums = {3,3,1,3}; 
		int[]nums1={4,5,6,7,8,1,2,3};
		int[]nums2={3,1};
		int[]nums3={5,1,3};
		System.out.println(new RotatedArray().findMinWithDup(nums));
		//System.out.println(new RotatedArray().findMin(nums));
		//System.out.println(new RotatedArray().findMin(nums1));
	//	System.out.println(new RotatedArray().search(nums2,1));
		//System.out.println(new RotatedArray().search(nums3,3));
	//	System.out.println(new RotatedArray().search(nums1,8));
	}

}
