package development;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Menu {
	
	private String[][] display;
	private int gridSize;
	private int rowMem;
	private int cellMem;
	
	public Menu(Player player, int gridSize,int exitLocation)
	{	
		startScreen();
		display = new String[gridSize][gridSize];
		
		this.gridSize = gridSize;
		
		this.rowMem=gridSize-1;
		this.cellMem=gridSize-1;
		
		initializeDisplay(player,exitLocation);
	}
	
	public void startScreen() {
		System.out.println("<<<Welcome to the LET ME OUT GAME>>>");
		System.out.println("TO MOVE PLEASE USE 'W' 'A' 'S' 'D' AND PRESS ENTER");
		System.out.println("TO EXIT PRESS 'Q' AND ENTER");
		System.out.println("	W->>UP");
		System.out.println("	S->>DOWN");
		System.out.println("	A->>LEFT");
		System.out.println("	D->>RIGHT");
		
	}
	
	public void initializeDisplay(Player player,int exitLocation)
	{
		
		for(int i=0; i<this.gridSize; i++ ){
			for(int j=0; j<this.gridSize; j++){
				this.display[i][j] = "S";
			}
		}	
		
		this.display[exitLocation][0] = "E";
		this.display[player.getCordRow()][player.getCordCell()] = "A";
	}
	
	public void updateMenu(Player player){
		
		this.display[this.rowMem][this.cellMem] = "S";
		this.display[player.getCordRow()][player.getCordCell()] = "A";
		
		this.rowMem=player.getCordRow();
		this.cellMem=player.getCordCell();
		
		printMenu();
	}
	
	public void printMenu()
	{
		System.out.println();
		for(int i=0; i<gridSize; i++){
			
			for(int j=0; j<gridSize; j++){
			
				System.out.print(display[i][j]);
				
				if(j+1!=gridSize){
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

}
