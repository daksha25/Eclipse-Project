package com.cognizant;

import java.io.FileWriter;
import java.io.IOException;

/*import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
public class Write_Json {
public static void main(String args[]) throws IOException
{
	String ans=json();
	System.out.println(ans);
	FileWriter file = new FileWriter("D:\\test.json");

        file.write(ans.toString());
        file.flush();
	}


public static String json() {
    JSONObject result = new JSONObject();
    JSONObject input_1 = new JSONObject();
    JSONObject input_2 = new JSONObject();
    JSONObject def = new JSONObject();
   // JSONArray fgh = new JSONArray();
   // JSONArray ghi = new JSONArray();
    JSONObject sampleInnerElement = new JSONObject();
    try {
        sampleInnerElement.put("abc","abc");
       // sampleInnerElement.put("def","abc");
      //  sampleInnerElement.put("ghi","abc");
        //populating the fgh Array
      //  fgh.put(sampleInnerElement);
       // fgh.put(sampleInnerElement);
      //  fgh.put(sampleInnerElement);
        //populating the Ghi Array
      //  ghi.put(sampleInnerElement);
       // ghi.put(sampleInnerElement);
       // ghi.put(sampleInnerElement);

      //  def.put("fgh",fgh);
      //  def.put("ghi",ghi);
        input_2.put("def",def);
        input_1.put("abc",input_2);
        //result.put("status","0");
        result.put("Input_1",input_1);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return result.toString();
}
}*/

import org.json.simple.JSONObject;

public class Write_Json{

 public static void main(String[] args) throws IOException {
 String ans=json();
 FileWriter file = new FileWriter("D:\\test.json");

 file.write(ans.toString());
 file.flush();
 }
 
 public static String json()
 {
  JSONObject obj = new JSONObject();
  obj.put("Environment", "Dev");
  obj.put("Component", "Component1");
  obj.put("id", new Integer(32));
  obj.put("Version", "StudentEnrollmentWithSpring-01.war");
  obj.put("job", "TAB_COMPONENT1_DEV");
  
  JSONObject obj1 = new JSONObject();
  obj1.put("Environment", "Dev");
  obj1.put("Component", "Component1");
  obj1.put("id", new Integer(32));
  obj1.put("Version", "StudentEnrollmentWithSpring-01.war");
  obj1.put("job", "TAB_COMPONENT1_DEV");
  
  JSONObject obj3 = new JSONObject();
  obj3.put("Input_1", obj);
  obj3.put("Input_2",obj1);
 
  System.out.println(obj3.toJSONString());
  return obj3.toJSONString();
 }

}