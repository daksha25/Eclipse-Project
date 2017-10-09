package Parser;
import java.lang.reflect.*;
import japa.parser.JavaParser;
public class Parser_Handson {

    public void foo() { }

    public int bar() { return 12; }

    public String baz() 
    { return ""; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
	        try {
	            Class c = Parser_Handson.class;
	            Method[] m = c.getDeclaredMethods();
	           
	            for (int i = 0; i < m.length; i++)
	            System.out.println(m[i].toString());
	        } catch (Throwable e) {
	            System.err.println(e);
	        }
	 
	}
	}
}



