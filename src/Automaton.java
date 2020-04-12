import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Automaton {
	/**
	 * char stores trueSymbol with default being '1'
	 */
	private char trueSymbol = '1';
	/**
	 * char stores falseSymbol with default being '0'
	 */
	private char falseSymbol = '0';
	
	/**
	 * int stores ruleNum 
	 */
	private int ruleNum;
	
	/**
	 * ArrayList stores cells
	 */
	ArrayList<Cell> cells= new ArrayList<Cell>();
	
	/**
	 * ArrayList stores generations
	 */
	ArrayList<Generation> generations = new ArrayList<Generation>(); 
	
	/**
	 * constructor takes int ruleNum and boolean array
	 * Stores boolean array to cells ArrayList with each boolean being the state of each cell
	 * adds the ArrayList of cells to as the first generation to the generation ArrayList
	 * @param ruleNum
	 * @param initState
	 */
	public Automaton(int ruleNum, boolean[] initState) {
		this.ruleNum =ruleNum;
		
		for(int i=0; i < initState.length; i++) {
			cells.add(new Cell(initState[i]));
		}
		generations.add(new Generation(cells));
	}
	
	/**
	 * constructor takes the string filename
	 * open the file with the filename and takes the first line as the rule number
	 * takes the second as the true and false symbol
	 * takes the third line as the boolean array
	 * @param filename
	 * @throws IOException
	 */
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
	
	/**
	 * evolve based on the first generation with numSteps giving by the user
	 * passes the left state, middle state, right state of each cells on the generation to checkrules 
	 * which determines the state of next generation
	 * if the cells is the the left end, then the left cells state will the be cells on the right end
	 * if the cells is the the right end, then the left cells state will the be cells on the left end
	 * passes the cells on the next generation to Arraylist generations
	 * @param numSteps
	 */
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
		
	
	/**
	 * get the totalSteop by subtract the size of generations by 1
	 * @return
	 */
	public int getTotalSteps() {
		return (generations.size()-1);
	}
	
	/**
	 * gets the boolean array of the state of each cells on a specific generation 
	 * @param stepNum
	 * @return
	 */
	public boolean[] getState(int stepNum){
		boolean[] states = new boolean[generations.get(stepNum).getCellNum()];
		for (int i = 0; i < cells.size(); i ++) {
			states[i]=generations.get(stepNum).getCell(i).getState();
		}
		return states;
	}
	
	/**
	 * gets the String of the state of each cells on a specific generation with correct true and false symbol
	 * @param stepNum
	 * @return
	 */
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
	
	/**
	 * save the result on a file
	 * @param filename
	 * @throws IOException
	 */
	public void save(String filename) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		 
		writer.write(toString());
		 
		 writer.close();
	}
	
	/**
	 * override the toString method to get the stateString on each generation and return the stateString of all generations
	 */
	@Override
	public String toString() {
		String toString = "";
		for (int i = 0; i <generations.size()-1; i++) {
			toString = toString + getStateString(i) + "\n";
		}
		toString =toString + getStateString(generations.size()-1);
		return toString;
		
	}
	
	/**
	 *  get the ruleNum
	 */
	public int getRuleNum() {
		return ruleNum;
	}
	
	/**
	 * sets the trueSymbol
	 * @param symbol
	 */
	public void setTrueSymbol(char symbol) {
		trueSymbol = symbol;
	}
	
	/**
	 * get the trueSymbol
	 * @return
	 */
	public char getTrueSymbol() {
		return trueSymbol;
	}
	
	/**
	 * set the FalseSymbol
	 * @param symbol
	 */
	public void setFalseSymbol(char symbol) {
		falseSymbol = symbol;
	}
	
	/**
	 * get the FalseSymbol
	 * @return
	 */
	public char getFalseSymbol() {
		return falseSymbol;
	}
	
}
