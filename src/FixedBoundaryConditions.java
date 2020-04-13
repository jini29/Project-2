
public class FixedBoundaryConditions implements BoundaryConditions {

	private CellState left;
	private CellState right;
	
	public FixedBoundaryConditions(CellState left, CellState right) {
		this.left =left;
		this.right = right;
	}
	
	public CellState getLeftState() {
		return this.left;
	}
	
	public CellState getRightState() {
		return this.right;
	}
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		// TODO Auto-generated method stub
		int NeighborIdx = cellIdx + offset;
		if (NeighborIdx > 0 && NeighborIdx < gen.size()) {
			return gen.getCell(NeighborIdx);
		}
		else if(NeighborIdx < 0){
			return new Cell(getLeftState());
		}
		else {
			return new Cell(getRightState());
		}
	}
	
}
	
	

