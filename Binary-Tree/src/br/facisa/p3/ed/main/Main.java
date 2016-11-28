package br.facisa.p3.ed.main;

import javax.swing.plaf.synth.SynthSpinnerUI;

import br.facisa.p3.ed.tree.Tree;

public class Main {

	public static void main(String[] args) {
		int[] a = {654,59,12,46, 32, 1, 90};
		Tree arv = new Tree();
		for (int x : a){
			arv.add(x);
		}
		
		System.out.println("Pre order: " + arv.preOrder());
		System.out.println("In order: " +arv.inOrder());
		System.out.println("Post order: " +arv.postOrder());
	}

}
