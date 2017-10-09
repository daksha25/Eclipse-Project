package com.cognizant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class App
{

	
	        public static void main(String args[])
	        {
	        File file =new File("D:\\Documents\\AssemblyInfo.cs");
	        Scanner in = null;
	        String input="";
	        String REGEX=".*\\\"(.*)\\\".*";
           Pattern pattern;
           Matcher matcher;

	        try {
	            in = new Scanner(file);
	            while(in.hasNext())
	            {
	                String line=in.nextLine();
	                if(line.contains("AssemblyVersion"))
	                {
	                	 input=line;
	                }
	            }
	                 
	                pattern = Pattern.compile(REGEX);
	                matcher = pattern.matcher(input);
	                if(matcher.find()==true)
	                {
	                	
	                	System.out.println(matcher.group(1));
	                	
	                }
	             
	            
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }
	        }
