package com.cognizant;

 
import java.io.*;

public class Restore_MySqldb
{
	
public static  void restore()

	{
	
    boolean status = false;
    
    //String command = "D:\\MySQL Server 5.6\\bin\\mysql.exe -uroot -pdaksha25* test -e "+"D:\\Documents\\Backup\\test_20160812.sql" ;
    try {
    	//Process process=new ProcessBuilder("D:\\MySQL Server 5.6\\bin\\mysql.exe","-u","root","-p","daksha25*","test2","D:\\Documents\\Backup\\test_20160812.sql").start();
    	Process process=new ProcessBuilder("D:\\MySQL Server 5.6\\bin\\mysql.exe -u root -p daksha25* test2 ","D:\\Documents\\Backup\\test_20160812.sql").start();
    	InputStream in =process.getInputStream();
   	InputStreamReader ins=new InputStreamReader(in);
    	BufferedReader bff=new BufferedReader(ins);
    	String line;
   	  	
   	    		
    	while((line=bff.readLine())!= null)
    	{
    	    	    
   	    			System.out.println("response:"+line);  	
    	}
     } catch (Exception e)
     {
        System.out.println("Exception");
       e.printStackTrace();
    }
	}
        
   
    ////////////////////////////////////////second method/////////////////////////
    
//    try {
//        Process runtimeProcess = Runtime.getRuntime().exec(command);
//      int processComplete = runtimeProcess.waitFor();
//        
//        if (processComplete == 0) {
//            System.out.println("backup: Backup Successfull");
//            status = true;
//       } else 
//        {
//            System.out.println("backup: Backup Failure!");
//        }
//    
//     } catch (IOException ioe) {
//        System.out.println("Exception IO");
//        ioe.printStackTrace();
//    } catch (Exception e) {
//        System.out.println("Exception");
//        e.printStackTrace();
//    }
//    return status;
//}

public static void main(String args[]){
		  
	Restore_MySqldb t = new Restore_MySqldb();
	t.restore();
		
	}

}