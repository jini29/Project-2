
public class Cell {
	/**
	 * stores the state of cell
	 */
	private CellState state;
	
	/**
	 * constructor with boolean argument creates cell with its state
	 * @param state
	 */
	
	public Cell() {
		state = CellState.OFF;
	}
	
	
	public Cell(CellState state) {
		this.state = state;
	}
	

	
	/**
	 * get the state of cell
	 * @return state
	 */
	
	public CellState getState() {
		return this.state;
	}
	
	
	/**
	 * To string for the cell which return true if state is true or false when state is false
	 */
	@Override
	public String toString() {
		return this.state.toString(); 
	}
	
	
	
}
