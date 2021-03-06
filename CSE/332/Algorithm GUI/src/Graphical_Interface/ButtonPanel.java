package Graphical_Interface;

//Michael Wilson
//CSE Student project
//Start Date: May 2, 2016
//End Date  : 

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/** 
 * This class deals with the GUI buttons.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class ButtonPanel extends JPanel {
	/** Default serialization value. */
	private static final long serialVersionUID = 1L;
	
	/** List of the Algorithms */
	private static final String[] ALGORITHMS = {"Insertion", "Selection",
												"Merge", "Heap", "Bubble"};	
	
	/** Private button group. */
	private ButtonGroup myButtons;

	/** 
	 * Creates the algorithm button panel.
	 */
	public ButtonPanel() {
		super();
		setLayout(new GridLayout());
		addButtons();
	}
	
	/**
	 * Method that adds the buttons.
	 */
	private void addButtons() {
		myButtons = new ButtonGroup();
		for (int i = 0; i < ALGORITHMS.length; i++) {
			final AbstractButton temp = new JToggleButton(ALGORITHMS[i]);
			myButtons.add(temp);
			add(temp);
		}
	}
}
