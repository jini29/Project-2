
public abstract class Rule {
	/**
	 * stores the ruleNum of rule
	 */
	private int ruleNum;
	
	/**
	 * constructor takes int ruleNum
	 * @param ruleNum
	 */
	protected Rule(int ruleNum) {
		this.ruleNum = ruleNum;
	}
	
	/**
	 *Get the binary string of with given rule number. Adds 0 in front of the string if the string does not have 8 character.
	 * @return
	 */
	protected String getBinary(int numSubrule) {
		String binary = "";
		for(int i = 0; i < (numSubrule-Integer.toBinaryString(ruleNum).length()); i++) {
			binary = binary + "0";
		}
		return binary+Integer.toBinaryString(ruleNum);
		
	}
	
	public int getRuleNum() {
		return ruleNum;
	}
	
	public Generation evolve(Generation gen, BoundaryConditions bc) {
		Cell[] newGen= new Cell[gen.size()];
		
		for (int i =0; i<gen.size(); i++) {
			newGen[i] = evolve(getNeighborhood(i,gen,bc));
		}
		
		return new Generation(newGen);
	}
	
	public int getNumSubrules() {
		return getBinary(8).length();
	}
	
	public abstract Cell[] getNeighborhood(int CellIdx, Generation gen, BoundaryConditions bc);
	
	
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	public abstract String toString();
	/**
	 * Takes the left boolean, middle boolean, and right boolean of cells the in the generation
	 * and checks if the char at the binary string is 1 or not
	 * if 1 then the cells on the next generation is true
	 * if not then the cells on the next generation is false
	 * @param left
	 * @param middle
	 * @param right
	 * @return
	 */
	
	/*public boolean checkRules(boolean left, boolean middle, boolean right) {
		if (getBinary().charAt(0) == '1' && left == true && middle == true && right ==true ) {
			return true;
		}
		else if (getBinary().charAt(1) == '1' && left == true && middle == true && right ==false ) {
			return true;
		}
		else if (getBinary().charAt(2) == '1' && left == true && middle == false  && right ==true  ) {
			return true;
		}
		else if (getBinary().charAt(3) == '1' && left == true  && middle == false  && right == false ) {
			return true;
		}
		else if (getBinary().charAt(4) == '1' && left == false  && middle == true  && right ==true  ) {
			return true;
			
		}
		else if (getBinary().charAt(5) == '1' && left == false  && middle == true  && right == false  ) {
			return true;
		}
		else if (getBinary().charAt(6) == '1' && left == false  && middle == false  && right == true  ) {
			return true;
		}
		else if (getBinary().charAt(7) == '1' && left == false  && middle == false  && right == false  ) {
			return true;
		}
		else {
			return false;
		}
	
}
	*/
}
