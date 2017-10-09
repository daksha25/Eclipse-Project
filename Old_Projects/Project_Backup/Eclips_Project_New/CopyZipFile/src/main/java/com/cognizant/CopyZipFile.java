package com.cognizant;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
 
public class CopyZipFile {
 
    public void zipFiles(List<File> files,File DestinationFile) throws IOException{

        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;
        
            fos = new FileOutputStream(DestinationFile);
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
            //Compressed the files to zip 
            for(File filePath:files)
            {
                File input = new File(filePath.toString());
                fis = new FileInputStream(input);
                ZipEntry ze = new ZipEntry(input.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[1024];
                int size = 0;
                while((size = fis.read(tmp)) != -1){
                    zipOut.write(tmp, 0, size);
              }
                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            if(fos != null) 
            {
        	   fos.close();
            }
   }
     
    public static void main(String args[]) throws IOException{
         
    	CopyZipFile cz = new CopyZipFile();
    	
    	File Sourcefolder = new File(args[0]);//The path of Folder where the files are present need to zip 
    	File DestPath=new File(args[1]);//Path to create zip file

              
        File[] listOfFiles = Sourcefolder.listFiles();
        //taking file one by one as input from folder
        List <File> files=new ArrayList<File>();
            for (int i = 0; i < listOfFiles.length; i++) 
            {
              if (listOfFiles[i].isFile()) 
              {
            	  files.add(listOfFiles[i]);
            	             
              }
              
            }
            List <Path> ToFolders=new ArrayList<Path>();
           //path of different folder where that .zip file will be copied 
            String str=args[2];
            String[] str1=str.split(",");

            for(int i=0;i<str1.length;i++)//provide path as comma separated
            {
            	Path d = Paths.get(str1[i]);
            	ToFolders.add(d);
            	
            }
        
      
        cz.zipFiles(files,DestPath);
        
        //Check the folder to filePath is available or not
        for(Path p:ToFolders)
		{
			if(Files.exists(p))
			{
				Files.delete(p);//delete privious folder
				Files.copy(DestPath.toPath(), p);//Copy to diffrent path
			}
			else
			{
				Files.copy(DestPath.toPath(), p);
			}
		} 
    } 
        
}
