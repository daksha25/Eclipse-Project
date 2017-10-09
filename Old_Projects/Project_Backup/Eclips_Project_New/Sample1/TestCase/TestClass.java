


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestClass extends TestCase{


	    /**
	     * Rigourous Test :-)
	     */
	    public void testApp()  {
	    	
	    	FirstAntDemo fa = new FirstAntDemo();
			assertEquals(40, fa.ADD());
	        //assertTrue( true );
	    }
 
}
