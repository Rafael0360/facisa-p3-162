package br.facisa.p3.ed.graph;

import java.util.ArrayList;

public class Graph {
	private int size;
	private ArrayList<ArrayList<Edge>> graph;
	
	public Graph(int size){
		this.size = size;
		graph = new ArrayList<ArrayList<Edge>> ();
		ArrayList<Edge> l;
		for (int i = 0; i < size; i ++){
			l = new ArrayList<Edge>();
			graph.add(l);
		}
	}
	
	public void add(int point1, int point2, int weight){
		Edge e = new Edge(point2, weight);
		graph.get(point1).add(e);
	}
	
	public Edge getEdge(int index1, int index2){
		return getEdges(index1).get(index2);
	}
	public ArrayList<ArrayList<Edge>> getGraph() {
		return graph;
	}

	public ArrayList<Edge> getEdges(int index){
		return graph.get(index);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
