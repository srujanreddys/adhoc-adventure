package srujan.algos.arrays;
import java.util.*;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[] {1,3,-1,-3,5,3,6,7};
		//System.out.println(Arrays.toString(maxSlidingWindow(array,3)));
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(1<<4));
		//grayCode(2);

	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0)
            return new int[0];
     	TreeMap<Integer,Integer> bst = new TreeMap<Integer,Integer>();
     	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        int[] returnList = new int[nums.length-k+1];
        
        for(int i = 0; i< nums.length ;i ++) {
        	bst.put(nums[i],i);
            if(i>=k-1) {     
            	System.out.println(i-k+1 + ":" + nums[i-k+1]);
        		returnList[i-k+1]=bst.lastKey();        		
        		if(bst.getOrDefault(nums[i-k+1], -1) == i-k+1)
        			bst.remove(nums[i-k+1]);
        	}
             if(!bst.isEmpty()&& bst.lastKey()<=nums[i]){
        		bst.clear();
                bst.put(nums[i],i);
            }
        	
        	
        	
        }
        //returnList[nums.length-k-1]=bst.last();
        return returnList;
    }
	 public static List<Integer> grayCode(int n) {
	      List<Integer> list = new ArrayList<>() ;

		        list.add(0);
		        for(int i = 0;i < n ;i++){

		            for(int j =list.size() -1; j >=0; j--){
		            	int curNum = list.get(j);
		            	int leftShiftCurNum = 1<<i;
		            	System.out.println(Integer.toBinaryString(leftShiftCurNum));
		               	                	
		                    list.add(leftShiftCurNum | curNum);
		               
		            }
		        }
		        return list;
	    }
	    public int[][] kClosest(int[][] points, int K) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
	        (int) (  Math.sqrt((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]))));
	        for(int[] point:points) {
	        	pq.add(point);
	        	if(pq.size()> K)
	        		pq.remove(point);
	        		
	        }
	        int[][] returnArr = new int[K][2];int i =0;
	        while(!pq.isEmpty()){
	        	returnArr[i] = pq.poll();
	        	i++;
	        }
	        return returnArr;
	        
	    }
	}


