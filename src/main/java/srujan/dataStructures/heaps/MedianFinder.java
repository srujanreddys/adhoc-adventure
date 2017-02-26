package srujan.dataStructures.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

    /** initialize your data structure here. */
	PriorityQueue<Integer> minQueue = new PriorityQueue<>();
	PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if(o1.equals(o2)) return 0;
			return o1>o2?-1:1;
		}
	});
	
		  
    public MedianFinder() {
    	
	    	
        
    }
    
    public void addNum(int num) {
        if(minQueue.size()!=0 && num>minQueue.peek())
        	minQueue.add(num);
        else
        	maxQueue.add(num);
        balanceQueues();
    }
    
    public void balanceQueues()
    {
    	if(minQueue.size()-1>maxQueue.size())
    		maxQueue.add(minQueue.poll());
    	if(maxQueue.size()-1 >minQueue.size())
    		minQueue.add(maxQueue.poll());
    		
    }
    public double findMedian() {
    	if(minQueue.size()==0 || maxQueue.size()==0)
    	{
    		if(minQueue.size()==0 && maxQueue.size()==0)
    			return 0;
    		return minQueue.size()==0?maxQueue.peek():minQueue.peek();
    	}
    	if(minQueue.size()==maxQueue.size())
    		return ((double)minQueue.peek()+(double)maxQueue.peek())/2;
    	return minQueue.size()>maxQueue.size()?minQueue.peek():maxQueue.peek();
    }
    public static void main(String[] args)
	{
    	MedianFinder s = new MedianFinder();
    	
    	s.addNum(1);
    	
    	s.addNum(2);
    	System.out.println(s.findMedian());
    	s.addNum(3);
    	s.addNum(4);
    	System.out.println(s.findMedian());
    	System.out.println(s.maxQueue.peek());
    	System.out.println(s.minQueue.peek());
    	
		//System.out.println(s.allSubsets("A"));
	}
}