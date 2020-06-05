package main.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoBar extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	
	private JPanel btnPanel;
	private JButton raiseHandBtn;
	
	private JPanel numPanel;
	private JLabel numDescLabel, numOfShapesLabel;
	
	public InfoBar(String name) {
		this.setLayout(new BorderLayout());
		
		String lblStr;
		if(name.length() > 15) lblStr = "Name: " + name.substring(0, 15) + "...";
		else lblStr = "Name: " + name;
		nameLabel = new JLabel(lblStr);
		this.add(nameLabel, BorderLayout.WEST);
		
		btnPanel = new JPanel();
		raiseHandBtn = new JButton("Raise Hand");
		btnPanel.add(raiseHandBtn);
		this.add(btnPanel, BorderLayout.CENTER);
		
		
		numPanel = new JPanel();
		numDescLabel = new JLabel("Number of shapes:");
		numOfShapesLabel = new JLabel( "0");
		
		numPanel.add(numDescLabel);
		numPanel.add(numOfShapesLabel);
		this.add(numPanel, BorderLayout.EAST);
	}

	public void setNumberLabel(int i) {
		numOfShapesLabel.setText(String.valueOf(i));
	}
	
	public JButton getButton() {
		return raiseHandBtn;
	}
	
}
