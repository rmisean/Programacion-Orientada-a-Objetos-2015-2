import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GlobalScoresPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<String> udb = UserDB.load();
	Map<Integer, String> uo = new TreeMap<>();
	
	public GlobalScoresPanel() {
		
		setLayout(null);
		JButton ex = new JButton("Atras");
		ex.setFont(new Font("MV Boli", Font.PLAIN, 24));
		ex.setBounds(130, 399, 217, 63);
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameFrame.accountOn();
			}
		});
		add(ex);
		
		JLabel lblPaperFlight = new JLabel("Global Scores");
		lblPaperFlight.setForeground(new Color(0, 0, 0));
		lblPaperFlight.setFont(new Font("MV Boli", Font.BOLD, 61));
		lblPaperFlight.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaperFlight.setBounds(10, 26, 464, 116);
		add(lblPaperFlight);
		
		for (String usdb : udb) {
			User u = User.loadUser(usdb);
			uo.put(u.getsFirst(), u.getName());
		}
		
		Map<Integer, String> duo = new TreeMap<>(Collections.reverseOrder());
		duo.putAll(uo);
		
		int b = 164;
		for (Map.Entry<Integer, String> entry : duo.entrySet()) {
			JLabel lblNewLabel = new JLabel(entry.getValue()+ ":  " + entry.getKey());
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
			lblNewLabel.setBounds(37, b, 395, 39);
			add(lblNewLabel);
			b = b + 28;
		}
	}
	
}
