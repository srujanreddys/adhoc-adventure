package srujan;

import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Learn {
	
	public  static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/pankaj/Downloads/myfile.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printInput(int param1,int param2 ) {
		System.out.println(param1+param2);	
		param1 = 5;
			
	}
	

	
	public static String testFunction(int a) {
		System.out.println(a);//4
		a = 10;
		System.out.println(a); //8
		return "srujan";
		
	}
	

	

}












