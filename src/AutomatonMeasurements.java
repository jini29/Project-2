
public class AutomatonMeasurements {
	public static int hammingDistance(Generation g1, Generation g2) { 
		if (g1.size() != g2.size()) { 
			throw new  IllegalArgumentException();
		}
		else {
			int distance =0;
			for(int i = 0; i < g1.size(); i++) {
				if (g1.getCell(i).getState().equals(g2.getCell(i).getState()) == false) {
					distance ++;
				}
			}
			return distance;
		}
		
		
	}
	
	public  static int hammingDistance(int stepNum, Automaton a) throws InvalidStepNumException {
		return hammingDistance(a.getGeneration(stepNum),a.getGeneration(stepNum+1));
	}
	
	public static int[] hammingDistances(Automaton a) throws InvalidStepNumException {
		int[] distances = new int[a.getTotalSteps()];
		for(int i =0; i<a.getTotalSteps(); i++) {
			
			distances[i]= hammingDistance(i,a);
		}
		
		return distances;
	}
	
	public static int[] subruleCount(int stepNum, Automaton a) throws InvalidStepNumException {
		if(stepNum >= 1) {
		int[] subruleCount = new int[a.getRule().getNumSubrules()];
		int count;
		EvolvedCell cell;
		for(int i = 0; i < a.getRule().getNumSubrules(); i++) {
			count = 0;
			for (int x = 0; x < a.getGeneration(stepNum).size(); x++) {
				cell =(EvolvedCell) a.getGeneration(stepNum).getCell(x);
				if (i == cell.getSubruleNum() ) {
					count ++;
				}
			}
			subruleCount[i] = count;
		}
		return subruleCount;
	}
		else {
			throw new InvalidStepNumException();
		}
	}
	public static int[][] subruleCounts(Automaton a) throws InvalidStepNumException{
		int[][] subruleCounts = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		for(int i =1; i <= a.getTotalSteps(); i++) {
			subruleCounts[i-1] = subruleCount(i,a);
		}
		
		return subruleCounts;
	}
}
