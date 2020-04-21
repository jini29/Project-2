import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ElementaryRule extends Rule {

	private final static int NUMSUBRULE = 8;
	private final static int NUMNEIGHBORS =3;
	private static HashMap<Integer, CellState[]> subrule = new HashMap<Integer, CellState[]>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(0,new CellState[] {CellState.OFF,CellState.OFF,CellState.OFF});
			put(1,new CellState[] {CellState.OFF,CellState.OFF,CellState.ON});
			put(2,new CellState[] {CellState.OFF,CellState.ON,CellState.OFF});
			put(3,new CellState[] {CellState.OFF,CellState.ON,CellState.ON});
			put(4,new CellState[] {CellState.ON,CellState.OFF,CellState.OFF});
			put(5,new CellState[] {CellState.ON,CellState.OFF,CellState.ON});
			put(6,new CellState[] {CellState.ON,CellState.ON,CellState.OFF});
			put(7,new CellState[] {CellState.ON,CellState.ON,CellState.ON});
		}
	};
	
	public ElementaryRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		if(Integer.toBinaryString(ruleNum).length() > NUMSUBRULE || ruleNum < 0) {
			throw new InvalidRuleNumException();
		}
		
	}
	
	public int getNumSubrules() {
		return NUMSUBRULE;
	}
	

@Override
public Cell[] getNeighborhood(int CellIdx, Generation gen, BoundaryConditions bc) {
	// TODO Auto-generated method stub
	Cell[] neighborhood = new Cell[NUMNEIGHBORS];
	int offset = -1;
	for (int i =0; i < NUMNEIGHBORS; i++) {
		neighborhood[i] = bc.getNeighbor(CellIdx, offset, gen);
		++offset;
	}
	return neighborhood;
}

@Override
public EvolvedCell evolve(Cell[] neighborhood) {
	// TODO Auto-generated method stub
	int subRuleNum =0;
	for (int i =0; i < NUMSUBRULE; i++) {
		if(subrule.get(i)[0].equals(neighborhood[0].getState())
			&&	subrule.get(i)[1].equals(neighborhood[1].getState())
			&& subrule.get(i)[2].equals(neighborhood[2].getState())) {
			subRuleNum = i;
		}
	}
	
	if (super.getBinary(NUMSUBRULE).charAt(7-subRuleNum) == '1') {
		return new EvolvedCell(CellState.ON, subRuleNum);
	}
	return new EvolvedCell(CellState.OFF, subRuleNum);
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	
	String output = "";
	for (int i = subrule.size()-1; i >=0; i--) {
		for (int x =0; x < NUMNEIGHBORS; x++ ) {
		output += subrule.get(i)[x].toString();
		}
		if (i != 0) {
		output += " ";
		}
	}
	
	output += "\n";
	
	for (int i = 0; i <subrule.size(); i++) {
		if (super.getBinary(NUMSUBRULE).charAt(i) == '1')
		output += " O ";
		else {
			output += " . ";
		}
		
		if (i != subrule.size()-1) {
			output += " ";
			}
		
	}
	return output;
}
}
