package srujan.algos.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TopKFrequent {

public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> freqMap = new HashMap<>();
      //  List<List<Integer>> list = new ArrayList<List<Integer>>(nums.length);
        List<Integer>[] list = new List[nums.length + 1];
        for (int n : nums) {
        	freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    	}
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        	 System.out.println(entry.getKey()+"->"+entry.getValue());
        	if(list[entry.getValue()]==null)        	
        		list[entry.getValue()] = new ArrayList<>();
        	
        	list[entry.getValue()].add(entry.getKey());
        	
        }
        List<Integer> finalList = new  ArrayList<>();
        for(int i=nums.length; i>=0 && finalList.size()<k;i--)
        {
        	if(list[i]!=null)
        	finalList.addAll(list[i]);
        }
        System.out.println(finalList);
        while(finalList.size()>k)
			finalList.remove(finalList.size()-1);
        return finalList;
     
    }

public List<Integer> topKFrequent1(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
public static void main(String[] args)
{
	TopKFrequent t = new TopKFrequent();
	int[] array = {1,1,1,2,2,2,3};
	int[] array1 = {1};
	System.out.println(t.topKFrequent1(array, 1));
	
	
}
}
