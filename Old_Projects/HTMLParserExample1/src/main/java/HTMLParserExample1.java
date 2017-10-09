import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

import org.jdom.Attribute;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class HTMLParserExample1 {
	

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, TransformerException {

		List<String> l3 = new ArrayList<String>();
		List<String> l4 = new ArrayList<String>();
		List<String> l5 = new ArrayList<String>();
		List<String> l6 = new ArrayList<String>();
		String paramvalues = null;
		Document htmlFile = null;

		File dir = new File("D:\\Files\\");
		File[] listOfFiles = dir.listFiles();
		System.out.println(listOfFiles.length);
		org.jdom.Element company = new org.jdom.Element("job");
		org.jdom.Document doc = new org.jdom.Document(company);
		doc.setRootElement(company);
		for (File file : dir.listFiles()) {
			System.out.println("file is" + file);
			if (file.isFile()) {

				htmlFile = Jsoup.parse(file, "ISO-8859-1");
				Elements title2 = htmlFile.getElementsByClass("signature");
				l3.add(title2.text());

				System.out.println("second part is :-" + l3);
				String[] res1 = null;
				for (int k = 0; k < l3.size(); k++) {
					res1 = l3.get(k).split("[\\{\\s\\(\\'\\)\\,\\s\\=]");

					System.out.println("res value is second part " + res1.length);
					for (int j = 0; j < res1.length; j++) {
						System.out.println("ress is second part " + res1[j]);

					}
				}
				for (String second : res1) {
					System.out.println("Final second array is:---" + second);
					if (!second.isEmpty())
						l4.add(second);

				}
				for (int z = 0; z < l4.size(); z++) {
					if (l4.get(z).matches("String") || l4.get(z).matches("int") || l4.get(z).matches("boolean")|| l4.get(z).matches("Closure")) {
						System.out.println("this is for string");
						String str = l4.get(z + 1).toString();
						l5.add(str); // value of params in task body
					}

				}
				System.out.println("list 5 is :- " + l5);

				System.out.println("list l4-" + l4);

				System.out.println("in count more than one");
				org.jdom.Element Task = new org.jdom.Element("tasktype");
				Task.setAttribute(new Attribute("func", l4.get(0)));
				Task.setAttribute(new Attribute("name", "scm"));
				Task.setAttribute(new Attribute("order", "1"));

				for (int m = 0; m < l5.size(); m++) {
					paramvalues = l5.get(m).toString();
					l6.add("$" +paramvalues);
					System.out.println("parameter values" + paramvalues);
				}
				System.out.println("list6  " + l6);
				String s3 = l6.toString().replace("[","");
				String s4 = s3.replaceAll("]", "");
				String s1 = l5.toString().replace("[","");
				String s2 = s1.replace("]","");

				Task.setAttribute(new Attribute("params", s2.replaceAll("\\s", "")));
				Task.setAttribute(new Attribute("totalNoOfParam", Integer.toString(l5.size())));
				Task.addContent(new org.jdom.Element("task-body").setText(l4.get(0) + "(" + s4 + ")"));

				doc.getRootElement().addContent(Task);

				XMLOutputter xmlOutput = new XMLOutputter();

				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter("D:\\file.xml"));

				l4.removeAll(l4);
				l5.removeAll(l5);
				l6.removeAll(l6);
			}
		}
	}
}
