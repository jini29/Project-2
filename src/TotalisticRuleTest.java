import static org.junit.Assert.*;

import org.junit.Test;

public class TotalisticRuleTest {

	
	@Test
	public void getNeighborhoodtest() throws InvalidRuleNumException {
		TotalisticRule er = new TotalisticRule(22);
		String states = ".O.O.O.O";
		Generation g1 = new Generation(states);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell[] actual= er.getNeighborhood(7, g1, bc);
		
		Cell[] except = new Cell[] {new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON)};
		
		assertEquals(except[0].toString(),actual[0].toString());
		assertEquals(except[1].toString(),actual[1].toString());
		assertEquals(except[2].toString(),actual[2].toString());
		assertEquals(except[3].toString(),actual[3].toString());
		assertEquals(except[4].toString(),actual[4].toString());
		
		
		actual= er.getNeighborhood(0, g1, bc);
		
		except = new Cell[] {new Cell(CellState.OFF),new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON),new Cell(CellState.OFF)};
		assertEquals(except[0].toString(),actual[0].toString());
		assertEquals(except[1].toString(),actual[1].toString());
		assertEquals(except[2].toString(),actual[2].toString());
		assertEquals(except[3].toString(),actual[3].toString());
		assertEquals(except[4].toString(),actual[4].toString());
		
		actual= er.getNeighborhood(3, g1, bc);
		
		except = new Cell[] {new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON),new Cell(CellState.OFF),new Cell(CellState.ON)};
		assertEquals(except[0].toString(),actual[0].toString());
		assertEquals(except[1].toString(),actual[1].toString());
		assertEquals(except[2].toString(),actual[2].toString());
		assertEquals(except[3].toString(),actual[3].toString());
		assertEquals(except[4].toString(),actual[4].toString());
	}
	
	@Test 
	public void EvolveCellTest() throws InvalidRuleNumException {
		TotalisticRule er = new TotalisticRule(22);
		String states = ".O.O.O.O";
		Generation g1 = new Generation(states);
		BoundaryConditions bc = new CircularBoundaryConditions();
		EvolvedCell actual= er.evolve(er.getNeighborhood(7, g1, bc));
		EvolvedCell except = new EvolvedCell(CellState.OFF,7);
		assertEquals(except.toString(),actual.toString());
		
		actual= er.evolve(er.getNeighborhood(0, g1, bc));
		except = new EvolvedCell(CellState.ON,0);
		assertEquals(except.toString(),actual.toString());
		
		Generation g2 = new Generation("........");
		actual= er.evolve(er.getNeighborhood(4, g2, bc));
		except = new EvolvedCell(CellState.OFF,0);
		assertEquals(except.toString(),actual.toString());
	
	}
	
	@Test
	public void toStringTest() throws InvalidRuleNumException {
		TotalisticRule er = new TotalisticRule(22);
		String actual = er.toString();
		String expect = "5 4 3 2 1 0\n. O . O O .";
		assertEquals(expect,actual);
	}
	


}
