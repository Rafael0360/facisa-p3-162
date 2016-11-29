package br.facisa.p3.ed.main;

import br.facisa.p3.ed.algorithms.Algorithms;
import br.facisa.p3.ed.graph.Graph;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.add(0,1,4);
		g.add(1,0,2);
		g.add(1,3,5);
		g.add(3,4,6);
		g.add(3,2,2);
		g.add(2,4,1);
		g.add(1,2,2);
		Algorithms a = new Algorithms(g);
		System.out.println(a.warshall(0, 4));
		System.out.println(a.BSF(0));
		System.out.println(a.dijkstra(0, 4));
		
	}

}
