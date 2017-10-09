package com.cognizant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Append_Data {
	
	public static void main(String[] args) {
	    try {

	        String content = "This is the content to write into file";

	        File file = new File("D:\\values.txt");

	        // if file doesnt exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(content);
	        bw.close();

	        System.out.println("Done");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	}


