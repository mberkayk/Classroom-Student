package main.net;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import main.event.DrawEvent;
import main.event.DrawEventAnouncer;
import main.gui.board.shapes.ShapeType;

public class ClassroomClient implements DrawEventAnouncer, ActionListener  {
	
	private final int PORT = 5500;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public ClassroomClient(String name) {
		try {
			clientSocket = new Socket("localhost", PORT);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println(name);	
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void start() {
		while(true) {
			try {
				String msg = in.readLine();
				if(msg != null) {
					String[] pars = msg.split(" ");
					ShapeType st = null;
					if(pars[0].contentEquals("ELLIPSE")) {
						st = ShapeType.ELLIPSE;
					}else if(pars[0].contentEquals("RECT")) {
						st = ShapeType.RECT;
					}else if(pars[0].contentEquals("LINE")) {
						st = ShapeType.LINE;
					}else if(pars[0].contentEquals("ERASER")) {
						st = ShapeType.ERASER;
					}
					this.drawEvent(new DrawEvent(st, Integer.valueOf(pars[1]), 
							Integer.valueOf(pars[2]), Integer.valueOf(pars[3]), Integer.valueOf(pars[4])));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Raise Hand")) {
			out.println("Raise Hand");
		}
		
	}
	
	
	
}
