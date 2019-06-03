package srujan.algos.arrays;

/**
* try to find max are with each bar at position i included in that area
* trick here is from how we store left[i] and right[i] and use them to jump to the next highest
* i.e. skipping the increasing and decreasing orders.
**/
public class HistoGramMaxArea {
    
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length-1] = heights.length;
        int maxArea = heights[0];
   
    
        for(int i = 1; i < heights.length; i++){
            int p = i-1;
            while(p >= 0 && heights[p] >= heights[i]) 
                p = left[p];
            left[i] = p;
                
            
        }
        
        for(int i = heights.length - 2 ; i >= 0; i--){
            int p = i+1;
            while(p <= heights.length-1 && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
                
        }
         for(int i = 0; i < heights.length; i++)
                maxArea = Math.max(maxArea, ( right[i] - left[i]  - 1)*heights[i]);     
        return maxArea;
    }
}