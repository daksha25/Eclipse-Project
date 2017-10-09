package com.cognizant;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

import org.jdom.Text;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class Write_xml {

  public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException, TransformerException {

  

	  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
	  domFactory.setIgnoringComments(true);
	  DocumentBuilder builder = domFactory.newDocumentBuilder(); 
	  Document doc = builder.parse(new File("D:\\file.xml")); 

	  NodeList nodes = doc.getElementsByTagName("hudson.plugins.git.UserRemoteConfig");

	  org.w3c.dom.Text a = doc.createTextNode("value"); 
	  Element p = doc.createElement("newNode"); 
	  p.appendChild(a); 

	  nodes.item(0).getParentNode().insertBefore(p, nodes.item(0));
	  
	  //to print result on screen
	  Transformer transformer = TransformerFactory.newInstance().newTransformer();
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	  StreamResult result = new StreamResult(new StringWriter());
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);

	  String xmlOutput = result.getWriter().toString();
	  System.out.println(xmlOutput);
    }
}
    