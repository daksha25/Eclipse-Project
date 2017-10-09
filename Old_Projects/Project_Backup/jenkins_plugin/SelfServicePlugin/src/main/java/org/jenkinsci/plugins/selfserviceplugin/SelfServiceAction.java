package org.jenkinsci.plugins.selfserviceplugin;

import java.util.ArrayList;
import java.util.List;
import hudson.Extension;
import hudson.model.UnprotectedRootAction;

@Extension
public class SelfServiceAction implements UnprotectedRootAction {

	private List<List<String>> jobMap = new ArrayList<List<String>>();
	private String heading = "";
	
	public List<List<String>> getJobMap() 
	{
		return this.jobMap;
	}
	
	public void setJobMap(List<List<String>> jobMap) 
	{
		this.jobMap = jobMap;
	}
	
	
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	@Override
	public String getDisplayName() {
		return "Build Counter";
	}

	@Override
	public String getIconFileName() {
		return "/plugin/selfserviceplugin/images/test.png";
	}

	@Override
	public String getUrlName() {
		return "self-service";
	}

}