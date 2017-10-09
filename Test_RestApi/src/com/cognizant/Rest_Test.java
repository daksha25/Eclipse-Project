package com.cognizant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.json.simple.parser.ParseException;

public class Rest_Test {
	public static void main(String[] args) throws ParseException, IOException {
        // TODO Auto-generated method stub
        String name = "jira";
        String password = "jira123";
        String jobName=args[1];

        String authString = name + ":" + password;
        byte[] encodedBytes = Base64.encodeBase64(authString.getBytes());
        String encoded = new String(encodedBytes);

        URL url = new URL("http://34.211.100.27:8080/rest/api/2/issue/" + args[0]);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + encoded);
        if (conn.getResponseCode() != 200) {
               throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                     (conn.getInputStream())));

        String output;
        StringBuffer response = new StringBuffer();

        while ((output = br.readLine()) != null) {
               response.append(output);
        }

        conn.disconnect();
        String data = response.toString();
        System.out.println(data);

        JSONParser parser = new JSONParser();
        String id = null;
        Object JSONObject = parser.parse(response.toString());
        JSONArray jsonarray = new JSONArray();
        jsonarray.add(JSONObject);
       
        Iterator itr = jsonarray.iterator();
        while (itr.hasNext()) {
               org.json.simple.JSONObject object = (org.json.simple.JSONObject) itr
                            .next();
               if (object.get("id") != null) {
                     id = object.get("id").toString();

               }
               System.out.println("id is " + id);
        }
        GetParameters(encoded, id,jobName);

 }

 private static void GetParameters(String encoded, String id,String jobName)
               throws ParseException, IOException {
        // Trigger api to get name by passing issue id
        // TODO Auto-generated method stub
        URL url = new URL(
                     "http://34.211.100.27:8080/rest/idalko-igrid/1.0/grid/10101/issue/"
                                   + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + encoded);
        if (conn.getResponseCode() != 200) {
               throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                     (conn.getInputStream())));

        String output;
        StringBuffer response = new StringBuffer();

        while ((output = br.readLine()) != null) {
               response.append(output);
        }

        conn.disconnect();
        
        JSONParser parser = new JSONParser();
        String values = null;
        Object JSONObject = parser.parse(response.toString());
        JSONArray jsonarray = new JSONArray();
        jsonarray.add(JSONObject);
       Iterator itr = jsonarray.iterator();
        while (itr.hasNext()) {
               org.json.simple.JSONObject object = (org.json.simple.JSONObject) itr
                            .next();
               if (object.get("values") != null) {
                     values = object.get("values").toString();

               }
               
        }

        String componenttype = null;
        String projecttype = null;
        String version = null;

        JSONParser parser1 = new JSONParser();
        JSONArray jsonarray1 = (JSONArray) parser1.parse(values.toString());
      
        Iterator itr1 = jsonarray1.iterator();
        while (itr1.hasNext()) {
               org.json.simple.JSONObject object = (org.json.simple.JSONObject) itr1
                            .next();
               if (object.get("componenttype") != null) {
                     componenttype = object.get("componenttype").toString();

               }

               if (object.get("projecttype") != null) {
                     projecttype = object.get("projecttype").toString();

               }
               if (object.get("version") != null) {
                     version = object.get("version").toString();

               }
       
        }

        // for name in component
       
        String name = null;
       
        JSONParser parser2 = new JSONParser();
        Object JSONObject2 = parser2.parse(componenttype);
        JSONArray jsonarray2 = new JSONArray();
        jsonarray2.add(JSONObject2);

        Iterator itr2 = jsonarray2.iterator();
        while (itr2.hasNext()) {
               JSONObject object = (JSONObject) itr2.next();

               if (object.get("name") != null) {
                     name = object.get("name").toString();

               }
               System.out.println("name in component type is : " + name);
        }

        // project type
        JSONParser parser3 = new JSONParser();
        String name1 = null;
        Object JSONObject3 = parser3.parse(projecttype);
        JSONArray jsonarray3 = new JSONArray();

        jsonarray3.add(JSONObject3);

        Iterator itr3 = jsonarray2.iterator();

        while (itr3.hasNext()) {
               JSONObject object = (JSONObject) itr3.next();

               if (object.get("name") != null) {
                     name1 = object.get("name").toString();

               }
               System.out.println("name in project type is : " + name1);
        }
        // version
        JSONParser parser4 = new JSONParser();
        String name2 = null;
        Object JSONObject4 = parser4.parse(version);
        JSONArray jsonarray4 = new JSONArray();

        jsonarray4.add(JSONObject4);

        Iterator itr4 = jsonarray4.iterator();

        while (itr4.hasNext()) {
               JSONObject object = (JSONObject) itr4.next();

               if (object.get("name") != null) {
                     name2 = object.get("name").toString();
               }
               System.out.println("name in version is : " + name2);
        }
        TriggerJenkins_job(name,name1,name2,jobName);
 }

 private static void TriggerJenkins_job(String name, String name1,
               String name2, String jobName) throws IOException {
       
        String uname = "jenkins";
        String password = "jenkins123";
        String authString = uname + ":" + password;
        byte[] encodedBytes = Base64.encodeBase64(authString.getBytes());
        String encoded = new String(encodedBytes);
 //     URL obj = new URL("http://localhost:8085/job/BuildWith_Param_Test/buildWithParameters?componentname="+name+"?projectname="+name1+"?version="+name2);
        URL obj = new URL("http://34.211.100.27:9090/jenkins/job/"+jobName+"/buildWithParameters?componentname="+name+"?projectname="+name1+"?version="+name2);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        
        con.setRequestProperty("Authorization", "Basic " + encoded);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        OutputStreamWriter out = new OutputStreamWriter(
                     con.getOutputStream());
                 System.out.println(con.getResponseCode());
                 //System.out.println(con.getResponseMessage());
                 out.close();
        
        
        System.out.println("\nSending 'POST' request to URL");
 }
}
 


