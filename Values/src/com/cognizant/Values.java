package com.cognizant;

/*import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Values {
	private static final String FILENAME = "D:\\values.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = " This is new content";

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

}
}
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Values {

	public static void main(String[] args) throws IOException {
		FileWriter pw = null;
		
			pw = new FileWriter("D:\\test.csv", true);
	
		StringBuilder builder = new StringBuilder();
		String ColumnNamesList = "Id,Name";
		// No need give the headers Like: id, Name on builder.append
		    builder.append(ColumnNamesList + "\n");
			builder.append("2" + ",");
			builder.append("hola");
			builder.append('\n');
			pw.write(builder.toString());
			/*pw.close();
			System.out.println("done!");*/
	
		pw.close();
		System.out.println("done!");
	
	}
}