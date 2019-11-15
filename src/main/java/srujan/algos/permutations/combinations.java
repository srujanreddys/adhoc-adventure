package srujan.algos.permutations;

import java.util.*;


import org.junit.Test;

public class combinations {
	
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
    /*
     * recursive function to get the combinations
     */
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
    public static List<List<Integer>> subs(int[] nums) {
    	 List<List<Integer>> combs = new ArrayList<List<Integer>>();
         Arrays.sort(nums);
 		subsetsRec(combs, new ArrayList<Integer>(), 0, nums);
 		return combs;
	}
	
	
	 public static void subsetsRec(List<List<Integer>> combs, List<Integer> comb, int start, int[] nums) {
			combs.add(new ArrayList<Integer>(comb));
			if(start < nums.length) {		
				for(int i = start; i < nums.length; i++) {
					if(!(i > start && nums[i-1] == nums[i])) {
					comb.add(nums[i]);
					subsetsRec(combs, comb, i+1, nums);
					comb.remove(comb.size()-1);
					}
				}
			}
		}
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> combs = new ArrayList<List<Integer>>();
		 combinationSumRec(combs,new ArrayList<Integer>(),0,candidates,target);
		 
		 return combs;
	 }

	 public static void combinationSumRec(List<List<Integer>> combs, List<Integer> comb, int start, int[] nums,int target) {
			if(target == 0 )
				combs.add(new ArrayList<Integer>(comb));
				for(int i = start; i < nums.length; i++) {
					if(target-nums[i] >=0) {
						comb.add(nums[i]);
						combinationSumRec(combs, comb, i, nums,target - nums[i]);
						comb.remove(comb.size()-1);
					}
				}
		}
	 public static List<Integer> grayCode(int n) {
	        List<Integer> list = new ArrayList<>() ;

	        list.add(0);
	        for(int i = 0;i < n ;i++){

	            for(int j = list.size() -1; j >=0; j--){
	            	int curNum = list.get(j);
	            	int leftShiftCurNum = 1<<i;
	            	Integer.toBinaryString(curNum);
	               	                	
	                    list.add(leftShiftCurNum | curNum);
	               
	            }
	        }
	        return list;
	    }
	 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		    List<List<Integer>> combs = new ArrayList<List<Integer>>();
		        Arrays.sort(candidates);
		        System.out.println(Arrays.toString(candidates));
				 combinationSum2Rec(combs,new ArrayList<Integer>(),0,candidates,target);
				 
				 return combs;
			 }

			 public static void combinationSum2Rec(List<List<Integer>> combs, List<Integer> comb, int start, int[] nums,int target) {
		         
					if(target == 0 )
						combs.add(new ArrayList<Integer>(comb));
					else {
						for(int i = start; i < nums.length; i++) {
		                    if(start > i && nums[i] == nums[i-1]) {
		                    	continue;
		                    }
							if(target-nums[i] >=0 ) {
								comb.add(nums[i]);
								System.out.println(comb +" : " + nums[i+1]);
								combinationSum2Rec(combs, comb, i + 1, nums,target - nums[i]);
								comb.remove(comb.size()-1);
							}
						}
					}
				}

		@Test
		public  void combinationsTest()
		{
		
			
			HashMap<Integer,Integer> spaceUnitsMap = new HashMap<Integer,Integer>();
			int[] A = {10,1,2,7,6,1,5};
			combinations.combinationSum2(A, 8);
			String p="https://tiny.com/";
			System.out.println('v' -'a');
			String k = p + 2;
			System.out.println(k.replaceFirst("https://tiny.com/", ""));
			//combinations.combinationSum(A, 7).forEach( x -> System.out.print(x));
			//String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
			//System.out.println(p.replaceAll("\\W+" , " ").toLowerCase());
			
			//System.out.println(combinations.grayCode(0));
			//System.out.println(combinations.grayCode(1));
			//System.out.println(combinations.grayCode(2));
			//System.out.println(combinations.grayCode(3));
			//System.out.println(combinations.grayCode(4));
		
		}
	
}
