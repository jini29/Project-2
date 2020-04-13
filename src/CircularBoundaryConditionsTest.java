import static org.junit.Assert.*;

import org.junit.Test;

public class CircularBoundaryConditionsTest {

	@Test
	public void GetNeighbortest() {
		String states = ".o.o.o.o";
		Generation gen = new Generation(states);
		int cellIdx = 3;
		int offset = 1;
		
		CircularBoundaryConditions c = new CircularBoundaryConditions();
		
		Cell actual = c.getNeighbor(cellIdx, offset, gen);
		Cell expect = new Cell(CellState.ON);
		assertEquals(actual, expect);
		
		cellIdx =3;
		offset = -2;
		actual = c.getNeighbor(cellIdx, offset, gen);
		expect = new Cell(CellState.OFF);
		assertEquals(actual, expect);
		
		cellIdx =0;
		offset = -2;
		actual = c.getNeighbor(cellIdx, offset, gen);
		expect = new Cell(CellState.ON);
		assertEquals(actual, expect);
		
		cellIdx =gen.size();
		offset = 2;
		actual = c.getNeighbor(cellIdx, offset, gen);
		expect = new Cell(CellState.OFF);
		assertEquals(actual, expect);
		
	}

}
