package srujan.algos.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinations {
	
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
    public static List<List<Integer>> subs(int[] nums) {
    	 List<List<Integer>> combs = new ArrayList<List<Integer>>();
         Arrays.sort(nums);
 		subsetsRec(combs, new ArrayList<Integer>(), 0, nums);
 		return combs;
	}
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

	
}
