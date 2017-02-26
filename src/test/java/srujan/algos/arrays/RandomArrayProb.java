package srujan.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runner.manipulation.Sortable;

public class RandomArrayProb {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
       
	
        int n1 =m-1;
        int n2 =n-1;
        int iterator = n+m-1;
        while(n1>=0 && n2>=0)
        {
        	if(nums1[n1]>nums2[n2])
        		nums1[iterator--] = nums1[n1--];
        	else
        		nums1[iterator--] = nums2[n2--];
        }
        if(n1==-1)
        {
        	while(n2>=0)
        		nums1[iterator--] = nums2[n2--];
        }
        else
        	while(n1>=0)
        		nums1[iterator--] = nums1[n1--];
    }
public String largestNumber(int[] nums) {
    
	String[] sb = new String[nums.length];
   for(int i=0 ;i <nums.length;i++)
   {
       sb[i]=Integer.toString(nums[i]);
   }
   
   Arrays.sort(sb,new Comparator<String>(){
   		@Override
		
   			
   			    public int compare(String str1, String str2){
   			        String s1 = str1 + str2;
   				String s2 = str2 + str1;
   				return s2.compareTo(s1); // reverse order here, so we can do append() later
   			    }
		
   });
   StringBuilder final1 =new StringBuilder();
   for (int i=0;i<sb.length ;i++)
   {
   	final1.append(sb[i]);
   }
   
   return final1.toString().replaceFirst("^0+(?!$)", "");
   }
public static void main(String[] args)
{
	RandomArrayProb r = new RandomArrayProb();
	int[] array = {3, 30, 34, 5, 9};
	int[] array1 = {0,0};
	System.out.println(r.largestNumber(array1));
}

}
