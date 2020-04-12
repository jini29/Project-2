import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author jini
 *
 */
public class CellTest {

	@Test
	public void GetstateTest() {
		Cell c1 = new Cell(true);
		boolean expect = true;
		boolean actual = c1.getState();
		assertEquals(expect, actual);
		
		Cell c2 = new Cell(false);
		expect = false;
		actual = c2.getState();
		assertEquals(expect, actual);
		
	}
	
	@Test 
	public void toStringTest() {
		Cell c1 = new Cell(true);
		String expect = "true";
		String actual = c1.toString();
		assertEquals(expect, actual);
		
		Cell c2 = new Cell(false);
		expect = "false";
		actual = c2.toString();
		assertEquals(expect, actual);
	}

}
