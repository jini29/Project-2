import java.util.HashMap;

public enum CellState {
	ON('O'),
	OFF('.');
	
	private char symbol;
	private static HashMap<Character, CellState> SYMBOL_TO_STATE = new HashMap<Character, CellState>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put('O',ON);
			put('.',OFF);
		}
	};
	
	private CellState(char symbol) {
		this.symbol = symbol;
		
	}
	
	public static CellState getState(char symbol) {
		return SYMBOL_TO_STATE.get(symbol);
	}
	
	@Override
	public String toString() {
		return Character.toString(symbol);
	}
}
