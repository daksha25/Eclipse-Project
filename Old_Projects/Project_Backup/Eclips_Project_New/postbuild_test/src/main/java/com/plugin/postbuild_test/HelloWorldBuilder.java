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

public class HelloWorldBuilder extends Builder implements SimpleBuildStep {

	private final String mongodb_path;
    private final String backup_path;
    private final String dbname;
  
    @DataBoundConstructor
    public HelloWorldBuilder(String mongodb_path,String backup_path,String dbname) {
        this.mongodb_path = mongodb_path;
        this.backup_path = backup_path;
        this.dbname = dbname;
    }
    public String getmongodb_path() {
        return mongodb_path;
    }
       public String getbackup_path() {
        return backup_path;
    }
       public String getdbname() {
           return dbname;
       }
       public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener){
    	   String command=mongodb_path+"\\mongorestore.exe --db "+ dbname+" --drop "+backup_path+"\\" +dbname;


    	   
   	    try {
   	        Process runtimeProcess = Runtime.getRuntime().exec(command);
   	      int processComplete = runtimeProcess.waitFor();
   	        
   	        if (processComplete == 0) {
   	        	listener.getLogger().println("Restore : Restore Successfull");
   	           // status = true;
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
       if (getDescriptor().getUseFrench())
           listener.getLogger().println("Error");
       else
           listener.getLogger().println("Successfully Restore");
   }

  
    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
     
        private boolean useFrench;

     
        public DescriptorImpl() {
            load();
        }

    

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types 
            return true;
        }

      
        public String getDisplayName() {
            return "MongoDB_Restore Plugin";
        }
        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
          
            useFrench = formData.getBoolean("useFrench");
        
            save();
            return super.configure(req,formData);
        }

      
        public boolean getUseFrench() {
            return useFrench;
        }
    }
}

