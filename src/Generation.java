import java.util.ArrayList;


public class Generation {
	/**
	 * stores an ArrayList of cells as a generation
	 */
	ArrayList<Cell> generation= new ArrayList<Cell>();
	
	/**
	 * take an ArrayList of cells and store it as a generation
	 * @param cells
	 */
	public Generation(ArrayList<Cell> cells) {
		for (int i = 0; i < cells.size(); i++) {
			generation.add(cells.get(i));
		}
	}
	
	/**
	 * get the copy of cell at a specific index
	 * @param index
	 * @return
	 */
	public Cell getCell(int index) {
		return new Cell(generation.get(index).getState());
	}
	
	/**
	 * gets the total number of cells in the generation
	 * @return
	 */
	public int getCellNum() {
		return generation.size();
	}
	
	
}
