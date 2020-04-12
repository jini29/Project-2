import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		Automaton automaton = new Automaton("rule22-63cells-input.txt");
		Rule rule  = new Rule(22);
		automaton.evolve(31);
		System.out.println(automaton.toString());
		System.out.println(automaton.getRuleNum());
		if(rule.checkRules(false, false, false) == true) {
			System.out.println("true");
		}
		
		System.out.println(rule.getBinary().charAt(7));
		System.out.println(automaton.getTrueSymbol());
	}
}
