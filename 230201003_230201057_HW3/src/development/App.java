package development;

import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		
		Grid grid=new Grid(new ArrayList<Row>());
		Game game = new Game(grid);
		game.start();
		
	}
	

}
