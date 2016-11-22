package br.facisa.p3.ed.graph;

import java.awt.List;
import java.util.ArrayList;

public class Graph {
	
	private ArrayList[] graph;
	
	public Graph(int size){
		graph = new ArrayList[size];
	}
	
	public void addEdge(int value1, int value2, int weight){
		if (!(graph[value1] == null)){
			Edge e = new Edge(value2, weight);
			graph[value1].add(e);
		}else{
			ArrayList<Edge> list = new ArrayList<Edge>();
			Edge e = new Edge(value2, weight);
			list.add(e);
			graph[value1] = (list);
		}
	}
	
}
