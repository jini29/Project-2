import static org.junit.Assert.*;

import org.junit.Test;

public class FixedBoundaryConditionsTest {

	@Test
	public void GetLefttest() {
		FixedBoundaryConditions f1= new FixedBoundaryConditions(CellState.ON, CellState.OFF); 
		CellState actual = f1.getLeftState();
		CellState expect = CellState.ON;
		assertEquals(expect,actual);
		
		FixedBoundaryConditions f2= new FixedBoundaryConditions(CellState.OFF, CellState.ON); 
		actual = f2.getLeftState();
		expect = CellState.OFF;
		assertEquals(expect,actual);
	}
	
	@Test
	public void GetRighttest() {
		FixedBoundaryConditions f1= new FixedBoundaryConditions(CellState.ON, CellState.OFF); 
		CellState actual = f1.getRightState();
		CellState expect = CellState.OFF;
		assertEquals(expect,actual);
		
		FixedBoundaryConditions f2= new FixedBoundaryConditions(CellState.OFF, CellState.ON); 
		actual = f2.getRightState();
		expect = CellState.ON;
		assertEquals(expect,actual);
	}
	
	@Test
	public void GetNeighbortest() {
		FixedBoundaryConditions f1= new FixedBoundaryConditions(CellState.ON, CellState.OFF); 
		
		String states = ".o.o.o.o";
		Generation gen = new Generation(states);
		int cellIdx = 3;
		int offset = 2;
		CellState actual = f1.getNeighbor(cellIdx, offset, gen).getState();
		CellState expect = CellState.OFF;
		assertEquals(expect,actual);
		
		cellIdx = 0;
		offset = -1;
		actual = f1.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.ON;
		assertEquals(expect,actual);
		
		cellIdx = 0;
		offset = Integer.MIN_VALUE;
		actual = f1.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.ON;
		assertEquals(expect,actual);
		
		cellIdx = gen.size()-1;
		offset = 1;
		actual = f1.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.OFF;
		assertEquals(expect,actual);
		
		
		cellIdx = 0;
		offset = Integer.MAX_VALUE;
		actual = f1.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.OFF;
		assertEquals(expect,actual);
		
		
		FixedBoundaryConditions f2= new FixedBoundaryConditions(CellState.OFF, CellState.ON); 
		actual = f2.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.ON;
		assertEquals(expect,actual);
		
		
		cellIdx = 0;
		offset = -1;
		actual = f2.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.OFF;
		assertEquals(expect,actual);
		
		cellIdx = 0;
		offset = Integer.MIN_VALUE;
		actual = f2.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.OFF;
		assertEquals(expect,actual);
		
		cellIdx = gen.size()-1;
		offset = 1;
		actual = f2.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.ON;
		assertEquals(expect,actual);
		
		
		cellIdx = 0;
		offset = Integer.MAX_VALUE;
		actual = f2.getNeighbor(cellIdx, offset, gen).getState();
		expect = CellState.ON;
		assertEquals(expect,actual);
		
	}


}
