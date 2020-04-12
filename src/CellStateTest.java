import static org.junit.Assert.*;

import org.junit.Test;

public class CellStateTest {

	@Test
	public void getStatetest() {
		CellState actual = CellState.getState('.');
		CellState expect = CellState.ON;
		assertEquals(expect,actual);
		
		actual = CellState.getState('o');
		expect = CellState.OFF;
		assertEquals(expect,actual);
	
	}

}
