package Graphical_Interface;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;

//Michael Wilson
//CSE Student project
//Start Date: May 2, 2016
//End Date  : 

/** 
 * This class will deal with the menu options.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class AMenu extends JMenuBar {

	/** Default serial number. */
	private static final long serialVersionUID = 1L;
	
	/** Maximum speed. */
	private static final int MAX_SPEED = 5;
	
	/** Increment value. */
	private static final int INCREMENT = 1;
	
	/**
	 * Constructs the menu bar.
	 */
	public AMenu() {
		buildBar();
	}
	
	/**
	 * Private method that helps construct the menu bar.
	 */
	private void buildBar() {
		firstMenu();
		secondMenu();
		thirdMenu();
	}
	
	/**
	 * The first menu.
	 */
	private void firstMenu() {
		final JMenu first = new JMenu("File");
		first.setMnemonic(KeyEvent.VK_F);
		first.getAccessibleContext().setAccessibleDescription(
		        "Has standard file choices");
		addFileOptions(first);
		add(first);
	}
	
	/**
	 * Private helper method that adds the file options.
	 * 
	 * @param theMenu The appropriate menu to add to.
	 */
	private void addFileOptions(final JMenu theMenu) {
		// pause
		final JMenuItem pause = new JMenuItem("Pause", KeyEvent.VK_P);
		theMenu.add(pause);
		
		theMenu.addSeparator();
		
		// quit
		final JMenuItem quit = new JMenuItem("Quit", KeyEvent.VK_Q);
		theMenu.add(quit);
	}
	
	/**
	 * The second menu.
	 */
	private void secondMenu() {
		final JMenu second = new JMenu("Options");
		second.setMnemonic(KeyEvent.VK_O);
		second.getAccessibleContext().setAccessibleDescription(
		        "Allows you to modify the looks");
		addOptions(second);
		add(second);
	}
	
	/**
	 * Private helper method that adds the file options.
	 * 
	 * @param theMenu The appropriate menu to add to.
	 */
	private void addOptions(final JMenu theMenu) {
		// speed up animation
		final JSlider speedUp = new JSlider(JSlider.HORIZONTAL,
								0, MAX_SPEED, 0);
		speedUp.setMajorTickSpacing(INCREMENT);
		speedUp.setPaintTicks(true);
		speedUp.setPaintLabels(true);
		final JMenuItem speed = new JMenuItem("Speed");
		speed.add(speedUp);
		theMenu.add(speed);
	}
	
	/**
	 * The third menu.
	 */
	private void thirdMenu() {
		final JMenu third = new JMenu("Extra");
		third.setMnemonic(KeyEvent.VK_E);
		third.getAccessibleContext().setAccessibleDescription(
		        "Extra features");
		add(third);
	}
	
}
