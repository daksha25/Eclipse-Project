package com.cognizant;



import java.io.IOException;


public class Mongodb_Restore
{  
	

public static boolean Restore(String mysqldumpPath,String backup_path,String dbname)
{
	
    boolean status = false;
  
      String command=mysqldumpPath+"\\mongorestore.exe --db "+ dbname+" --drop "+backup_path+"\\" +dbname;


   
    try {
        Process runtimeProcess = Runtime.getRuntime().exec(command);
      int processComplete = runtimeProcess.waitFor();
        
        if (processComplete == 0) {
            System.out.println("Restore : Restore Successfull");
            status = true;
       } else 
        {
            System.out.println("Restore: Restore Failure!");
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
	String database_Name=args[2];
		  Mongodb_Restore t = new Mongodb_Restore();
		  t.Restore(Path_mysqldump,Path_Backup,database_Name);
	   
	  

}

}