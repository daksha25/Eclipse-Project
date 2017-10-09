package com.cognizant;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class Mongodb_Backup
{  
	

public static boolean Backupdata(String mysqldumpPath,String backupfile_path)
{
	
    boolean status = false;
  
      String command=mysqldumpPath+"\\mongodump.exe --out "+backupfile_path;
   
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
	
		  String Path_mysqldump=args[0];
		  String Path_Backup=args[1];
		  Mongodb_Backup t = new Mongodb_Backup();
		  t.Backupdata(Path_mysqldump,Path_Backup);
	   
	  

}

}