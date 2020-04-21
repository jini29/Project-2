
public class CircularBoundaryConditions implements BoundaryConditions{
	
	public CircularBoundaryConditions() {
		
	}
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		// TODO Auto-generated method stub
	
		int NeighborIdx = cellIdx + offset;
		 if(NeighborIdx < 0){
			while(NeighborIdx < 0)
			NeighborIdx = gen.size()+NeighborIdx;
		}
		else {
			while(NeighborIdx >= gen.size()) {
				NeighborIdx = NeighborIdx-gen.size();
			}
			
		}
		
		return gen.getCell(NeighborIdx);
	}
	


}
