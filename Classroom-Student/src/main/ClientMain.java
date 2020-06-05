package main;

import main.gui.Window;
import main.net.ClassroomClient;

public class ClientMain {
	
	static Window window;
	static ClassroomClient client;
	
	public static void main(String[] args){
		window = new Window();
		client = new ClassroomClient(window.getName());
		window.getRaiseHandButton().addActionListener(client);
		client.addDrawEventListener(window.getCanvas());
		client.start();
	}

}
