package com.cognizant.Jelly_Test;
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
import java.io.IOException;


public class HelloWorldBuilder extends Builder implements SimpleBuildStep {


	private boolean Severity = false;
	private boolean High = false;
	private boolean Medium = false;
	private boolean Low = false;
	 private final int high;
	 private final int medium;
	 private final int low;
	 
    // Fields in config.jelly must match the parameter names in the "DataBoundConstructor"
    @DataBoundConstructor
    public HelloWorldBuilder(Boolean Severity, Boolean High,Boolean Medium, Boolean Low,int high,int medium,int low ) {
    	 
    	this.Severity = (Severity != null) && Severity;
      //  this.name = name;
        this.High=(High != null) && High;
        this.Medium=(Medium != null) && Medium;
        this.Low=(Low != null) && Low;
        this.high=high;
        this.medium=medium;
        this.low=low;
    }

   
    public int gethigh() {
        return high;
    }
    public int getmedium() {
        return medium;
    }
    public int getlow() {
        return low;
    }
    public boolean isSeverity() {
		return Severity;
	}
    public boolean isHigh() {
		return High;
	}
    public boolean isMedium() {
		return Medium;
	}
    public boolean isLow() {
		return Low;
	}

    @Override
    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener) {
       
            listener.getLogger().println("Pklugin executed Successfully");
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

        /**
         * This human readable name is used in the configuration screen.
         */
        public String getDisplayName() {
            return "Say hello world";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            // To persist global configuration information,
            // set that to properties and call save().
            useFrench = formData.getBoolean("useFrench");
            // ^Can also use req.bindJSON(this, formData);
            //  (easier when there are many fields; need set* methods for this, like setUseFrench)
            save();
            return super.configure(req,formData);
        }

      
        public boolean getUseFrench() {
            return useFrench;
        }
    }
}

