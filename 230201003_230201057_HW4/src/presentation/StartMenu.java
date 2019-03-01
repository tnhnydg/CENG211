package presentation;

import java.awt.EventQueue;
import domain.Nutrition;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import domain.Breakfast;
import domain.Dinner;
import domain.Gender;
import domain.Lunch;

import domain.Person;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class StartMenu {

	private JFrame frmWelcome;
	private JTextField nameText;
	private JTextField weightText;
	private JTextField heightText;

	public StartMenu(ArrayList<Nutrition> nutritions) {
		initialize(nutritions);
	}
	
	public JFrame getFrmWelcome() {
		return this.frmWelcome;
	}
	public void runMainMenu(ArrayList<Nutrition> nutritions, Person person) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu(nutritions, person);
					window.getFrmDietMenu().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Nutrition> nutritions) {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 318, 260);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		weightText = new JTextField();
		weightText.setColumns(10);
		
		heightText = new JTextField();
		heightText.setColumns(10);
		
		JLabel lblWelcomeTo = new JLabel("Please fill in the blanks and create your account.");
		lblWelcomeTo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<String> ageBox = new JComboBox<String>();
		ageBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70"}));
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<Gender> genderBox = new JComboBox<Gender>();
		genderBox.setModel(new DefaultComboBoxModel<Gender>(Gender.values()));
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Person person = new Person(nameText.getText(),Double.parseDouble(weightText.getText()), Double.parseDouble(heightText.getText()), Integer.parseInt((String) ageBox.getSelectedItem()),	(Gender) genderBox.getSelectedItem());
				
				person.addBreakfast(new Breakfast(new ArrayList<Nutrition>()));
				person.addLunch(new Lunch(new ArrayList<Nutrition>()));
				person.addDinner(new Dinner(new ArrayList<Nutrition>()));
				
				runMainMenu(nutritions, person);
				frmWelcome.dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmWelcome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWelcomeTo)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWeight)
								.addComponent(lblHeight)
								.addComponent(lblAge)
								.addComponent(lblGender))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(ageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(weightText, Alignment.LEADING)
											.addComponent(heightText, Alignment.LEADING))
										.addComponent(genderBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCm)
										.addComponent(lblKg)))
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeTo)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(weightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeight)
						.addComponent(lblKg))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(heightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeight)
						.addComponent(lblCm))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(genderBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender)
						.addComponent(btnCreate))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		frmWelcome.getContentPane().setLayout(groupLayout);
	}
}
