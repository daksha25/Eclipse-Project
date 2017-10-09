package org.jenkinsci.plugins.clairdockerscannerbuildstep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;

public class Values_File{
	public static File valuesFile(int high,int med,int low,int neg,String build_no,AbstractBuild build) throws IOException, InterruptedException
		 {
		int b_no=Integer.parseInt(build_no);
		//System.out.println("values "+high+" "+med+" "+low+" "+neg+" "+build_no);
		int Total_count=high+med+low+neg;
		String Filename="Severity_Count.properties";
		File writer = new File(build.getRootDir(),"print_stream");
			 FilePath workspace = build.getWorkspace();
			FilePath target = new FilePath(workspace,Filename );
			FilePath outFile=new FilePath(writer);
		
 String FILENAME ="D:\\Severity_Count.properties";
 File file = new File(FILENAME);
		
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				//String data = ("\n"+"Build no :"+b_no+"\t"+"Total count:"+Total_count+"\t"+"values: "+high+"\t"+med+"\t"+low+"\t"+neg);
String data=(b_no+"_High = "+high+"\n"+b_no+"_Med = "+med+b_no+"_Low = "+low+b_no+"_Neg = "+neg);
				

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);

				bw.write(data);

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}
			}

			FilePath Filepath1=new FilePath(file);
			Filepath1.copyTo(target);
		
	
			return file;
		
		 
		 }
}