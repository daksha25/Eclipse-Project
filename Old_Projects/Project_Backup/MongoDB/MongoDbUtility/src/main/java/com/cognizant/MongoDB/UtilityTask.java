package com.cognizant.MongoDB;


import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UtilityTask {

	private static org.apache.log4j.Logger logger= Logger.getLogger(UtilityTask.class);
	public static boolean Backupdata(String mysqldumpPath,String backupfile_path)
	{
		
	    boolean status = false;
	    BasicConfigurator.configure();
	   
	      String command=mysqldumpPath+"\\mongodump.exe --out "+backupfile_path;
	   
	    try {
	        Process runtimeProcess = Runtime.getRuntime().exec(command);
	      int processComplete = runtimeProcess.waitFor();
	        
	        if (processComplete == 0) {
	            logger.info("backup: Backup Successfull");
	            status = true;
	       } else 
	        {
	    	   logger.info("backup: Backup Failure!");
	        }
	    
	    } catch (IOException ioe) {
	    	logger.info("Exception IO");
	        ioe.printStackTrace();
	    } catch (Exception e) {
	    	logger.info("Exception");
	        e.printStackTrace();
	    }
	    return status;
	}
	
	public static boolean Restore(String mysqldumpPath,String backup_path,String dbname)
	{
		
	    boolean status = false;
	  
	      String command=mysqldumpPath+"\\mongorestore.exe --db "+ dbname+" --drop "+backup_path+"\\" +dbname;


	   
	    try {
	        Process runtimeProcess = Runtime.getRuntime().exec(command);
	      int processComplete = runtimeProcess.waitFor();
	        
	        if (processComplete == 0) {
	        	logger.info("Restore : Restore Successfull");
	            status = true;
	       } else 
	        {
	    	   logger.info("Restore: Restore Failure!");
	        }
	    
	 
	    
	    } catch (IOException ioe) {
	    	logger.info("Exception IO");
	        ioe.printStackTrace();
	    } catch (Exception e) {
	    	logger.info("Exception");
	        e.printStackTrace();
	    }
	    return status;
	}
}
