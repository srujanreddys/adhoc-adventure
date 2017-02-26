package srujan.algos.arrays;

import java.util.ArrayList;
import java.util.List;



public class MajorityElement {
	
	public List<Integer> majorityElements(int[] nums) {
        //check for size <2
		List<Integer> list = new ArrayList<Integer>();
		/*if(nums.length==0) return list;
		if(nums.length==1)
		{
			list.add(nums[0]);
			return list;
		}*/
        int majCount1=0;
        int majCount2=0;
        int majEle1=0;
        int majEle2=1;
        
        for(int i =0 ;i <nums.length ;i ++)
        {
            if(nums[i]==majEle1)
              majCount1++;
            else if(nums[i]==majEle2)
              majCount2++;
            else if(majCount1==0){
                majCount1=1;majEle1=nums[i];}
            else if(majCount2==0){
                majCount2=1;majEle2=nums[i];}
            else
            {
                majCount2--;majCount1--;
            }
        }
        majCount2=0;majCount1=0;
         for(int i =0 ;i <nums.length ;i++)
        {
            
            if(nums[i]==majEle1)
              majCount1++;
             if(nums[i]==majEle2)
              majCount2++;
        }
        if(majCount1>nums.length/3) list.add(majEle1);
        if(majCount2>nums.length/3) list.add(majEle2);
        return list;
        
    }
	  public List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> list = new ArrayList<>();
	        for(int i=0 ;i <nums.length ;i++)
	            nums[Math.abs(nums[i])-1] =-Math.abs(nums[Math.abs(nums[i])-1]);
	        for(int i=0 ;i <nums.length ;i++){
	            if(nums[i]>0)
	               list.add(i);
	        }
	         return list;
	    }
	public static void main(String[] args)
	{
		MajorityElement s = new MajorityElement();
		int[] array = {4,3,2,7,8,2,3,1};
		System.out.println(s.findDisappearedNumbers(array));
		System.out.println(s.majorityElements(array));
	}

}
