package srujan.algos.graphs;

import java.util.*;

public class GraphProblems {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{2,1,1},{2,3,1},{3,0,1}};
		int[][] B =  {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(findMinHeightTrees(5,B));

	}
	
	public static int networkDelayTime(int[][] times, int N, int K) {
    
		 int[] dist = new int[N+1];
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 dist[K] = 0;
		 for(int i =1;i<=N;i++) {
			 for(int[] edge:times )
			 {
				int u = edge[0];int v = edge[1];int w = edge[2];
				if(dist[u] != Integer.MAX_VALUE && dist[v]>(dist[u]+w))
					dist[v] = dist[u]+w;
			 }
		 }
		 int max = 0;
		 for(int i =1;i<=N;i++) {
			 max = Math.max(dist[i], max);
		 }
		 return max==Integer.MAX_VALUE?-1:max;
		
    }
	 public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        
		 int[][] dist = new int[n+1][n+1];
		 int min = Integer.MAX_VALUE;
		 
		 for(int j =0;j<n;j++) {
			 Arrays.fill(dist[j], Integer.MAX_VALUE);
			 dist[j][j] = 0;
		 for(int i =0;i<n;i++) {
			 for(int[] edge:edges )
			 {
				int u = edge[0];int v = edge[1];
				if(dist[j][u] != Integer.MAX_VALUE && dist[j][v]>(dist[j][u]+1)) {
					dist[j][v] = dist[j][u]+1;
				}
				if(dist[j][v] != Integer.MAX_VALUE && dist[j][u]>(dist[j][v]+1)) {
					dist[j][u] = dist[j][v]+1;
				}
			 }
		 }
		 }
		 for(int j =0;j<n;j++) {
			 dist[j][n] = Integer.MIN_VALUE;
			 for(int i =0;i<n;i++) {
				 dist[j][n]  = Math.max(dist[j][i],  dist[j][n]);
		 }
			 System.out.println(Arrays.toString(dist[j]));
			 min = Math.min(dist[j][n],min);
		 }
		 List<Integer> returnList = new ArrayList<Integer>();
		 for(int j =0;j<n;j++) {
			 if(dist[j][n] == min)
				 returnList.add(j);
		 }
		 return returnList;
	    }
	
}
