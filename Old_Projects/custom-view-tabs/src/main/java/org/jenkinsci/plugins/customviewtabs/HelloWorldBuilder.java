package org.jenkinsci.plugins.customviewtabs;
import hudson.Launcher;
import hudson.Extension;
import hudson.FilePath;
import hudson.util.FormValidation;
import hudson.model.AbstractProject;
import hudson.model.AbstractBuild;
import hudson.model.Run;
import hudson.Launcher;
import hudson.*;
import hudson.model.TaskListener;
import hudson.util.ArgumentListBuilder;
//import hudson.model.Computer.ListPossibleNames;
import hudson.tasks.Builder;
import hudson.model.BuildListener;
import hudson.model.Node;
import hudson.tasks.BuildStepDescriptor;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.*;

/**
 * Sample {@link Builder}.
 *
 * <p>
 * When the user configures the project and enables this builder,
 * {@link DescriptorImpl#newInstance(StaplerRequest)} is invoked
 * and a new {@link HelloWorldBuilder} is created. The created
 * instance is persisted to the project configuration XML by using
 * XStream, so this allows you to use instance fields (like {@link #imageName})
 * to remember the configuration.
 *
 * <p>
 * When a build is performed, the {@link #perform} method will be invoked.
 *
 * @author Kohsuke Kawaguchi
 */
public class HelloWorldBuilder extends Builder {

    private final String imageName;


    // Fields in config.jelly must match the parameter names in the "DataBoundConstructor"
    @DataBoundConstructor
    public HelloWorldBuilder(String imageName) {
        this.imageName = imageName;
    }
    /**
     * We'll use this from the {@code config.jelly}.
     */
    public String getImageName() {
        return imageName;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
        // This is where you 'build' the project.
        // Since this is a dummy, we just say 'hello world' and call that a build.

        // This also shows how you can consult the global configuration of the builder
                /*
        if (getDescriptor().getUseFrench())
            listener.getLogger().println("Bonjour, "+name+"!");
        else
            listener.getLogger().println("Hello, "+name+"!");
            String PLUGIN = "Get this done with";
            listener.getLogger().println(PLUGIN+" Clair plugin ");
            listener.getLogger().println("Hello another, "+anotherName+"!");
                */
                                listener.getLogger().println("Clair server endpoint, "+getDescriptor().getClairServer()+"!");
                                listener.getLogger().println("Local image tool analyzer path, "+getDescriptor().getAnalyzerPath()+"!");
                                listener.getLogger().println("Name of the image to be scanned for security vulnarabilities, "+getImageName()+"!");
				//Node b = build.getBuiltOn();
				//listener.getLogger().println(b.getNodeName());
				//listener.getLogger().println(b.getNodeProperties());
				//listener.getLogger().println(b.computer.getChannel().call(new ListPossibleNames()));
				/*List<Cause> buildStepCause = new ArrayList();
				buildStepCause.add(new Cause() {
				public String getShortDescription() {
				     return "Build Step started by Hello Builder";
				}
				});
				listener.started(buildStepCause); */
				ArgumentListBuilder args = new ArgumentListBuilder();
 				args.add(getDescriptor().getAnalyzerPath());
				args.add("-endpoint");
				args.add(getDescriptor().getClairServer());
				args.add("-my-address");
				args.add("`hostname -i`");
				args.add(getImageName());
				listener.getLogger().println(args);
				try {
				int t;
				t = launcher.launch().cmds(args).stdout(listener).join();
				listener.getLogger().println(t);
				if (t != 0) {
				//	listener.finished(Result.FAILURE);
					listener.getLogger().println("Execution of " + args + " failed");
					return false;
				}
				} catch (IOException ioe) {
				ioe.printStackTrace(listener.fatalError("Execution of " + args + " failed"));
				} catch (InterruptedException ie) {
				ie.printStackTrace(listener.fatalError("Execution of " + args + " failed"));
				}
	return true;
    }	

    // Overridden for better type safety.
    // If your plugin doesn't really define any property on Descriptor,
    // you don't have to do this.
    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    /**
     * Descriptor for {@link HelloWorldBuilder}. Used as a singleton.
     * The class is marked as public so that it can be accessed from views.
     *
     * <p>
     * See {@code src/main/resources/hudson/plugins/hello_world/HelloWorldBuilder/*.jelly}
     * for the actual HTML fragment for the configuration screen.
     */
    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
        /**
         * To persist global configuration information,
         * simply store it in a field and call save().
         *
         * <p>
         * If you don't want fields to be persisted, use {@code transient}.
         */
        private String clairServer;
        private String analyzerPath;

        /**
         * In order to load the persisted global configuration, you have to
         * call load() in the constructor.
         */
        public DescriptorImpl() {
            load();
        }

        /**
         * Performs on-the-fly validation of the form field 'clairServer'.
         *
         * @param clairServer
         *      This parameter receives the value that the user has typed.
         * @return
         *      Indicates the outcome of the validation. This is sent to the browser.
         *      <p>
         *      Note that returning {@link FormValidation#error(String)} does not
         *      prevent the form from being saved. It just means that a message
         *      will be displayed to the user.
         */
         public FormValidation doCheckClairServer(@QueryParameter String value)
                        throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please enter IP of Clair server");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the IP  too short?");
            return FormValidation.ok();
        }

        /**
         * Performs on-the-fly validation of the form field 'analyzerPath'.
         *
         * @param analyzerPath
         *      This parameter receives the value that the user has typed.
         * @return
         *      Indicates the outcome of the validation. This is sent to the browser.
         *      <p>
         *      Note that returning {@link FormValidation#error(String)} does not
         *      prevent the form from being saved. It just means that a message
         *      will be displayed to the user.
         */

        public FormValidation doCheckAnalyzerPath(@QueryParameter String value)
                        throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please enter the path of analyzer tool");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the path  too short?");
            return FormValidation.ok();
        }

        /**
         * Performs on-the-fly validation of the form field 'imageName'.
         *
         * @param imageName
         *      This parameter receives the value that the user has typed.
         * @return
         *      Indicates the outcome of the validation. This is sent to the browser.
         *      <p>
         *      Note that returning {@link FormValidation#error(String)} does not
         *      prevent the form from being saved. It just means that a message
         *      will be displayed to the user.
         */

        public FormValidation doCheckImageName(@QueryParameter String value)
                        throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please enter the name of the image to be scanned");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the name too short?");
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types
            return true;
        }

        /**
         * This human readable name is used in the configuration screen.
         */
        public String getDisplayName() {
            return "CLAIR Security Scanning";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            // To persist global configuration information,
            // set that to properties and call save().
                System.out.println("144===========" + formData);
                clairServer = formData.getString("clairServer");
                analyzerPath = formData.getString("analyzerPath");
            // ^Can also use req.bindJSON(this, formData);
            //  (easier when there are many fields; need set* methods for this, like setUseFrench)
            save();
            return super.configure(req,formData);
        }

        /**
         * This method returns true if the global configuration says we should speak French.
         *
         * The method name is bit awkward because global.jelly calls this method to determine
         * the initial state of the checkbox by the naming convention.
         */
        public String getClairServer() {
            return clairServer;
        }
        public String getAnalyzerPath() {
            return analyzerPath;
        }
    }
}
