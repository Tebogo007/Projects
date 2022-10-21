/**
 * 
 */
package com.jwetherell.algorithms.data_structures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

import application.UserProfile;

/**
 * @author TM Mampa 219110597
 *
 */
public class BFS {
	
	@SuppressWarnings({ "unchecked" })
	public static Vertex<UserProfile>[] BreadthFS(Graph<UserProfile> graph, Vertex<UserProfile> root)
	{
		ArrayList<Vertex<UserProfile>> lstVertices = new ArrayList<Vertex<UserProfile>>();
		lstVertices.addAll(graph.getVertices());
		
		
		//final Vertex<UserProfile> userVertices;
		final int i = lstVertices.size();
		final Map<Vertex<UserProfile>, Integer> vertexIndex = new HashMap<Vertex<UserProfile>, Integer>();
		for(int j = 0; j < i; j++)
		{
			final Vertex<UserProfile> userVertices = lstVertices.get(j);
			vertexIndex.put(userVertices, j);
		}
		
		
		
		final byte[][] adjacency = new byte[i][i];
		for(int j=0; j< i; j++)
		{
			final Vertex<UserProfile> userVertices= lstVertices.get(j);
			
			final int index = vertexIndex.get(userVertices);
			
			final byte[] arrByte = new byte[i];
			
			adjacency[index] = arrByte;
			
			final List<Edge<UserProfile>> edges = userVertices.getEdges();
			
			
			for(Edge<UserProfile> edge: edges)
			{
				arrByte[vertexIndex.get(edge.getToVertex())] = 1;
			}
		}
		
		final byte[] selected = new byte[i];
		for(int c=0; c < selected.length; c++)
		{
			selected[c] = -1;
		}
		
		final Vertex<UserProfile>[] array = (Vertex<UserProfile>[]) new Object[i];
		
		Vertex<UserProfile> element= root;
		int n,k = 0;
		int v = vertexIndex.get(element);
		
		array[k] = element;
		selected[v] = 1;
		k++;
		
		
		
		final Queue<Vertex<UserProfile>> queue = new ArrayDeque<Vertex<UserProfile>>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			element = queue.peek();
			n = vertexIndex.get(element);
			v=0;
			while(v<i)
			{
				if(adjacency[n][v] == 1 && selected[v] == -1)
				{
					final Vertex<UserProfile> profiles = lstVertices.get(v);
					queue.add(profiles);
					selected[v] = 1;
					
					
					array[k] = profiles;
					k++;
				}
				v++;
			}
			queue.poll();
		}
		return array;
	}
	
	public static int[] BreadthFirstS(int n, byte[][] adjacencyMatrix, int root)
	{
		final int[] selected = new int[n];
		
		for(int i =0; i <selected.length; i++)
		{
			selected[i] = -1;
		}
		
		int element = root;
		int i = root;
		int array[] = new int[n];
		int k=0;
		
		
		array[k] = element;
		selected[i] =1;
		k++;
		
		final Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			element = queue.peek();
			i=0;
			while(i<n)
			{
				if(adjacencyMatrix[element][i]==1 && selected[i]==-1)
				{
					queue.add(i);
					selected[i] = 1;
					array[k] =i;
					k++;
				}
				i++;
			}
			queue.poll();
		}
		return array;
 	}

	

}
