package com.cognizant;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class Single_database
{  
	

public static boolean backupdata(String mysqldumpPath, String backuppath,String username,String password,String dbname)
{
	
    boolean status = false;
    
   

 
   String command =mysqldumpPath +"\\mysqldump.exe --user=" + username + " --password=" + password + " --databases "+dbname+" -r " +backuppath;
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
	String username = args[0];
    String password = args[1];
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	   String date1=dateFormat.format(date);
	   String dbname=args[2];
	   String backup_path=args[3];
		   String backupName = backup_path+"\\"+dbname+"_"+date1+".sql";
		  
		  Single_database t = new Single_database();
		  String Path_mysqldump=args[4];
		  
		  t.backupdata(Path_mysqldump, backupName,username,password,dbname);
		
	   
	  

}

}