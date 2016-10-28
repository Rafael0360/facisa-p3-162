package br.facisa.p3.ed.fileHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
	     InputStream aux = new FileInputStream("txt\\in.txt");
	     InputStreamReader aux2 = new InputStreamReader(aux);
	     BufferedReader aux3 = new BufferedReader(aux2);
	 
	     String text = aux3.readLine();
	     String[] au;
	     List <Integer> array = new ArrayList();
	     au = text.split(" ");
	     aux3.close();
	     for(String x: au){
	    	 System.out.println(x);
	     }
	 }
}
