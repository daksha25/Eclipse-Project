import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//File file=new File("D:\\Softwares\\Jenkins\\Severity_Count.properties");
Properties props = new Properties();
FileInputStream fis = new FileInputStream("D:\\Softwares\\Jenkins\\Severity_Count.properties");
props.load(fis);
List <Integer> listkey=new ArrayList<>();
Enumeration e=props.keys();
while (e.hasMoreElements()) {
	String key = (String) e.nextElement();
	String value = props.getProperty(key);
	System.out.println(key);
	listkey.add(Integer.parseInt(key));
	System.out.println(value);
}
System.out.println("list of keys in integer"+listkey);
Collections.sort(listkey);
System.out.println("list of keys in integer after sorting"+listkey);
System.out.println(listkey.size());
	}

}
