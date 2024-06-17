package task3;

import java.util.Scanner;

public class GreatestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stubScanner scanner=new Scanner(System.in);
		Scanner scanner=new Scanner(System.in);
		//task2  find the greatest number among three integers
		System.out.println("Enter first number: ");
		int num1=scanner.nextInt();
		System.out.println("Enter second number: ");
		int num2=scanner.nextInt();
		System.out.println("Enter third number: ");
		int num3=scanner.nextInt();
		System.out.println("Greaest number among(" +num1+ ", " +num2+ ", " +num3+ "): " + getGreatestNum(num1,num2,num3));
		
	}
	
	
	public static int getGreatestNum(int a, int b, int c) {
		if(a>=b && a>=c) {
			return a;
		}else if (b>=a && b>=c) {
			return b;
		}else {
			return c;
		}
	}

}
