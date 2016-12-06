import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * RandomizerWindow.java - Sets up the GUI of the Randomizer program,
 * creating the main window and setting listeners for the text field and buttons
 * to allow a user to input a number of files to generate or exit the program.
 * Once a valid number of files is entered, pressing the "Run" button will then
 * create the input number of files.
 *
 * @author Justin Watts
 * @version 03/22/2016
 */
public class RandomizerWindow
{
	private JFrame main, result;
	private JPanel instructionPanel, inputPanel, buttonPanel, messagePanel, resultButtonPanel;
	private JTextField textField;
	private JLabel label, resultLabel;
	private JButton run, exit, okay;
	
	/**
	 * Constructor for the RandomizerWindow class. Sets up the elements of
	 * the Randomizer GUI.
	 */
	public RandomizerWindow()
	{
		this.main = new JFrame("Film Challenge Randomizer");
		this.result = new JFrame("Result");
		
		this.instructionPanel = new JPanel();
		this.inputPanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.messagePanel = new JPanel();
		this.resultButtonPanel = new JPanel();
		
		this.label = new JLabel("Input Number of Combinations");
		this.resultLabel = new JLabel("Complete");

		this.textField = new JTextField(6);
		
		this.run = new JButton("Run");
		this.exit = new JButton("Exit");
		this.okay = new JButton("OK");
	}
	
	/**
	 * Displays a window indicating that files have been created successfully.
	 */
	private void createDoneFrame()
	{
		result.setLayout(new BorderLayout());
		result.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		result.setLocation(945, 350);
		
		messagePanel.setLayout(new FlowLayout());
		messagePanel.setBorder(BorderFactory.createEmptyBorder(15, 18, 10, 18));
		resultButtonPanel.setLayout(new FlowLayout());
		
		okay.addActionListener(new ActionListener()
		{
			/**
			 * Closes the window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				result.dispose();
			}
		});
        
		resultLabel.setText("Complete");
		messagePanel.add(resultLabel);
		resultButtonPanel.add(okay);
		
		result.add(messagePanel, BorderLayout.CENTER);
		result.add(resultButtonPanel, BorderLayout.SOUTH);
		result.setResizable(false);
		result.pack();
		result.setVisible(true);
	}
	
	/**
	 * Displays a window indicating that invalid input was entered.
	 */
	private void createErrorFrame()
	{
		result.setLayout(new BorderLayout());
		result.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		result.setLocation(945, 350);
		
		messagePanel.setLayout(new FlowLayout());
		messagePanel.setBorder(BorderFactory.createEmptyBorder(15, 18, 10, 18));
		resultButtonPanel.setLayout(new FlowLayout());
		
		okay.addActionListener(new ActionListener()
		{
			/**
			 * Closes the window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				result.dispose();
			}
		});
        
		resultLabel.setText("Invalid Input. Please input a positive integer.");
		messagePanel.add(resultLabel);
		resultButtonPanel.add(okay);
		
		result.add(messagePanel, BorderLayout.CENTER);
		result.add(resultButtonPanel, BorderLayout.SOUTH);
		result.setResizable(false);
		result.pack();
		result.setVisible(true);
	}
	
	/**
	 * Begins the Randomizer program by displaying the main window
	 * of the program and adding action listeners to various buttons
	 * in order to read in the number of files to generate, generate
	 * said files, and exit the program.
	 */
	public void start()
	{
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocation(925, 300);
		main.setPreferredSize(new Dimension(260, 130));
		
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
		buttonPanel.setLayout(new FlowLayout());
		
		run.addActionListener(new ActionListener()
		{
			/**
			 * Sets an action listener for the "Run" button to generate the input
			 * number of files should the input number be valid. If the process
			 * completed successfully, a box indicating this will appear. If not,
			 * a box indicating invalid input will appear.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if ((textField.getText().length() > 0) && (textField.getText().matches("\\d+")))
				{
					int value = Integer.parseInt(textField.getText());
					
					if (value > 0)
					{
						Randomizer randomizer = new Randomizer();
						randomizer.run(value);
						createDoneFrame();
					}
					else
						createErrorFrame();
				}
				else
					createErrorFrame();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for exit button to shut down the
			 * entire program.
			 */
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		main.add(instructionPanel, BorderLayout.NORTH);
		main.add(inputPanel, BorderLayout.CENTER);
		main.add(buttonPanel, BorderLayout.SOUTH);
		
		instructionPanel.add(label);
		inputPanel.add(textField);
		
		buttonPanel.add(run);
		buttonPanel.add(exit);
		
		main.setResizable(false);
		main.pack();
		main.setVisible(true);
	}
}