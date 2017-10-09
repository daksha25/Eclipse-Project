package com.cognizant;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public class JHson_tolist {

	
	public static void main(String args[])
	{
		
		 String jsonStr ="[{\"category\":\"Mobile\",\"id\":\"1001\",\"name\":\"iPhone 5S\"},"
		 		+ "{\"category\":\"dcdc\",\"id\":\"12\",\"name\":\"ghf\"}]";

		 List jsonlist = new ArrayList();
		JSONArray jsonarray = new JSONArray(jsonStr);
		for (int i = 0; i < jsonarray.length(); i++) {
		    JSONObject jsonobject = jsonarray.getJSONObject(i);
		    jsonlist.add(jsonobject);
		    
		}
		System.out.println(jsonlist);
	}

}
