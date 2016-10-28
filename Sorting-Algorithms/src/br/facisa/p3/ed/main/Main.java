package br.facisa.p3.ed.main;

import java.io.IOException;

import br.facisa.p3.ed.fileHandling.File;
import br.facisa.p3.ed.sortingAlgorithms.BubbleSort;
import br.facisa.p3.ed.sortingAlgorithms.QuickSort;

public class Main {
	public static void main(String[] args) throws IOException{
		int[] array;
		System.out.println("unordered list:");
		array = File.getTextTxt("txt\\in.txt");
		for (int x: array){
			System.out.print(x + " ");
		}
		System.out.println("\n");
		System.out.println("Bubble Sort");
		array = BubbleSort.sort(array);
		for (int x: array){
			System.out.print(x + " ");
		}
		System.out.println("\n");
		System.out.println("Quick Sort");
		array = QuickSort.sort(array, 0, array.length-1);
		for (int x: array){
			System.out.print(x + " ");
		}
	}
}
