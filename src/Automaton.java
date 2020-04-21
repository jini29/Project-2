/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
*/
import java.util.*;


public class Automaton {
	
	private Rule rule;
	
	private List<Generation> generations;
	
	
	private BoundaryConditions bc;
	
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		generations = new ArrayList<Generation>();
		this.rule = rule;
		this.bc = bc;
		generations.add(init);
	}
	
	public void evolve(int numSteps) {
		int currentstep = getTotalSteps();
		for (int i = getTotalSteps(); i < (currentstep+numSteps); i++) {
			generations.add(rule.evolve(generations.get(i), bc));
		}
	}
	
	public Rule getRule() {
		return this.rule;
	}
	public int getTotalSteps() {
		return generations.size()-1;
	}
	
	public Generation getGeneration(int stepnum) throws InvalidStepNumException {
		
		if (stepnum<0) {
			throw new InvalidStepNumException();
		}
		
		if (getTotalSteps() < stepnum) {
			evolve(stepnum-getTotalSteps());
		}
		
		Cell[] cells = new Cell[generations.get(stepnum).size()];
 		for(int i = 0; i <generations.get(stepnum).size(); i++) {
 			cells[i] = generations.get(stepnum).getCell(i);
		}
		return new Generation(cells);
		
	}
	
	public BoundaryConditions getBoundaryConditions() {
		return this.bc;
	}
	
	@Override
	public String toString() {
		return generations.get(generations.size()-1).toString();
	}
	
	public String getHistory() {
		String toString = "";
		for (int i = 0; i <generations.size()-1; i++) {
			toString = toString + generations.get(i).toString() + "\n";
		}
		toString =toString + generations.get((generations.size()-1)).toString();
		return toString;
	}

	/*
	ArrayList<Cell> cells= new ArrayList<Cell>();
	
	
	ArrayList<Generation> generations = new ArrayList<Generation>(); 
	
	
	public Automaton(int ruleNum, boolean[] initState) {
		this.ruleNum =ruleNum;
		
		for(int i=0; i < initState.length; i++) {
			cells.add(new Cell(initState[i]));
		}
		generations.add(new Generation(cells));
	}
	

	public Automaton(String filename) throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader(filename));
		  String line = reader.readLine();
		  ruleNum = Integer.valueOf(line);
		  line =reader.readLine();
		  String[] symbols = line.split(" ");
		  falseSymbol = symbols[0].charAt(0);
		  trueSymbol = symbols[1].charAt(0);
		  line =reader.readLine();
		  boolean state;
		  for(int i=0; i < line.length(); i++) {
			  if (line.charAt(i) == getTrueSymbol()) {
				  state = true;
				  
			  }
			  else
			  {
				  state = false;
			  }
				cells.add(new Cell(state));
			}
		  generations.add(new Generation(cells));
		  reader.close();
		
	}
	

	public void evolve(int numSteps) {
		
		Rule rule = new Rule(ruleNum);
		Generation generation;
		ArrayList<Cell> newCells = cells;
		for (int x = 0; x <numSteps; x++) {
		for (int i = 0; i < generations.get(x).getCellNum(); i++) {
			generation = generations.get(x);
			
			if (i == 0) {
				if (rule.checkRules(generation.getCell(generation.getCellNum()-1).getState(), generation.getCell(i).getState(), generation.getCell(i+1).getState()) == true) {
					newCells.set(i, new Cell(true));
					
					
				}
				else {
					newCells.set(i, new Cell(false));
					
				}
			}
			else if(i == (cells.size()-1)) {
				
					if (rule.checkRules(generation.getCell(i-1).getState(), generation.getCell(i).getState(), generation.getCell(0).getState()) == true) {
						newCells.set(i, new Cell(true));
					}
					else {
						newCells.set(i, new Cell(false));
					}
				}
			
			else {
				
					if (rule.checkRules( generation.getCell(i-1).getState(),  generation.getCell(i).getState(), generation.getCell(i+1).getState()) == true) {
						newCells.set(i, new Cell(true));
						
					}
					else {
						newCells.set(i, new Cell(false));
						
					}
				}
			
			//System.out.print(newCells.get(i).getState());
		}
		
		
		generations.add(new Generation(newCells));
		//System.out.println();
		}
	}
		

	public int getTotalSteps() {
		return (generations.size()-1);
	}
	
	
	public boolean[] getState(int stepNum){
		boolean[] states = new boolean[generations.get(stepNum).getCellNum()];
		for (int i = 0; i < cells.size(); i ++) {
			states[i]=generations.get(stepNum).getCell(i).getState();
		}
		return states;
	}
	
	
	public String getStateString (int stepNum) {
		String stateString = "";
		for (int i = 0; i < cells.size(); i ++) {
			if(generations.get(stepNum).getCell(i).getState() ==true){
				stateString = stateString + getTrueSymbol();
			}
			else {
				stateString = stateString + getFalseSymbol();
			}
		}
		
		return stateString;
	}
	
	
	public void save(String filename) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		 
		writer.write(toString());
		 
		 writer.close();
	}
	
	
	@Override
	public String toString() {
		String toString = "";
		for (int i = 0; i <generations.size()-1; i++) {
			toString = toString + getStateString(i) + "\n";
		}
		toString =toString + getStateString(generations.size()-1);
		return toString;
		
	}
	
	
	public int getRuleNum() {
		return ruleNum;
	}
	

	public void setTrueSymbol(char symbol) {
		trueSymbol = symbol;
	}
	
	
	public char getTrueSymbol() {
		return trueSymbol;
	}
	

	public void setFalseSymbol(char symbol) {
		falseSymbol = symbol;
	}
	
	
	public char getFalseSymbol() {
		return falseSymbol;
	}
	*/
	
}
