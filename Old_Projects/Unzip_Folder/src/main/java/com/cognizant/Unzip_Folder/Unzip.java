package com.cognizant.Unzip_Folder;
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

import javax.servlet.ServletException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Unzip extends Builder implements SimpleBuildStep {

    
    private final String INPUT_ZIP_FILE;
    private final String OUTPUT_FOLDER;
   
    @DataBoundConstructor
    public Unzip(String INPUT_ZIP_FILE, String OUTPUT_FOLDER) {
        this.INPUT_ZIP_FILE=INPUT_ZIP_FILE;
        this.OUTPUT_FOLDER=OUTPUT_FOLDER;
    }

    
    public String getOUTPUT_FOLDER() {
        return OUTPUT_FOLDER;
    }
    public String getINPUT_ZIP_FILE() {
        return INPUT_ZIP_FILE;
    }

    @Override
    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener) {
        // This is where you 'build' the project.
        // Since this is a dummy, we just say 'hello world' and call that a build.

        // This also shows how you can consult the global configuration of the builder
    	List<String> fileList;
    	 
    		     byte[] buffer = new byte[1024];

    		     try{

    		    	//create output directory is not exists
    		    	File folder = new File(OUTPUT_FOLDER);
    		    	if(!folder.exists()){
    		    		folder.mkdir();
    		    	}

    		    	//get the zip file content
    		    	ZipInputStream zis =
    		    		new ZipInputStream(new FileInputStream(INPUT_ZIP_FILE));
    		    	//get the zipped file list entry
    		    	ZipEntry ze = zis.getNextEntry();

    		    	while(ze!=null){

    		    	   String fileName = ze.getName();
    		           File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);

    		           System.out.println("file unzip : "+ newFile.getAbsoluteFile());

    		            //create all non exists folders
    		            //else you will hit FileNotFoundException for compressed folder
    		            new File(newFile.getParent()).mkdirs();

    		            FileOutputStream fos = new FileOutputStream(newFile);

    		            int len;
    		            while ((len = zis.read(buffer)) > 0) {
    		       		fos.write(buffer, 0, len);
    		            }

    		            fos.close();
    		            ze = zis.getNextEntry();
    		    	}

    		        zis.closeEntry();
    		    	zis.close();

    		    	System.out.println("Done");

    		    }catch(IOException ex){
    		       ex.printStackTrace();
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

        public FormValidation doOUTPUT_FOLDER(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please set a path");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the name too short?");
            return FormValidation.ok();
        }
        public FormValidation doINPUT_ZIP_FILE(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please set a path");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the name too short?");
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types 
            return true;
        }

      
        public String getDisplayName() {
            return "Unzip Folder";
        }

      

        
        }
    }


