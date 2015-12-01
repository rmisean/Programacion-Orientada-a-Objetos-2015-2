

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScorePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User u = AccountPanel.u;

	
	public ScorePanel() {
		
		setLayout(null);
		JButton ex = new JButton("Atras");
		ex.setFont(new Font("MV Boli", Font.PLAIN, 24));
		ex.setBounds(130, 399, 217, 63);
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameFrame.menuOn();
			}
		});
		add(ex);
		
		JLabel lblPaperFlight = new JLabel("High Scores");
		lblPaperFlight.setForeground(new Color(0, 0, 0));
		lblPaperFlight.setFont(new Font("MV Boli", Font.BOLD, 61));
		lblPaperFlight.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaperFlight.setBounds(10, 26, 464, 116);
		add(lblPaperFlight);
		
		JLabel lblNewLabel = new JLabel("1.  " + String.valueOf(u.getsFirst()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
		lblNewLabel.setBounds(37, 164, 395, 39);
		add(lblNewLabel);
		
		JLabel lblDDerecha = new JLabel("2.  " + String.valueOf(u.getsSecond()));
		lblDDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblDDerecha.setFont(new Font("MV Boli", Font.PLAIN, 22));
		lblDDerecha.setBounds(37, 214, 395, 39);
		add(lblDDerecha);
		
		JLabel lblEspacioDisparar = new JLabel("3.  " + String.valueOf(u.getsThird()));
		lblEspacioDisparar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspacioDisparar.setFont(new Font("MV Boli", Font.PLAIN, 22));
		lblEspacioDisparar.setBounds(37, 264, 395, 39);
		add(lblEspacioDisparar);
		
	}
	
}
