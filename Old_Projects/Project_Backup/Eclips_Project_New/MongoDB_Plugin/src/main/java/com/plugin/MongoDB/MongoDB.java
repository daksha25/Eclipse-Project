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

import org.apache.log4j.BasicConfigurator;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MongoDB extends Builder implements SimpleBuildStep {

    private final String mongodb_path;
    private final String backup_path;
  
    @DataBoundConstructor
    public MongoDB(String mongodb_path,String backup_path) {
        this.mongodb_path = mongodb_path;
        this.backup_path = backup_path;
    }
    public String getmongodb_path() {
        return mongodb_path;
    }
       public String getbackup_path() {
        return backup_path;
    }

    @Override
    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		 File file = new File(backup_path+"\\Backup"+date1);
	        if (!file.exists()) {
	            if (file.mkdir()) {
	            	listener.getLogger().println("Directory is created!");
	            } else {
	            	listener.getLogger().println("Failed to create directory!");
	            }
	        }
		
	    boolean status = false;
	    BasicConfigurator.configure();
	   
	      String command=mongodb_path+"\\mongodump.exe --out "+file;
	   
	    try {
	        Process runtimeProcess = Runtime.getRuntime().exec(command);
	      int processComplete = runtimeProcess.waitFor();
	        
	        if (processComplete == 0) {
	        	listener.getLogger().println("backup: Backup Successfull");
	            status = true;
	       } else 
	        {
	    	   listener.getLogger().println("backup: Backup Failure!");
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
            listener.getLogger().println("Successfully created backup");
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

      
        public FormValidation doCheckName(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please set a name");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the name too short?");
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types 
            return true;
        }

       
        public String getDisplayName() {
            return "MongoDB Plugin";
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

