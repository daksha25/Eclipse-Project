package com.cognizant.MongoDB;
import com.cognizant.MongoDB.UtilityTask;
public class Backup_Mongodb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String Path_mysqldump=args[0];
		  String Path_Backup=args[1];
		  UtilityTask.Backupdata(Path_mysqldump,Path_Backup);

	}

}
