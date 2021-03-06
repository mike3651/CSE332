package Graphical_Interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

//Michael Wilson
//CSE Student project
//Start Date: May 2, 2016
//End Date  : 

/**
 * This class deals with statistics and speed change of the GUI.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class SpeedPanel extends JPanel{
	/** Default serial ID. */
	private static final long serialVersionUID = 1L;
	
	/** Maximum speed. */
	private static final int MAX_SPEED = 5;
	
	/** Increment value. */
	private static final int INCREMENT = 1;
	
	/** The time delay in ms. */
	private static final int TIME_DELAY = 1000;
	
	/** The amount of time that has elapsed. */
	private int timePassed = 0;

	/** The Label of time. */
	private JLabel timePass = new JLabel();
	
	/**
	 * Constructs the panel.
	 */
	public SpeedPanel() {
		// set the layout to border
		super();
		setLayout(new BorderLayout());
		addComponents();
	}
	
	/** 
	 * Method that adds the components.
	 */
	private void addComponents() {
		addSlider();
		addTime();
	}
	
	/** 
	 * Creates and adds a slider to the panel.
	 */
	private void addSlider() {
		// speed up animation
		final JSlider speedUp = new JSlider(JSlider.HORIZONTAL,
											0, MAX_SPEED, 0);
		speedUp.setMajorTickSpacing(INCREMENT);
		speedUp.setPaintTicks(true);
		speedUp.setPaintLabels(true);
		add(speedUp, BorderLayout.SOUTH);
	}
	
	/**
	 * Sets the timing of the program.
	 */
	private void addTime() {
		// create a new timer
		Timer time = new Timer(TIME_DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timePassed++;
				timePass.setText("Time passed: " + timePassed + "s");
			}			
		});
		
		add(timePass, BorderLayout.CENTER);
		time.start();	
	}
	
}
