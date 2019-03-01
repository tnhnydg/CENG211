package domain;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataAccess.FileProcessor;
import presentation.StartMenu;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class App {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Nutrition> nutritions = new ArrayList<Nutrition>();
	
		FileProcessor fileProcess = new FileProcessor("files//nutrition.dat");
		fileProcess.initializeNutritions(nutritions);
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu window = new StartMenu(nutritions);
					window.getFrmWelcome().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

}
