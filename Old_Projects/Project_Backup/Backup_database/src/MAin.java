
public class MAin
{
	public static void main(String[]args){
 
         new MAin().BackupDB("D:/Documents/backup.sql");
      }
 
 
 
 public void BackupDB(String path){
 
    String executeCmd = "D:/MySQL Server 5.6/bin>mysqldump -u root -p daksha25* --all-databases > " + path;
 
    System.out.println(executeCmd);
 
    Process runtimeProcess;
 
    try
    {
       runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd });
         System.out.println("done");
       int processComplete = runtimeProcess.waitFor();
 
       System.out.println(processComplete);
      
       if(processComplete == 0)
       {
    	   System.out.println("done");
          System.out.println("Backup Created Successfully !");
       }
       else
       {
          System.out.println("Couldn't Create the backup !");
       }
    }
    catch(Exception ex)
    {
       ex.printStackTrace();
    }
 
   }
 
     
}