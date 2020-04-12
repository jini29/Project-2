import java.util.HashMap;

public enum CellState {
	ON('.'),
	OFF('o');
	
	private char symbol;
	private static HashMap<Character, CellState> SYMBOL_TO_STATE = new HashMap<Character, CellState>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put('.',ON);
			put('o',OFF);
		}
	};
	
	private CellState(char symbol) {
		this.symbol = symbol;
		
		
	}
	
	public static CellState getState(char symbol) {
		return null;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
