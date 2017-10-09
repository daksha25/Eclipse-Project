package com.cognizant.Sample;
import hudson.model.RootAction;
import hudson.Extension;
@Extension
public class OnlineRootAction implements RootAction{

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "image.png";
	}

	@Override
	public String getIconFileName() {
		// TODO Auto-generated method stub
		return "Online";
	}

	@Override
	public String getUrlName() {
		// TODO Auto-generated method stub
		return "https:\\google.com";
	}

}
