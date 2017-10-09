package com.mkyong;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.bcel.internal.generic.RETURN;
//@JsonIgnoreProperties(ignoreUnknown = true) 
public class Track_List {
	
	public String jobname;
	public String url;
	public String targetBranch;
	public String build;
	public List<String> func;

	
	public String getjobname() {
		return jobname;
	}

	public void setjobname(String jobname) {
		this.jobname = jobname;
	}

	public String gettargetBranch() {
		return targetBranch;
	}
	public void settargetBranch(String targetBranch) {
		this.targetBranch = targetBranch;
	}
	public String getbuild() {
		return build;
	}
	public void setbuild(String build) {
		this.build = build;
	}
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	public List<String> getfunc() {
		return func;
	}

	public void setfunc(List<String> func) {
		this.func = func;
	}
	
	}
	





