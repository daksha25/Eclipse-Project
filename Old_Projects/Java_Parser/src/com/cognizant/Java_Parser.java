package com.cognizant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java_Parser {

	//	 public static void main(String[] args){
//occurence of substring
/*			 String main="mynaameismyndaksha";
			 String sub="myn";
			 int count=0;
			 int strlen=main.length();
			 System.out.println(strlen);
			 int strlen1=sub.length();
			 System.out.println(strlen1);
			 for(int i=0;i<strlen-1;i++)
			 {
				// System.out.println("in for");
				 if((main.substring(i,i+strlen1)).equals(sub))
				 {
					// System.out.println("in if");
					count++;
				 }
				
		            }
			 System.out.println(count);
		    
		}
	}
*/
//occurence of number
/*	public static void main(String[] args){
		int[] m=new int[10];
		int count=0;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			m[i]=sc.nextInt();
		}
		for(int k=0;k<5;k++)
		{
			for(int j=k+1;j<5;j++)
			{
		if(m[k]==m[j])
		{
			
			count++;
			
		}
			
		}	
			
		}
		
		System.out.println(count);
	}
}
*/
			 
//How To Replace Specific String In Text File In Java?
			 static void modify(String filename)
			 {
				File log=new File(filename);
				FileReader fr;
				String replace="test";
				String s;
				String p="same";
				String newc;
				try {
					fr = new FileReader(log);
					BufferedReader br=new BufferedReader(fr);
					try {
						while((s = br.readLine())!=null)
						{
							if(s.contentEquals(replace))
							{
								newc=s.replaceAll(replace,p);
							    System.out.println(newc);
							}
								
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
				
				
				 
				 
			 
			 public static void main(String[] args){
				
				  modify("sample.txt");
				 // System.out.println("done");
				 
			 
		 }
		 }