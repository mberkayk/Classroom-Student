package main.gui.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.event.DrawEvent;
import main.event.DrawEventListener;
import main.gui.InfoBar;
import main.gui.board.shapes.Ellipse;
import main.gui.board.shapes.Rect;
import main.gui.board.shapes.ShapeType;

public class Canvas extends JPanel implements DrawEventListener {
	private static final long serialVersionUID = 1L;
	
	
	private InfoBar bar;
	
	private ArrayList<Shape> shapes;
	
	public Canvas(InfoBar bar) {
		super();
		this.setPreferredSize(new Dimension(400, 400));
		this.setVisible(true);
		
		this.bar = bar;
		
		shapes = new ArrayList<Shape>();
	}

	@Override
	public void drawEvent(DrawEvent e) {
		System.out.println(e.toString());
		if(e.getType() == ShapeType.RECT) {
			int w = e.getX2() - e.getX1();
			int h = e.getY2() - e.getY1();
			Rect r = new Rect(e.getX1(), e.getY1(), w, h);
			shapes.add(r.shape());
		}else if(e.getType() == ShapeType.ELLIPSE) {
			int w = e.getX2() - e.getX1();
			int h = e.getY2() - e.getY1();
			Ellipse ellipse = new Ellipse(e.getX1(), e.getY1(), w, h);
			shapes.add(ellipse.shape());
		}else if(e.getType() == ShapeType.LINE) {
			shapes.add(new Line2D.Float(e.getX1(), e.getY1(), e.getX2(), e.getY2()));
		}else if(e.getType() == ShapeType.ERASER) {
			shapes.clear();
		}
		this.repaint();
		bar.setNumberLabel(shapes.size());
	}
	
	@Override
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D)(gr);
		//background
		g.setColor(new Color(30, 50, 100)); 
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
		g.setColor(Color.white);
		
		//all the shapes
		for(int i = 0; i < shapes.size(); i++) {
			g.draw(shapes.get(i));
		}
				
	}
	
	public int getNumberOfShapes() {
		return shapes.size();
	}
	
}
