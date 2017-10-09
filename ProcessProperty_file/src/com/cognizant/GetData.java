package com.cognizant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Properties;

public class GetData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:\\Layer_data.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		Set<Object> keys = props.keySet();
		 System.out.println("size keys are "+keys.size());
		List<Object> listKeys = new ArrayList<Object>();
		listKeys.addAll(keys); // build numbers
		// System.out.println("lisetkeys is "+listKeys);
		List<Object> listKeys1 = new ArrayList<Object>();
		for (Object object : listKeys) {
			String obj = object.toString();
			// Integer intobj = Integer.parseInt(obj);
			listKeys1.add(obj);
		}
		List<String> command = new ArrayList<String>();
		for (int z = 0; z < keys.size()-1; z++) {
			String datavalue = props.getProperty(listKeys.get(z).toString()).trim();

			// System.out.println(datavalue);
			String datavalue1[] = datavalue.split("}");
			// System.out.println(datavalue1.length);
			// System.out.println(datavalue1[1]);
			// for (int i = 0; i < datavalue1.length; i++) {

			String datacommand[] = datavalue1[0].split(",");
			for (int i = 0; i < datacommand.length; i++) {
				System.out.println((datacommand[i].replace("[ ", "")).replace(" ]",""));
				//command.add((datacommand[i].replace("[ ", "")).replace(" ]",""));
			}
			String datasize[] = datavalue1[1].split(", ");
			for (int i = 0; i < datasize.length; i++) {
				System.out.println((datasize[i].replace(",[", "")).replace("]",""));
			}
		}
		//System.out.println(command);

	}
}
