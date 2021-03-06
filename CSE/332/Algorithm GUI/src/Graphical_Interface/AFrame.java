package Graphical_Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;

//Michael Wilson
//CSE Student project
//Start Date: May 2, 2016
//End Date  : 

import javax.swing.JFrame;

/** 
 * This class constructs the window frame for the program.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class AFrame extends JFrame{
	/** This is a default serialization version for compression. */
	private static final long serialVersionUID = 1L;
	
	/** Minimum Dimension of the frame. */
	private static final Dimension SIZE = new Dimension(450, 450);

	public AFrame() {
		super("Algorithms");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(SIZE);
		
		// sets the menu bar
		setJMenuBar(new AMenu());
		
		// add the statistics panel
		add(new SpeedPanel(), BorderLayout.EAST);
		
		// add the algorithm panel
		add(new AlgorithmPanel(), BorderLayout.CENTER);
		
		// add the button panel at the bottom of the GUI
		add(new ButtonPanel(), BorderLayout.SOUTH);			
		
		pack();
		setVisible(true);
	}
}
