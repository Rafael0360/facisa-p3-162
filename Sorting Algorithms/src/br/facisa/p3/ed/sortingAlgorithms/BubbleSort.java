package br.facisa.p3.ed.sortingAlgorithms;
/**
 * Class to sort array using Bubble sort algorthm
 * @author Rafael
 *
 */
public class BubbleSort {
	/**
	 * Method of sorting
	 * @param array
	 * @return sorted array
	 */
	public static double[] sort (double[] array){
		for (int i = array.length;  i > 0; i--){
			for (int j = 0; j < i-1; j++){
				if (array[j] > array[j+1]){
					double temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}