package com.cognizant;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class Backup
{  
	

public static boolean backupdata(String mysqldumpPath, String backuppath,String username,String password)
{
	
    boolean status = false;
    
   

 
   String command =mysqldumpPath +"\\mysqldump.exe --user=" + username + " --password=" + password + " --all-databases"+" -r " +backuppath;
    try {
        Process runtimeProcess = Runtime.getRuntime().exec(command);
      int processComplete = runtimeProcess.waitFor();
        
        if (processComplete == 0) {
            System.out.println("backup: Backup Successfull");
            status = true;
       } else 
        {
            System.out.println("backup: Backup Failure!");
        }
    
 
    
    } catch (IOException ioe) {
        System.out.println("Exception IO");
        ioe.printStackTrace();
    } catch (Exception e) {
        System.out.println("Exception");
        e.printStackTrace();
    }
    return status;
}

public static void main(String args[]){
	//String username = args[0];
	String username="root";
	String password="daksha25*";
	
  //  String password = args[1];
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	   String date1=dateFormat.format(date);
	   String bName="D:\\Documents\\Mongodb_backup\\sqlbackup";
	   
	  // String bName=args[2];
		   String backupName = bName+"_"+date1+".sql";
		  String bData="D:\\MySQL Server 5.6\\bin";
		  Backup t = new Backup();
		 // String bData=args[3];
		  t.backupdata(bData, backupName,username,password);
		
	   
	  

}

}