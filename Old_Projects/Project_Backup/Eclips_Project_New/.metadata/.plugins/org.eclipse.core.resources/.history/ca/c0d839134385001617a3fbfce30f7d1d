package com.plugin.postbuild_test;
import java.io.IOException;

import javax.servlet.ServletException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Builder;
import hudson.tasks.Publisher;
import hudson.util.FormValidation;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;

public class PostBuilder extends Publisher {

    private final String name;

    // Fields in config.jelly must match the parameter names in the "DataBoundConstructor"
    @DataBoundConstructor
    public PostBuilder(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener) {
       
        if (getDescriptor().getUseFrench())
            listener.getLogger().println("Bonjour, "+name+"!");
        else
            listener.getLogger().println("Hello, "+name+"!");
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

   
    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
      
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
            return "PostBuild Test";
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


	@Override
	public BuildStepMonitor getRequiredMonitorService() {
		// TODO Auto-generated method stub
		return null;
	}
}

