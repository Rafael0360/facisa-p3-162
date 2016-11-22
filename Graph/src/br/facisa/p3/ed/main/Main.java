package br.facisa.p3.ed.main;

import java.util.Scanner;

import br.facisa.p3.ed.graph.Graph;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("size : ");
		int size = input.nextInt();
		Graph graph = new Graph(size);
		int value1, value2, weight;
		System.out.println("enter -1 to exit");
		while(true){
			System.out.print("From ");
			value1 = Integer.parseInt(input.next());
			if (value1 == -1){
				break;
			}
			System.out.print("for ");
			value2 = Integer.parseInt(input.next());
			System.out.print("distance from ");
			weight = Integer.parseInt(input.next());
			graph.addEdge(value1, value2, weight);
		}
		System.out.println("ok");
	}

}
