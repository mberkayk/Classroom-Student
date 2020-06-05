package main.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.gui.board.Canvas;

public class GUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BorderLayout layout;
	
	private Canvas canvas;
	private InfoBar infoBar;
	
	public GUI(String name) {
		super();
		layout = new BorderLayout();
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(500, 400));
		
		infoBar = new InfoBar(name);
		canvas = new Canvas(infoBar);
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(infoBar, BorderLayout.SOUTH);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JButton getRaiseHandButton() {
		return infoBar.getButton();
	}
}
