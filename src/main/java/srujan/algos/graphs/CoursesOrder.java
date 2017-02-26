package srujan.algos.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;



public class CoursesOrder {
	HashSet<Integer> visited = new HashSet<>();
	HashSet<Integer> completed = new HashSet<>();
	HashMap<Integer,List<Integer>> adjListMap = new HashMap<>();
	List<Integer> orderList = new ArrayList<>();
	int flag =0;
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        
		 
	        
	        int noOfEdges = prerequisites.length;
	        for(int i= 0; i <numCourses;i++){
	        	List<Integer> list = new ArrayList<>();
	        	adjListMap.put(i,list);
	        }
	        for(int i= 0; i <noOfEdges;i++)
	        		adjListMap.get(prerequisites[i][1]).add(prerequisites[i][0]);

	        for(Map.Entry<Integer, List<Integer>> it : adjListMap.entrySet())
	        {
	        	if(!visited.contains(it.getKey()))
	        	{
	        		
	        		DFS(it.getKey());
	        	}
	        }
	        int[] finalOutput = new int[numCourses]; ;
	        System.out.println(orderList);
	        if(orderList.size()!=numCourses || flag==1)
	        	return new int[0];
	        int j=0;
	        for(int i=orderList.size()-1; i >=0;i--){
	        	//System.out.println(orderList.get(i));
	        	finalOutput[j]=orderList.get(i);
	        	j++;
	        }
	        return finalOutput;
	        
	    }
	 public void DFS(int key)
	 {
		 visited.add(key);
		 for(int node : adjListMap.get(key))
		 {
			 if(!visited.contains(node))
			 {
				 DFS(node);
			 }
			 else{
				 if(!completed.contains(node))
					 flag=1;
			 }
		 }
		 completed.add(key);
		 orderList.add(key);
	 }
	 public static void main(String[] args)
		{
		 CoursesOrder s = new CoursesOrder();
		 int[][] array = {{1,0},{0,1}};
		 int[][] array2 = {{0,1}};
		 int[][] array1 = {{1,0},{2,0},{3,1},{3,2}};
			//System.out.println(Arrays.toString(s.findOrder(4, array1)));
			System.out.println(Arrays.toString(s.findOrder(2, array2)));
		}
}
