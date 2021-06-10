//Regan Ross - 0369345
//Assignment 4 , Question 1
//For Dr. Aaron Langille, collector of dice




package question1;

import javax.swing.*;
import java.awt.*;
import java.awt.Window;
import java.awt.event.*;

public class GooeyDice extends JFrame{
	//Labels
	private JLabel label1, label2;
	//Buttons
	private JButton create, roll;
	private JRadioButton blue, green, red;
	private JCheckBox showSum;
	//Panels
	private JPanel options, newDie, sums, radioButtons;
	private JScrollPane history;
	//Textfields
	private JTextField numSides;
	//TextAreas
	private JTextArea output;
	private JTextArea sumText;
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 400;
	
	//For Functionality
	private Die currentDie;
	private int sum;
	private String s;
	
	public GooeyDice(){
		
		sum = 0;
		
		//Setting Title
		setTitle("Dice GUI by Regan Ross");
		
		//Set Close Operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting Size
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//initializing labels
		label1 = new JLabel("Number of sides:");
		label2 = new JLabel("Sum:");
		
		//Initializing text field
		numSides = new JTextField(5);

		//initializing buttons
		create = new JButton("Create");
		roll = new JButton("Roll");
		roll.setPreferredSize(new Dimension(200,100));
		
		//RadioButtons
		blue = new JRadioButton("Blue");
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		
		//Radio Button Panel
		radioButtons = new JPanel();
		radioButtons.add(blue);
		radioButtons.add(green);
		radioButtons.add(red);
		radioButtons.setBorder(BorderFactory.createTitledBorder("Colour of Roll Button"));
		radioButtons.setPreferredSize(new Dimension(200,60));
		
		//Grouping buttons
		ButtonGroup colours = new ButtonGroup();
		colours.add(blue);
		colours.add(red);
		colours.add(green);
		
		
		//initializing textArea
		output = new JTextArea(20,20);
		output.setText("Creating a new die replaces the previous.\n");
		sumText = new JTextArea(1,3);
		
		//New Die Panel
		newDie = new JPanel();
		newDie.add(label1);
		newDie.add(numSides);
		newDie.add(create);
		newDie.setBorder(BorderFactory.createTitledBorder("New Die"));
		
		//Sum Checkbox
		showSum = new JCheckBox("Show sum");
		
		//Sum Checkbox panel
		sums = new JPanel();
		sums.add(sumText);
		sums.add(showSum);
		sums.add(label2);
		sums.add(sumText);
		sums.add(radioButtons);
		sums.setBorder(BorderFactory.createTitledBorder("Additional Options"));
		
		//Die Options Panel
		options = new JPanel();
		options.add(newDie, BorderLayout.CENTER);
		options.add(roll);
		options.setBorder(BorderFactory.createTitledBorder("Die Options"));
		
		//Roll history panel
		history = new JScrollPane(output);
		history.setBorder(BorderFactory.createTitledBorder("Roll History"));
			
		//Organizing layout
		setLayout(new GridLayout(0,3));
		
		add(options);
		add(history);
		add(sums);
		
		setVisible(true);
		
		
		//Adding action Listeners
		create.addActionListener(new DieActionListener());
		roll.addActionListener(new DieActionListener());
		showSum.addActionListener(new DieActionListener());
		blue.addActionListener(new colourActionListener());
		red.addActionListener(new colourActionListener());
		green.addActionListener(new colourActionListener());
		
	}
	//Action Listener class for "create" button
	public class DieActionListener implements ActionListener{

		//Die must be initialized here
		private int numRolls = 0;
		private int sum;
		
		public void actionPerformed(ActionEvent e) {
			
			//Collecting input
			String input = numSides.getText();
			int sides = 0;
			
			try {
			sides = Integer.parseInt(input);
			}catch(NumberFormatException h) {}
			
			//CREATE BUTTON
			if(e.getSource() == create) {
				
					try {
						currentDie = new Die(sides);
						output.append("Current Die: " + currentDie.getNumSides() + " sides" + "\n" );
						
					}catch(IllegalArgumentException f) {
						JOptionPane.showMessageDialog(null, ("\"" +numSides.getText() + "\"" + " is not a valid number of sides."));
					}
			}
			
			//ROLL BUTTON
			if(e.getSource() == roll) {
					try {
					numRolls++;
					currentDie.roll();
					output.append("Roll: " + numRolls + " = " + currentDie.getSideUp() + "\n");
					
					sum += currentDie.getSideUp();
					s = (""+sum);
					//TRY CATCH for if user clicks "Roll" before creating a die
					
					}catch(NullPointerException n){numRolls--;} //<-- so that roll count isn't changed }
					
			}
			if(showSum.isSelected())
				sumText.setText(s);		
			
		}
		
	}
	
	public class colourActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(green.isSelected())
				roll.setBackground(Color.green);
			if(red.isSelected())
				roll.setBackground(Color.red);
			if(blue.isSelected())
				roll.setBackground(Color.cyan);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		GooeyDice gui = new GooeyDice();
		gui.setLocationRelativeTo(null);
	}
	
}
