import junit.framework.TestCase;

public class FactTest extends TestCase {
	public void test() {
		//Prg2 test = new Prg2();
		int output = FactNew.fact(5);
		assertEquals(120, output);
		
		
	}
}
