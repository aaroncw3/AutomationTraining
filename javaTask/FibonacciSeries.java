package task3;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		//task3 print fibonacci series
				System.out.println("Enter the number of fibonacci numbers to print ");
				int count=scanner.nextInt();
				
				System.out.println("fibonacci series up to "+ count + " numbers");
				printFibonacciNum(count);
				
				scanner.close();
				
	}
	
	public static void printFibonacciNum(int count) {
		int num1=1, num2=2;
		int num3;
		
		if (count<=0) {
			return;
		}
		
		System.out.println(num1+"");
		if(count == 1) {
			return;
		}
		
		System.out.println(num2 + "");
		for(int i=3; i<=count; i++) {
			num3=num1+num2;
			System.out.println(num3+"");
			num1=num2;
			num2=num3;
		}
	}


}
