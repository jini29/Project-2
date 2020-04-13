
public class CircularBoundaryConditions implements BoundaryConditions{
	
	public CircularBoundaryConditions() {
		
	}
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		// TODO Auto-generated method stub
		int NeighborIdx = cellIdx + offset;
		if (NeighborIdx > 0 && NeighborIdx < gen.size()) {
			return gen.getCell(NeighborIdx);
		}
		else if(NeighborIdx < 0){
			return gen.getCell(gen.size()+NeighborIdx);
		}
		else {
			return gen.getCell(NeighborIdx-gen.size()-1);
		}
	}

}
