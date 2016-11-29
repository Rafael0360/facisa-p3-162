package br.facisa.p3.ed.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import br.facisa.p3.ed.graph.Graph;

public class Algorithms {
	private static final int INFINITE = 99999;
	private Graph graph;
	
	public Algorithms(Graph graph){
		this.graph = graph;
	}
	
	public int dijkstra(int point1, int point2){
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		int[] distance = new int[graph.getSize()];
		boolean[] visited = new boolean[graph.getSize()];
		
		for (int i = 0; i < graph.getSize() ; i ++){
			distance[i] = INFINITE;
			visited[i] = false;
		}
		
		distance[point1] = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(distance[point1]);
		temp.add(point1);
		q.add(temp);
		while(!q.isEmpty()){
			//System.out.println(temp);
			temp = q.peek();
			
			int u = temp.get(1);
			
			q.remove();
			
			if(!visited[u]){
				visited[u] = true;
				
				for (int i = 0; i < graph.getEdges(u).size(); i++){
					int v = graph.getEdge(u, i).getValue();
					int cost = graph.getEdge(u, i).getWeight();
					if (distance[v] > (distance[u]+cost)){
						distance[v] = distance[u]+cost;
						temp = new ArrayList<Integer>();
						temp.add(distance[v]);
						temp.add(v);
						q.add(temp);
					}
				}
				
			}
		}
		
		return distance[point2];
		
	}
	
	public ArrayList<Integer> DSF(int initial){
		ArrayList<Integer> l = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.getSize()];
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < graph.getSize(); i++){
			visited[i] = false;
		}
		
		l.add(initial);
		while (true){
			if(!visited[initial]){
				
				visited[initial] = true;
				s.push(initial);
			}
			
			boolean found = false;
			int d = 0;
			for (int i = 0; i < graph.getEdges(initial).size(); i++){
				d = graph.getEdge(initial, i).getValue();
				
				if(!visited[d]){
					if (!l.contains(d)){
						//System.out.println(d);
						l.add(d);
					}
					found = true;
					break;
				}
				
			}
			if (found){
				initial = d;
			}else{
				s.pop();
				if(s.isEmpty()){
					break;
				}else{
					initial = s.peek();
				}
			}
			
		}
		return l;
	}
	
	public ArrayList<Integer> BSF(int initial){
		boolean[] visited = new boolean[graph.getSize()];
		ArrayList<Integer> l = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < graph.getSize(); i++){
			visited[i] = false;
		}
		
		l.add(initial);
		visited[initial] = true;
		while (true){
			for (int i = 0; i < graph.getEdges(initial).size(); i++){
				int d = graph.getEdge(initial, i).getValue();
				if (!visited[d]){
					l.add(d);
					visited[d] = true;
					q.add(d);
				}
			}
			if (!q.isEmpty()){
				initial = q.peek();
				q.remove();
			}else{
				break;
			}
		}
		return l;
	}
	
	public int warshall(int point1, int point2){
		int[][] matrix = new int[graph.getSize()][graph.getSize()];
		
		for (int i = 0; i < graph.getSize(); i++){
			for (int j = 0; j < graph.getSize(); j++){
				matrix[i][j] = INFINITE;
			}
		}
		
		for (int i = 0; i < graph.getSize(); i++){
			for (int j = 0; j < graph.getEdges(i).size(); j++){
				matrix[i][graph.getEdge(i, j).getValue()] = graph.getEdge(i, j).getWeight();
			}
		}
		
		for(int k = 0; k < graph.getSize(); k++){
			for(int i = 0; i < graph.getSize(); i++){
				for (int j = 0; j < graph.getSize(); j++){
					if(matrix[i][k] + matrix[k][j] < matrix[i][j]){
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		return (matrix[point1][point2]);
	}
	
	
	public int ford(int point1, int point2){
		int[][] matrix = new int[graph.getSize()][graph.getSize()];
		int[] distance = new int[graph.getSize()];
		for (int i = 0; i < graph.getSize(); i++){
			for (int j = 0; j < graph.getSize(); j++){
				matrix[i][j] = INFINITE;
			}
		}
		
		for(int i = 0; i < graph.getSize(); i++){
			distance[i] = INFINITE;
		}
		

		for(int k = 0; k < graph.getSize(); k++){
			for(int i = 0; i < graph.getSize(); i++){
				for (int j = 0; j < graph.getSize(); j++){
					if(matrix[i][k] + matrix[k][j] < matrix[i][j]){
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < graph.getSize(); i++){
			for (int j = 0; j < graph.getSize(); j++){
				if (matrix[i][j] != INFINITE){
					if (distance[i] > distance[j]+matrix[i][j]){
						System.err.println("contains negative cycle");
					}
				}
			}
		}
		
		return matrix[point1][point2];
		
	}
	
}
