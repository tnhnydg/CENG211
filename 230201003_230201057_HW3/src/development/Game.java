package development;
// IMPORTANT NOTE : For TestGame --> testCreateGrid() , We thought that every grid creation requires also a gridsize creation. Since there are only one gridsize creation, we used this one for all and called it at every turn instead of creating new grids.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class Game {

	private Grid grid;
	private int exitLocation;
	
	public Game(Grid grid) {
		
		setGrid(grid);
		
	}
	public int initializeGridType1()
	{	
		int gridSize=grid.getRows().size();
		
		for(int i=0;i<gridSize;i++) {
			
			grid.getRows().get(i).getCells().get(0).setRight(CellComponents.APERTURE);
			grid.getRows().get(i).getCells().get(gridSize-1).setLeft(CellComponents.APERTURE);
		}
		
		for(int i=0;i<gridSize;i++) { //row 
			for(int j=1;j<gridSize-1;j++) { //cell
				
				grid.getRows().get(i).getCells().get(j).setLeft(CellComponents.APERTURE);
				grid.getRows().get(i).getCells().get(j).setRight(CellComponents.APERTURE);
			}
			
		}
		
		
		for(int i =0;i<gridSize-1;i++) {
			
			int apertureLocation = randomGen(0,gridSize);
			grid.getRows().get(i).getCells().get(apertureLocation).setDown(CellComponents.APERTURE);
			grid.getRows().get(i+1).getCells().get(apertureLocation).setUp(CellComponents.APERTURE);
		}
		
		
		int exitLocation = randomGen(0,gridSize);
		grid.getRows().get(exitLocation).getCells().get(0).setLeft(CellComponents.EXIT);
		
		this.exitLocation = exitLocation;
		
		return this.exitLocation;
	}
	
	public int initializeGridType2() {
		
		int gridSize=grid.getRows().size();
		
		for(int i=0;i<gridSize;i++) {
			
			this.grid.getRows().get(0).getCells().get(i).setDown(CellComponents.APERTURE);
			this.grid.getRows().get(gridSize-1).getCells().get(i).setUp(CellComponents.APERTURE);
		}
		
		for(int i=1;i<gridSize-1;i++) { //row 
			for(int j=0;j<gridSize;j++) { //cell
				
				this.grid.getRows().get(i).getCells().get(j).setDown(CellComponents.APERTURE);
				this.grid.getRows().get(i).getCells().get(j).setUp(CellComponents.APERTURE);
			}
			
		}
		
		for(int i =0;i<gridSize-1;i++) {
			
			int apertureLocation = randomGen(0,gridSize);
			this.grid.getRows().get(apertureLocation).getCells().get(i).setRight(CellComponents.APERTURE);
			this.grid.getRows().get(apertureLocation).getCells().get(i+1).setLeft(CellComponents.APERTURE);
		}
		
		
		int exitLocation = randomGen(0,gridSize);
		this.grid.getRows().get(exitLocation).getCells().get(0).setLeft(CellComponents.EXIT);
		
		this.exitLocation = exitLocation;
		
		return this.exitLocation;
	}

	public String takeInput() throws IOException{
		
		String input=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		return input;
	}

	public void start() throws IOException{
		
		createGrid();
	
		boolean flag =false;
		int gridSize = grid.getRows().size()-1;
		
		Player player = new Player(grid.getRows().get(gridSize),grid.getRows().get(gridSize).getCells().get(gridSize));
		
		Menu menu = new Menu(player,gridSize+1,this.exitLocation);
		menu.updateMenu(player);
		
		while(true){
		
		String input = takeInput();
		input = input.toLowerCase();
		
		if(input.equals("a")){
			
			if(player.getCurrentCell().getLeft().equals(CellComponents.EXIT)){
				
				System.out.println("ESCAPED!!");
				break;
			}
			
			flag = play(Movement.LEFT,player);
			
			if(flag==false){
				
				System.out.println("WALL");
			}
			
		}
		
		else if(input.equals("d")){
			
			flag = play(Movement.RIGHT,player);
		
			if(flag==false){
				
				System.out.println("WALL");
			}
			
		}
		
		else if(input.equals("w")){
			
			flag = play(Movement.UP,player);
			
			if(flag==false){
				
				System.out.print("WALL");
			}
			
		}
		else if(input.equals("s")){
			
			flag = play(Movement.DOWN,player);
			
			if(flag==false){
				
				System.out.println("WALL");
			}
			
		}
		else if(input.equals("q")) {
			
			System.out.print("GAME OVER!!");
			break;
		}
		
		menu.updateMenu(player);
		}
	}
	
	public boolean play(Movement move, Player player) {
		boolean flag = false;
		
		if(move.equals(Movement.LEFT) && player.getCurrentCell().getLeft().equals(CellComponents.APERTURE))
		{
			int cordCell = player.getCordCell()-1;
			player.setCordCell(cordCell);
			player.setCurrentCell(grid.getRows().get(player.getCordRow()).getCells().get(cordCell));
			flag = true;
		}
		else if(move.equals(Movement.RIGHT) && player.getCurrentCell().getRight().equals(CellComponents.APERTURE))
		{
			int cordCell = player.getCordCell() +1;
			player.setCordCell(cordCell);
			player.setCurrentCell(grid.getRows().get(player.getCordRow()).getCells().get(cordCell));
			flag = true;
		}
		else if(move.equals(Movement.UP) && player.getCurrentCell().getUp().equals(CellComponents.APERTURE))
		{
			int cordRow = player.getCordRow()-1;
			player.setCordRow(cordRow);
			player.setCurrentRow(grid.getRows().get(cordRow));
			player.setCurrentCell(player.getCurrentRow().getCells().get(player.getCordCell()));
			flag = true;
		}
		else if(move.equals(Movement.DOWN) && player.getCurrentCell().getDown().equals(CellComponents.APERTURE))
		{
			int cordRow =player.getCordRow()+1;
			player.setCordRow(cordRow);
			player.setCurrentRow(grid.getRows().get(cordRow));
			player.setCurrentCell(player.getCurrentRow().getCells().get(player.getCordCell()));
			flag = true;
		}
		else if(move.equals(Movement.LEFT) && player.getCurrentCell().getLeft().equals(CellComponents.EXIT))
		{
			flag=true;
		}
		return flag;
	}
	
	public Grid createGrid() {
	
		int size = gridSize();
		ArrayList<Row> rowList = grid.getRows();
		
		for(int i=0; i<size; i++){
			
			rowList.add(new Row(null));
		}
		
		this.grid.createRows();
		int gridType = randomGen(0,2);
		
		if (gridType == 0){
			
			initializeGridType1(); 
		}
		else {
			
			initializeGridType2();
		}
			
		return this.grid;
	}
	
	public int randomGen(int x,int y){
		Random rand = new Random();
		int  n = rand.nextInt(y) + x;
		return n;
	}
	
	public int gridSize(){
		
		Random rand = new Random();
		int  n = rand.nextInt(5) + 3;
		return n;
	}

	public void setGrid(Grid grid) {
		
		this.grid = grid;
		
	}

	public Grid getGrid() {
				
		return this.grid;
	}
	public String toString(){
		
		return "Game [grid="+this.grid+"]";
	}

}
