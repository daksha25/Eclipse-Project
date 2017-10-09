package com.mkyong;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Track_List {
	
	public String title;
	public String singer;
	public List<String> cities;
	private Map<String, String> values;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}
	public void setsinger(String singer) {
		this.singer = singer;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Map<String, String> getvalues() {
		return values;
	}
	public void setvalues(Map<String, String> values) {
		this.values = values;
	}
	
	}
	





