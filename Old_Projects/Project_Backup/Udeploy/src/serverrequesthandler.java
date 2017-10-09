package com.cognizant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.codec.binary.Base64; 
/**
* Send a POST request to SonarQube
*
* @author Cognizant
*
*/

public class serverrequesthandler {
       
       public static void main(String[] args) throws Exception {
              
              serverrequesthandler http = new serverrequesthandler();
              
              System.out.println("Sending Http POST request");
              http.sendPost();
       }
       
       
       // HTTP POST request
              private void sendPost() throws Exception {

                     String url = "http://10.242.181.79:9002 /cli/component/create";
                     
                     String name = "admin";
                     String password = "admin";

                     String authString = name + ":" + password;
                     System.out.println("auth string: " + authString);
                     byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
                     String authStringEnc = new String(authEncBytes);
                     System.out.println("Base64 encoded auth string: " + authStringEnc);
                     
                     URL obj = new URL(url);
              
                     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                     //add request header
                     con.setRequestMethod("POST");
                     con.setRequestProperty("Authorization", "Basic " + authStringEnc);
                     con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                     
                     String urlParameters = "id=35";
                     
                     // Send post request
                     con.setDoOutput(true);
                     DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                     wr.writeBytes(urlParameters);
                     wr.flush();
                     wr.close();

                     int responseCode = con.getResponseCode();
                     System.out.println("\nSending 'POST' request to URL : " + url);
                     System.out.println("Post parameters : " + urlParameters);
                     System.out.println("Response Code : " + responseCode);

                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(con.getInputStream()));
                     String inputLine;
                     StringBuffer response = new StringBuffer();

                     while ((inputLine = in.readLine()) != null) {
                           response.append(inputLine);
                     }
                     in.close();
                     
                     //print result
                     System.out.println(response.toString());

              }

       }

