
public class FixedBoundaryConditions implements BoundaryConditions {

	private CellState left;
	private CellState right;
	
	public FixedBoundaryConditions(CellState left, CellState right) {
		this.left =left;
		this.right = right;
	}
	
	public CellState getLeftState() {
		return null;
	}
	
	public CellState getRightState() {
		return null;
	}
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
