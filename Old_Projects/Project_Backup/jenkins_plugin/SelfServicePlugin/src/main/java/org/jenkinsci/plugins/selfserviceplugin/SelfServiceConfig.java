package org.jenkinsci.plugins.selfserviceplugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Queue.BuildableItem;
import hudson.triggers.Trigger;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import jenkins.model.GlobalConfiguration;
import jenkins.model.Jenkins;

@Extension
public class SelfServiceConfig extends GlobalConfiguration {
	
	private String jobmapping = "";
	private String heading = "";
	
	public SelfServiceConfig() {
		load();
	}
	
	public static SelfServiceConfig getSelfServiceConfig() {
		return (SelfServiceConfig) Jenkins.getInstance().getDescriptor(SelfServiceConfig.class);
	}
	
	public String getJobmapping() {
		return this.jobmapping;
	}
	
	public void setJobmapping(String jobmapping) {
		this.jobmapping = jobmapping;
	}
	
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	@Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        jobmapping = json.getString("jobmapping");
        heading = json.getString("heading");
        
        List<List<String>> jobMap = new ArrayList<List<String>>();
        
        for (String j : jobmapping.split("\\n")) {
        	String []jarray = j.split("\\|");
        	jobMap.add(Arrays.asList(jarray));
        }
        
        for (Action a : Jenkins.getInstance().getActions()) {
        	if (a.getClass().equals(SelfServiceAction.class)) {
        		SelfServiceAction tt = (SelfServiceAction) a;
        		tt.setJobMap(jobMap);
        		tt.setHeading(heading);
        	}
        }
        
		
		save();
		return super.configure(req, json);
    }
}
