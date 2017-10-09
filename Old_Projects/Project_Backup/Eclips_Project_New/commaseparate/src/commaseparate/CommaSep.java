package commaseparate;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommaSep {

	public static void main(String[] args) {

List <Path> ToFolders=new ArrayList<Path>();

String str=args[0];
String[] str1=str.split(",");

for(int i=0;i<str1.length;i++)
{
	Path d = Paths.get(str1[i]);
	ToFolders.add(d);
	
}
	}
}

