import static org.junit.Assert.*;

import org.junit.Test;

public class CellStateTest {

	@Test
	public void getStateTest() {
		CellState actual = CellState.getState('.');
		CellState expect = CellState.ON;
		assertEquals(expect,actual);
		
		actual = CellState.getState('o');
		expect = CellState.OFF;
		assertEquals(expect,actual);
	
	}
	
	@Test
	public void toStringTest() {
		String actual = CellState.ON.toString();
		String expect = ".";
		assertEquals(expect,actual);
		
		actual = CellState.OFF.toString();
		expect = "o";
		assertEquals(expect,actual);
	}

}
