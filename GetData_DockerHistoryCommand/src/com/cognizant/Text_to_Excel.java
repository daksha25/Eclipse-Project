
package com.cognizant;

import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;

public class Text_to_Excel {

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileInputStream fstream = new FileInputStream("D:\\Documents\\Ansible and docker\\docker\\test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		int index;
		String out = "";
		int lastindex;
		List<String> part1 = new ArrayList<String>();
		

		while ((strLine = br.readLine()) != null) {
			// System.out.println(strLine);
			if (strLine.contains("nop")) {
				StringBuilder str = new StringBuilder();
				str.append(strLine);
				// System.out.println(str);
				index = str.indexOf(")");
				out = str.substring(index + 2);
				// System.out.println(out);
				String[] part = out.split(" ");

				for (int i = 0; i < part.length; i++) {
					part1.add(part[i]);

				}
				List<String> output1 = new ArrayList<String>();
				for (int i = 0; i < part1.size(); i++) {
					if (!part1.get(i).isEmpty()) {
						output1.add(part1.get(i));
					}
				}

				// System.out.println(outputdata);
				StringBuilder str1 = new StringBuilder();
				for (int i = 0; i < output1.size() - 2; i++) {
					str1.append(output1.get(i));
				}
				System.out.println(str1);

				lastindex = part1.size();
				StringBuilder str2 = new StringBuilder();
				str2.append(part1.get(lastindex - 2));
				str2.append(part1.get(lastindex - 1));
				System.out.println(str2);

				part1.clear();

			}

		}

	}
}
