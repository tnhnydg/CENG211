package development;

import java.util.ArrayList;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Row {

	private ArrayList<Cell> cellList;
	
	public Row(ArrayList<Cell> cellList) {
		
		setCells(cellList);
	}
	
	public ArrayList<Cell> createCells(){
		
		int size = cellList.size();
		
		for(int i=0; i<size; i++ ){
			
			Cell cell = new Cell(null,null,null,null);
			cellList.remove(i);
			cellList.add(i,cell);
		}
		return this.cellList;
	}

	public ArrayList<Cell> getCells() {

		return this.cellList;
	}

	public void setCells(ArrayList<Cell> cellList) {
		
		this.cellList = cellList;
	}

	public String toString() {
		
		return "Row [cells="+ cellList +"]";	
	}
}
