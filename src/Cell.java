
public class Cell {
	/**
	 * stores the state of cell
	 */
	private boolean state;
	
	/**
	 * constructor with boolean argument creates cell with its state
	 * @param state
	 */
	public Cell(boolean state) {
		this.state = state;
	}
	
	/**
	 * Set the state of the cell
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	/**
	 * get the state of cell
	 * @return state
	 */
	
	public boolean getState() {
		return this.state;
	}
	
	
	/**
	 * To string for the cell which return true if state is true or false when state is false
	 */
	@Override
	public String toString() {
		if(state == true) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
	
	
}
