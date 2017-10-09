package com.cognizant;

import groovyx.net.http.HTTPBuilder 
import org.apache.http.HttpRequestInterceptor 
import org.apache.http.HttpRequest 
import org.apache.http.protocol.HttpContext 
import java.security.KeyStore 
import org.apache.http.conn.ssl.SSLSocketFactory 
import org.apache.http.conn.scheme.Scheme 
import org.apache.http.conn.scheme.PlainSocketFactory 
import org.apache.http.client.HttpResponseException 
import groovyx.net.http.Method 
import groovyx.net.http.ContentType 


public class Rest_UDeploy {
	static void main(String... args)
	{
	 def http
	 String server='http://10.242.181.79:9002/'
	 String user='admin'
	 String password='admin'
	 
	 
	 final def String CREATE_COMPONENT = 'http://10.242.181.79:9002 /cli/component/create'
	 println "Success!!"
	
	}
	
	/*private def getBuilder = {
		         if (!http) {
		             http = new HTTPBuilder(serverUrl)
		 	    http.auth.basic user, password
		
		 
		             http.client.addRequestInterceptor(new HttpRequestInterceptor() {
		                void process(HttpRequest httpRequest, HttpContext httpContext) {
		 //                    httpRequest.addHeader('Authorization', 'Basic ' + "$user:$password".toString().bytes.encodeBase64().toString())
		                     httpRequest.addHeader('User-Agent', 'HTTPClient')
		                 }
		             })
		
		 
		
		 
		             KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		             trustStore.load(null, null);
		
		 
		             SSLSocketFactory sf = new CustomSSLSocketFactory(trustStore);
		             sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		
		 
		             http.client.connectionManager.schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
		             http.client.connectionManager.schemeRegistry.register(new Scheme("https", sf, 443));
		         }
		
		 
		         return http
		     }
	*/
	public def createComponent = { input ->
		         if (input != null) {
		             getBuilder().request(Method.PUT) {
		                 requestContentType = ContentType.JSON
		                 uri.path = CREATE_COMPONENT
		                 body = input
		                 response.failure = { resp ->
		                     if (resp.status == 500 ) {
		                         throw new Exception("Component already exists!")
		                     }
		                     else if (resp.status == 400) {
		                         throw new Exception("Cannot create component!")
		                     }
		                     else {
		                         throw new Exception(resp.statusLine.toString())
		                     }
		                 }
		
		
		                 response.success = { resp, json ->
		                     return json
		                 }
		             }
		         }
		     }
		
		

}
