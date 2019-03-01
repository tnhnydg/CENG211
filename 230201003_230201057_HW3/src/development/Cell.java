package development;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Cell {

	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		setLeft(left);
		setRight(right);
		setUp(up);
		setDown(down);
	}
	
	public void setLeft(CellComponents left) {
		
		if(left == null){
			this.left = CellComponents.WALL;
		}
		else{
			this.left = left;
		}
	}
	
	public void setRight(CellComponents right) {
		
		if(right == null){	
			this.right = CellComponents.WALL;
		}
		else{
			this.right = right;
		}
				
	}
	
	public void setUp(CellComponents up) {
		
		if(up == null){
			this.up = CellComponents.WALL;
		}
		else{
			this.up = up;
		}
		
	}
	
	public void setDown(CellComponents down) {
		
		if(down == null){
			this.down = CellComponents.WALL;
		}
		else{
			this.down = down;
		}
	}

	public CellComponents getLeft() {
		
		return this.left;
	}
	
	public CellComponents getRight() {
	
		return this.right;
	}

	public CellComponents getUp() {
		
		return this.up;
	}

	public CellComponents getDown() {
		
		return this.down;
	}

	public String toString(){
		
	  return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	  
	}

}
