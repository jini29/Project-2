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
		Cell c1 = new Cell(CellState.ON);
		CellState expect = CellState.ON;
		CellState actual = c1.getState();
		assertEquals(expect, actual);
		
		Cell c2 = new Cell(CellState.OFF);
		expect = CellState.OFF;
		actual = c2.getState();
		assertEquals(expect, actual);
		
	}
	
	@Test 
	public void toStringTest() {
		Cell c1 = new Cell(CellState.ON);
		String expect = ".";
		String actual = c1.toString();
		assertEquals(expect, actual);
		
		Cell c2 = new Cell(CellState.OFF);
		expect = "o";
		actual = c2.toString();
		assertEquals(expect, actual);
	}

}
