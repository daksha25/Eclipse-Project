package com.plugin.postbuild_test;
import hudson.Launcher;
import hudson.Extension;
import hudson.FilePath;
import hudson.util.FormValidation;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import java.io.IOException;

public class MongorDbrestore extends Builder implements SimpleBuildStep {

	private final String Mongodb_Path;
    private final String BackupFile_Path;
    private final String DatabaseName;
  
    @DataBoundConstructor
    public MongorDbrestore(String Mongodb_Path,String BackupFile_Path,String DatabaseName) {
        this.Mongodb_Path = Mongodb_Path;
        this.BackupFile_Path = BackupFile_Path;
        this.DatabaseName = DatabaseName;
    }
    public String getMongodb_Path() {
        return Mongodb_Path;
    }
       public String getBackupFile_Path() {
        return BackupFile_Path;
    }
       public String getDatabaseName() {
           return DatabaseName;
       }
       public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener){
    	   String command=Mongodb_Path+"\\mongorestore.exe --db "+ DatabaseName+" --drop "+BackupFile_Path+"\\" +DatabaseName;

    	   
   	    try {
   	        Process runtimeProcess = Runtime.getRuntime().exec(command);
   	      int processComplete = runtimeProcess.waitFor();
   	        
   	        if (processComplete == 0) {
   	        	listener.getLogger().println("Restore : Restore Successfull");
   	          
   	       } else 
   	        {
   	    	listener.getLogger().println("Restore: Restore Failure!");
   	        }
   	    
   	   	    
   	    } catch (IOException ioe) {
   	    	listener.getLogger().println("Exception IO");
   	        ioe.printStackTrace();
   	    } catch (Exception e) {
   	    	listener.getLogger().println("Exception");
   	        e.printStackTrace();
   	    }
      
   }

  
    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
     
         
        public DescriptorImpl() {
            load();
        }
   

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types 
            return true;
        }

      
        public String getDisplayName() {
            return "MongoDB_Restore";
        }
       
    }
}

