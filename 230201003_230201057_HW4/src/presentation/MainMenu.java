package presentation;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;


import javax.swing.JTable;
import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;

import dataAccess.FileProcessor;
import domain.Breakfast;
import domain.Dinner;
import domain.Lunch;
import domain.Meal;
import domain.Nutrition;
import domain.Person;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class MainMenu {

	private JFrame frmDietmenu;
	private JTable tableNutrition;
	private JTable tablePerson;

	
	public MainMenu(ArrayList<Nutrition> nutritions, Person person) {
		
		initialize(nutritions, person);
	}
	
	public JFrame getFrmDietMenu() {
		return this.frmDietmenu;
	}
	public void tableAddRow(ArrayList<Nutrition> nutritions, DefaultTableModel dtm, int index) {
		Vector<String> tmp = new Vector<String>();
		tmp.addElement(nutritions.get(index).getName());
		tmp.addElement(String.valueOf(nutritions.get(index).getUnit()));
		tmp.addElement(String.valueOf(nutritions.get(index).getCalorie()));
		dtm.addRow(tmp);
	}
	
	@SuppressWarnings("rawtypes")
	public void addProcess(Person person,ArrayList<Nutrition> validNutritions,DefaultTableModel dtmPerson,DefaultTableModel dtmNutrition,int i){
		person.getMealList()[i].addNutrition(validNutritions.get(tableNutrition.getSelectedRow()));
		dtmPerson.addRow((Vector) dtmNutrition.getDataVector().get(tableNutrition.getSelectedRow()));
	}
	
	public void listProcess(ArrayList<Nutrition> nutritions, ArrayList<Nutrition> validNutritions, int i){
		
		boolean flag = false;
		for(Nutrition n : validNutritions){
			if(n.equals((nutritions).get(i))){
				flag = true;
			}
		}
		if(flag == false){
			validNutritions.add(nutritions.get(i));
		}
		
		
	}
	
	public void sortAscending(ArrayList<Nutrition> validNutritions, DefaultTableModel dtmNutrition){
		dtmNutrition.setRowCount(0);
    	Collections.sort(validNutritions, new Comparator<Nutrition>(){   
			public int compare(Nutrition a, Nutrition b)
			  {
			     return Integer.compare(a.getCalorie(),b.getCalorie());
			  }
		});
    	for(int i=0; i<validNutritions.size(); i++ ) {
    		
				tableAddRow(validNutritions, dtmNutrition, i);
		}
	}
	
	public void sortDescending(ArrayList<Nutrition> validNutritions, DefaultTableModel dtmNutrition){
		dtmNutrition.setRowCount(0);
    	Collections.sort(validNutritions, new Comparator<Nutrition>(){  
			public int compare(Nutrition a, Nutrition b)
			  {
			     return Integer.compare(b.getCalorie(),a.getCalorie());
			  }
		});
    	for(int i=0; i<validNutritions.size(); i++ ) {
    		
				tableAddRow(validNutritions, dtmNutrition, i);
		}
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Nutrition> nutritions, Person person) {
		frmDietmenu = new JFrame();
		frmDietmenu.setTitle("Diet Menu");
		frmDietmenu.setBounds(100, 100, 452, 360);
		frmDietmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		Vector<String> tableNutritionColName = new Vector<String>();
		tableNutritionColName.addElement("Name");
		tableNutritionColName.addElement("Unit");
		tableNutritionColName.addElement("Calorie");
	
	
 		tableNutrition = new JTable();
 		DefaultTableModel dtmNutrition = new DefaultTableModel(0, 0);
 		dtmNutrition.setColumnIdentifiers(tableNutritionColName);
 		tableNutrition.setModel(dtmNutrition);
 		
 	
 		tablePerson = new JTable();
 		DefaultTableModel dtmPerson = new DefaultTableModel(0, 0);   
		dtmPerson.setColumnIdentifiers(tableNutritionColName);
		tablePerson.setModel(dtmPerson);
	
		JRadioButton rdbtnBreakfast = new JRadioButton("Breakfast");
		JRadioButton rdbtnLunch = new JRadioButton("Lunch");
		JRadioButton rdbtnDinner = new JRadioButton("Dinner");
			
		ArrayList<Nutrition> validNutritionsB = new ArrayList<>();
		ArrayList<Nutrition> validNutritionsL = new ArrayList<>();
		ArrayList<Nutrition> validNutritionsD = new ArrayList<>();
		
		rdbtnBreakfast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnLunch.setSelected(false);
				rdbtnDinner.setSelected(false);
				dtmNutrition.setRowCount(0);
				dtmPerson.setRowCount(0);
				
				for(int i=0; i<person.getMealList()[0].getNutritionList().size(); i++) {
					
					tableAddRow(person.getMealList()[0].getNutritionList(), dtmPerson, i);
				}	
				
				for(int i=0; i<nutritions.size(); i++ ) {
					
					if(Breakfast.containsType(nutritions.get(i).getType())) {
						listProcess(nutritions, validNutritionsB, i);
					}
				}
				for(int j=0; j<validNutritionsB.size();j++){
					
					tableAddRow(validNutritionsB, dtmNutrition, j);
				}
				
		
			}
		});
		rdbtnLunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				rdbtnBreakfast.setSelected(false);
				rdbtnDinner.setSelected(false);
				
				dtmNutrition.setRowCount(0);
				dtmPerson.setRowCount(0);
				
				for(int i=0; i<person.getMealList()[1].getNutritionList().size(); i++) {
					
					tableAddRow(person.getMealList()[1].getNutritionList(), dtmPerson, i);
				}	
				
				for(int i=0; i<nutritions.size(); i++) {
					
					if(Lunch.containsType(nutritions.get(i).getType())) {
						listProcess(nutritions, validNutritionsL, i);
					}
				}
				for(int j=0; j<validNutritionsL.size();j++){
					
					tableAddRow(validNutritionsL, dtmNutrition, j);
				}
				
				
			}
		});
		rdbtnDinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnBreakfast.setSelected(false);
				rdbtnLunch.setSelected(false);
				
				dtmNutrition.setRowCount(0);
				dtmPerson.setRowCount(0);
				
				for(int i=0; i<person.getMealList()[2].getNutritionList().size(); i++) {
					
					tableAddRow(person.getMealList()[2].getNutritionList(), dtmPerson, i);
				}	
				
				for(int i=0; i<nutritions.size(); i++) {
					
					if(Dinner.containsType(nutritions.get(i).getType())) {
						listProcess(nutritions, validNutritionsD, i);
					}
				}
				for(int j=0; j<validNutritionsD.size();j++){
					
					tableAddRow(validNutritionsD, dtmNutrition, j);
				}
				
				
			}
		});
		
		tableNutrition.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evnt) {
				if(rdbtnBreakfast.isSelected()){
					if (evnt.getClickCount() == 1) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortAscending(validNutritionsB, dtmNutrition);
			            }
			         }
			        else if (evnt.getClickCount() == 2) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortDescending(validNutritionsB, dtmNutrition);
			            }
			         }
				}
				else if(rdbtnLunch.isSelected()){
					if (evnt.getClickCount() == 1) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortAscending(validNutritionsL, dtmNutrition);
			            }
			         }
			        else if (evnt.getClickCount() == 2) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortDescending(validNutritionsL, dtmNutrition);
			            }
			         }
				}
				else if(rdbtnDinner.isSelected()){
					if (evnt.getClickCount() == 1) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortAscending(validNutritionsD, dtmNutrition);
			            }
			         }
			        else if (evnt.getClickCount() == 2) {
			        	int col = tableNutrition.columnAtPoint(evnt.getPoint());
			            if(col == 2){
			            	sortDescending(validNutritionsD, dtmNutrition);
			            }
			         }
				}
		     }
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBreakfast.isSelected()) {
					if(tableNutrition.getSelectedRow() != -1) {
						addProcess(person, validNutritionsB, dtmPerson, dtmNutrition, 0);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select item from table");
					}
				}
				else if(rdbtnLunch.isSelected()) {
					if(tableNutrition.getSelectedRow() != -1) {
						addProcess(person, validNutritionsL, dtmPerson, dtmNutrition, 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select item from table");
					}
				}
				else if(rdbtnDinner.isSelected()) {
					if(tableNutrition.getSelectedRow() != -1) {
						addProcess(person, validNutritionsD, dtmPerson, dtmNutrition, 2);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select item from table");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a meal");
				}
				
			}
		});
		
		JScrollPane scrollPaneNutrition = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("");
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int totCalorie = 0;
	        	for(Meal m : person.getMealList()){
	        		
	        		totCalorie += m.computeTotalCalorie();
	        		
	        	}
	        	if (totCalorie <= person.dailyOptCalorie() ){
	        		lblNewLabel.setText("OK.");
	        	}
	        	else {
	        		lblNewLabel.setText("Exceeded!");
	        	}
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileProcessor fp = new FileProcessor("files//dailyNutritions.dat");
				try {
					fp.saveInformation(person);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPanePerson = new JScrollPane();
		
		JLabel lblToSortClick = new JLabel("To sort, click on Calorie once or twice.");
		
		GroupLayout groupLayout = new GroupLayout(frmDietmenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPaneNutrition, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAdd))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(rdbtnBreakfast)
									.addGap(47)
									.addComponent(rdbtnLunch))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(btnCheck)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(rdbtnDinner)
							.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(101))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPanePerson, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(lblToSortClick)
					.addGap(116))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnBreakfast)
						.addComponent(rdbtnLunch)
						.addComponent(rdbtnDinner))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(168)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCheck)
										.addComponent(btnSave)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPaneNutrition, 0, 0, Short.MAX_VALUE)
										.addComponent(scrollPanePerson, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
									.addGap(28)))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(btnAdd)
							.addGap(128)
							.addComponent(lblNewLabel)))
					.addGap(18))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(303, Short.MAX_VALUE)
					.addComponent(lblToSortClick)
					.addContainerGap())
		);
		
		scrollPaneNutrition.setViewportView(tableNutrition);	
		scrollPanePerson.setViewportView(tablePerson);
		
		frmDietmenu.getContentPane().setLayout(groupLayout);
	}
	
	
}
