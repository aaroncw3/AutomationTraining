package task3;

import java.util.Scanner;

public class Concatenate {

	public static void main(String[] args) {
	//task1 concatenate two strings
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter first string: ");
		String str1=scanner.nextLine();
		System.out.println("Enter second string: ");
		String str2=scanner.nextLine();
		
		concatenate(str1, str2);
		
	}
	
	public static void concatenate(String str1, String str2) {
		String concatenated=str1+str2;
		System.out.println("Concatenated string: "+ concatenated);
	}
	
	
	
	

}
