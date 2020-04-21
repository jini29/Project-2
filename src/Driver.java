import java.io.IOException;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws IOException, InvalidRuleNumException, InvalidStepNumException {
		/*Automaton automaton = new Automaton("rule22-63cells-input.txt");
		Rule rule  = new Rule(22);
		automaton.evolve(31);
		System.out.println(automaton.toString());
		System.out.println(automaton.getRuleNum());
		if(rule.checkRules(false, false, false) == true) {
			System.out.println("true");
		}
		
		System.out.println(rule.getBinary().charAt(7));
		System.out.println(automaton.getTrueSymbol());
		 
		 */
		
		ElementaryRule er = new ElementaryRule(30);
		Generation gen = new Generation("........O........");
		Automaton a = new Automaton(er,gen, new CircularBoundaryConditions());
		System.out.print(er);
		a.evolve(10);
		System.out.print(a.getHistory());
		System.out.print(a.getTotalSteps());
		System.out.println(er.evolve(gen, new CircularBoundaryConditions()));
		Cell[] cells =new Cell[] {new Cell(CellState.ON),new Cell(CellState.ON),new Cell(CellState.ON)};
		Cell[] cells2 =new Cell[] {new Cell(CellState.ON),new Cell(CellState.ON),new Cell(CellState.ON)};
		cells2[0] = new EvolvedCell(CellState.ON,1);
		System.out.print(Arrays.deepEquals(cells,cells2));
		//a.getGeneration(10);
		System.out.println(a.getGeneration(9));
		
		Cell cell = (EvolvedCell)er.evolve(cells);
		System.out.print(a.getGeneration(9).getCell(1).getClass());
	
	}
}
