package srujan.algos.graphs;
import java.util.*;

import org.junit.Test;

public class UnionFindExample {
	
	public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Set<Integer>> nodeMap = new HashMap<>();
        for(int[] edge : edges){
            if(nodeMap.containsKey(edge[0]) || nodeMap.containsKey(edge[1]) )
            {
                if(union(nodeMap,edge[0],edge[1]))
                    return edge;
            }
            else{
                Set<Integer> newSet = new HashSet<Integer>();
                newSet.add(edge[0]);newSet.add(edge[1]);
                nodeMap.put(edge[0],newSet);nodeMap.put(edge[1],newSet);
            }
        }
        int[] x = {1,1};
        return x;
    }
    
    public boolean union(Map<Integer,Set<Integer>> nodeMap,int node1,int node2){
        if(nodeMap.get(node1) == nodeMap.get(node2) )
            return true;
        if(nodeMap.get(node1) == null)
        {
            nodeMap.get(node2).add(node1);
            nodeMap.put(node1,nodeMap.get(node2));
            return false;
        }
         if(nodeMap.get(node2) == null)
        {
            nodeMap.get(node1).add(node2);
            nodeMap.put(node2,nodeMap.get(node1));
            return false;
        }
        nodeMap.get(node1).addAll(nodeMap.get(node2));
        for(Integer node : nodeMap.get(node2))
        	nodeMap.put(node,nodeMap.get(node1));

        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
        	System.out.println(Arrays.toString(edges[i]));
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
    
    @Test
	public  void graphsTest()
	{
    	UnionFindExample ex = new UnionFindExample();
    	int[][] array = {{1,2}, {1,3}, {3,4}, {3,5}, {1,6},{6,7},{1,10},{8,9},{9,10},{6,8},{10,11}};
    	int[][] array1 = {{1,0},{0,2},{0,3}};
    	//System.out.println(Arrays.toString(ex.findRedundantConnection(array)));
    	Map<Integer,Set<Integer>> nodeMap = new HashMap<>();
    	ex.validTree(4,array1);
    	
	}

}
