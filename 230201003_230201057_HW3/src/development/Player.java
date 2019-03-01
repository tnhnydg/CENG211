package development;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Player {
	
	private Row currentRow;
	private Cell currentCell;
	private int cordRow;
	private int cordCell;
	
	public Player(Row row, Cell cell) {
		
		this.cordRow = row.getCells().size()-1;
		this.cordCell = this.cordRow;
		setCurrentRow(row);
		setCurrentCell(cell);
		
	}
	
	public void setCurrentRow(Row newRow) {
		
		this.currentRow = newRow;
	}
	
	public void setCurrentCell(Cell newCell) {
		
		this.currentCell = newCell;
	}

	public Row getCurrentRow() {
		
		return this.currentRow;
	}

	public Cell getCurrentCell() {
	
		return this.currentCell;
	}

	public int getCordRow() {
		return cordRow;
	}

	public void setCordRow(int cordRow) {
		this.cordRow = cordRow;
	}

	public int getCordCell() {
		return cordCell;
	}

	public void setCordCell(int cordCell) {
		this.cordCell = cordCell;
	}
	
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

}
