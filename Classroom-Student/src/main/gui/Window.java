package main.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.gui.board.Canvas;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	GUI gui;
	String name;
	
	public Window() {
		super("Classroom Client");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		name = (String)JOptionPane.showInputDialog(this, "Enter Your Name");
		if(name == null) name = "Unnamed";
		
		gui = new GUI(name);
		
		this.add(gui);
		this.pack();

	}
	
	public Canvas getCanvas() {
		return gui.getCanvas();
	}

	public String getName() {
		return name;
	}
	
	public JButton getRaiseHandButton() {
		return gui.getRaiseHandButton();
	}
}
