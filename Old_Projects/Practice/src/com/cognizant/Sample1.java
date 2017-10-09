package com.cognizant;

import java.security.PublicKey;
import java.util.Scanner;

public class Sample1 {
	//public static void main(String[] args) {
		// fibonacci
		/*
		 * int no1=0; int no2=1; int no3=0; int temp; Scanner sc=new
		 * Scanner(System.in); int input=sc.nextInt();
		 * System.out.println("Input"+input); System.out.println(no1+"\n"+no2);
		 * 
		 * 
		 * for (int i = 3; i < input; i++) { no3=no1+no2;
		 * System.out.println(no3); no1=no2; no2=no3;
		 * 
		 * }
		 */

		// prime

		/*
		 * Scanner sc=new Scanner(System.in); int input=sc.nextInt(); int
		 * count=0; System.out.println("Input"+input); for (int i = 1; i <=
		 * input; i++) {
		 * 
		 * if(input%i==0) { //System.out.println("in if"); count++; } }
		 * if(count==2) {
		 * 
		 * System.out.println("Prime");
		 * 
		 * }
		 * 
		 * }
		 */
		// Palindrome
		/*
		 * Scanner sc=new Scanner(System.in); int input=sc.nextInt(); int rem=0;
		 * int rev=0; int pal=input; while(input>0) { rem=input%10;
		 * rev=rev*10+rem; input=input/10;
		 * 
		 * 
		 * } if(rev==pal) { System.out.println("palindrome"); } else
		 * System.out.println("not");
		 */

		// factorial
		/*
		 * Scanner sc=new Scanner(System.in); int num=sc.nextInt(); int fact=1;
		 * for (int i = num; i > 0; i--) { fact=fact*i;
		 * 
		 * } System.out.println(fact);
		 */

		// armstronge number
		/*
		 * int no1,no2,no3; int rem; int cube; Scanner sc=new
		 * Scanner(System.in); int num=sc.nextInt(); while(num>0) { rem=num%10;
		 * cube=rem*rem*rem;
		 * 
		 * num=num/10; }
		 */

		//public int val=10;
		/*int val=10;
		Sample1() {
			// TODO Auto-generated constructor stub
		
			System.out.println("valiue is ="+val);
		}
		
		*/
	
	
	/*public static void main(String args[])
	{
		int no=25;
		if(no > 10)
			  throw new ArithmeticException("not valid");
	     else
	      System.out.println("welcome to vote");*/
		/*try
		{
			int div=25/0;
			System.out.println("Exception"+div);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		//System.out.println("hi this is after exception");
	
	synchronized static void Table(int n) throws InterruptedException
	{
		for (int i = 1; i < 10; i++) {
			System.out.println(n*i);
			
		}
		Thread.sleep(100);
	}
	
	}
	



