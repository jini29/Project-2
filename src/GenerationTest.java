import static org.junit.Assert.*;

import org.junit.Test;

public class GenerationTest {

	
		
		CellState CellStates[] = {CellState.ON,CellState.OFF,CellState.ON, CellState.OFF,
				CellState.ON,CellState.OFF,CellState.ON,CellState.OFF};
		Generation g1 = new Generation(CellStates);
		
		Cell Cells[] = {new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON), new Cell(CellState.OFF),
				new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON),new Cell(CellState.OFF)};
		
		Generation g2 = new Generation(Cells);
		
		String states = ".o.o.o.o";
		Generation g3 = new Generation(states);
	
	@Test
	public void sizeTest() {
		int expect = 8;
		int actual = g1.size();
		assertEquals(expect,actual);
		
		actual = g2.size();
		assertEquals(expect,actual);
		
		actual = g3.size();
		assertEquals(expect,actual);
		
	}
	
	@Test
	public void getCellTest() {
		CellState expect = CellState.OFF;
		CellState actual = g1.getCell(1).getState();
		assertEquals(expect,actual);
		
		actual = g2.getCell(1).getState();
		assertEquals(expect,actual);
	
		actual = g3.getCell(1).getState();
		assertEquals(expect,actual);
		
		expect = CellState.ON;
		actual = g1.getCell(2).getState();
		assertEquals(expect,actual);
		
		actual = g2.getCell(2).getState();
		assertEquals(expect,actual);
		
		actual = g3.getCell(2).getState();
		assertEquals(expect,actual);
	}
	
	@Test
	public void toStringTest() {
		String expect = ".o.o.o.o";
		String actual = g1.toString();
		assertEquals(expect,actual);
		
		actual = g2.toString();
		assertEquals(expect,actual);
	
		actual = g3.toString();
		assertEquals(expect,actual);
	}

}
