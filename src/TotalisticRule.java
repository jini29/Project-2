
public class TotalisticRule extends Rule{
	private final static int NUMSUBRULE = 6;
	private final static int NUMNEIGHBORS =5;
	public TotalisticRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		// TODO Auto-generated constructor stub
		if(Integer.toBinaryString(ruleNum).length() > NUMSUBRULE || ruleNum < 0) {
			throw new InvalidRuleNumException();
		}
		
	}
	
	public int getNumSubRules() {
		return NUMSUBRULE;
	}
	
	@Override
	public Cell[] getNeighborhood(int CellIdx, Generation gen, BoundaryConditions bc) {
		// TODO Auto-generated method stub
		Cell[] neighborhood = new Cell[NUMNEIGHBORS];
		int offset = -2;
		for (int i =0; i < neighborhood.length; i++) {
			neighborhood[i] = bc.getNeighbor(CellIdx, offset, gen);
			++offset;
		}
		return neighborhood;
	}

	@Override
	public EvolvedCell evolve(Cell[] neighborhood) {
		// TODO Auto-generated method stub
		int totalOn = 0;
		for (int i = 0; i < neighborhood.length; i++) {
			if (neighborhood[i].getState().equals(CellState.ON)) {
				totalOn ++;
			}
			
		}
		
		if (super.getBinary().charAt(totalOn) == '1') {
			return new EvolvedCell(CellState.ON,totalOn);
		}
		
		return new EvolvedCell(CellState.OFF,totalOn);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String output = "";
		for (int i = NUMSUBRULE-1; i >=0; i--) {
			output += i;
			if (i != 0) {
			output += " ";
			}
		}
		
		output += "\n";
		
		for (int i = 0; i <NUMSUBRULE; i++) {
			if (super.getBinary().charAt(i) == '1')
			output += "O";
			else {
				output += ".";
			}
			
			if (i != NUMSUBRULE-1) {
				output += " ";
				}
			
		}
		return output;
	}

}
