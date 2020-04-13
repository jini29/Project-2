import static org.junit.Assert.*;

import org.junit.Test;

public class CellStateTest {

	@Test
	public void getStateTest() {
		CellState actual = CellState.getState('O');
		CellState expect = CellState.ON;
		assertEquals(expect,actual);
		
		actual = CellState.getState('.');
		expect = CellState.OFF;
		assertEquals(expect,actual);
	
	}
	
	@Test
	public void toStringTest() {
		String actual = CellState.ON.toString();
		String expect = "O";
		assertEquals(expect,actual);
		
		actual = CellState.OFF.toString();
		expect = ".";
		assertEquals(expect,actual);
	}

}
