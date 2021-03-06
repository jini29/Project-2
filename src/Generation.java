


public class Generation {
	/**
	 * stores an ArrayList of cells as a generation
	 */
	private Cell[] cells;
	
	/**
	 * take an ArrayList of cells and store it as a generation
	 * @param cells
	 */
	
	public Generation(CellState[] states) {
		this.cells = new Cell[states.length];
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new Cell(states[i]);
		}
	}
	
	public Generation(String states) {
		this.cells = new Cell[states.length()];
		for (int i = 0; i < cells.length; i++) {
			if(CellState.getState(states.charAt(i)) == null) {
				throw new IllegalArgumentException();
			}
			else {
				
				cells[i] = new Cell(CellState.getState(states.charAt(i)));
			}
		}
	}
	public Generation(Cell[] cells) {
		this.cells = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			this.cells[i] = cells[i];
		}
	
	}
	
	/**
	 * get the copy of cell at a specific index
	 * @param index
	 * @return
	 */
	public Cell getCell(int index) {
		return cells[index];
	}
	
	/**
	 * gets the total number of cells in the generation
	 * @return
	 */
	public int size() {
		return cells.length;
	}
	
	@Override
	public String toString() {
		String output ="";
		for (int i =0; i < cells.length; i++) {
			output += cells[i].toString();
		}
		return output;
	}
	
	
}
