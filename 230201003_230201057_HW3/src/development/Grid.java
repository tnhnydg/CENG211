package development;

import java.util.ArrayList;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Grid {

	private ArrayList<Row> rowList;

	public Grid(ArrayList<Row> rowList) {	

		setRows(rowList);	
	}
	
	public ArrayList<Row> createRows(){
		int size = rowList.size();
	
		for(int j=0; j<size; j++) {
			
			ArrayList<Cell> cellList =new ArrayList<Cell>();
			
			for(int i=0; i<size; i++){
				cellList.add(null);
			}
	
			Row row = new Row(cellList);
			row.createCells();
			rowList.remove(j);
			rowList.add(j,row);
			
		}
		return this.rowList;
	}
	
	public ArrayList<Row> getRows() {
	
		return this.rowList;
	}

	public void setRows(ArrayList<Row> rowList) {		
		
		this.rowList = rowList;
		
		
	}
	
	public String toString()
	{
		
		return "Grid [rows="+rowList+"]";
		
	}
}
