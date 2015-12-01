
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		File file = new File("./UDB.pf");
		if(!file.exists()) {
		    try {
				file.createNewFile();
				UserDB.save(new ArrayList<>());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			GameFrame gameFrame = new GameFrame();
        	JFrame frame = new JFrame("PaperFlight");
        	frame.setSize(500, 600);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setResizable(false);
        	frame.add(gameFrame, BorderLayout.CENTER);
        	frame.setVisible(true);
        	frame.setLocationRelativeTo(null);
        	
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		} 	
	}
}
