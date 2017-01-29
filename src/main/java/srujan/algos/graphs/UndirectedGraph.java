package srujan.algos.graphs;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph {
	
	 HashMap<Vertex,HashSet<Vertex>> adjList = new HashMap<>() ;
	 HashMap<String,Vertex> vertices = new HashMap<>();
	 HashSet<String> visited = new HashSet<>();
	
	public void DFS(UndirectedGraph graph)
	{
		
		for(Map.Entry<String, Vertex> it : graph.vertices.entrySet())
	    {
	    	if(!visited.contains(it.getKey()))
	    	{
	    		//System.out.println(it.getKey());
	    		recDFS(it.getValue());
	    	}
	    	
	    }
	}
	public void recDFS(Vertex v )
	{
		System.out.println(v.name);
		for(Vertex edge  : v.edges)
		{
			if(!visited.contains(edge))
			{
				visited.add(edge.name);
				recDFS(edge);
			}
		}
	}
	
	public static void main(String[] args)
	{
		UndirectedGraph ug = new UndirectedGraph();
		Vertex a = new Vertex("a",1);
		Vertex b = new Vertex("b",2);
		Vertex c = new Vertex("c",3);
		Vertex d = new Vertex("d",4);
		Vertex e = new Vertex("e",5);
		a.edges.add(b);
		b.edges.add(c);
		c.edges.add(d);
		a.edges.add(e);
		ug.vertices.put(a.name, a);
		ug.vertices.put(b.name, b);
		ug.vertices.put(c.name, c);
		ug.vertices.put(d.name, d);
		ug.adjList.put(a, a.edges);
		ug.adjList.put(b, b.edges);
		ug.adjList.put(c, c.edges);
		ug.adjList.put(d, d.edges);
		ug.DFS(ug);
		
	}

}

class Vertex
{
	 String name;
	 int value;
	 HashSet<Vertex> edges = new HashSet<>();
	 public Vertex(String name,int value)
	 {
		 this.name=name;
		 this.value=value;
	 }
	 @Override
	 public int hashCode()
	 {
		 return name.hashCode();
	 }
	
}
