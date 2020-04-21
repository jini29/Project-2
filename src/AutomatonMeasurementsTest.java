import static org.junit.Assert.*;

import org.junit.Test;

public class AutomatonMeasurementsTest {

	@Test
	public void SubruleCountsTest() throws InvalidRuleNumException, InvalidStepNumException {
		Generation gen = new Generation("........O........");
		TotalisticRule tr = new TotalisticRule(60);
		BoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
		Automaton a = new Automaton(tr,gen,bc);
		a.evolve(20);
		
		AutomatonMeasurements.subruleCounts(a);
		
	}

}
