package com.cognizant;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String name;
		String regex="\\s*";
		Scanner in=new Scanner(System.in);
		try{
		System.out.println("Enter the name");
		name=in.nextLine();
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(name);
		if(matcher.find())
		{
			System.out.println("true");
		}
		// TODO Auto-generated method stub

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
