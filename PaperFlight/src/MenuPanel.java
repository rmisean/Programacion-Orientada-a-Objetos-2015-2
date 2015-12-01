import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean start = false;
	User u = AccountPanel.u;

	public MenuPanel(){
		setLayout(null);
		JLabel welcome = new JLabel("Bienvenido");
		welcome.setFont(new Font("MV Boli", Font.PLAIN, 23));
		welcome.setBounds(20, 127, 267, 35);
		add(welcome);
		
		JButton newGame = new JButton("Nuevo Juego");
		newGame.setFont(new Font("MV Boli", Font.PLAIN, 24));
		newGame.setBounds(130, 173, 217, 63);
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Instrucciones:\n\nA / Flecha Izq: Volar a la izquierda\nD / Flecha Der: Volar a la derecha\nEspacio: Disparar");
				GameFrame.newGame();
				GameFrame.gameOn();
			}
		});
		add(newGame);
		
		JButton reanude = new JButton("Continuar");
		reanude.setFont(new Font("MV Boli", Font.PLAIN, 24));
		reanude.setBounds(130, 247, 217, 63);
		reanude.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					GameFrame.reanudeGame(AccountPanel.u);
					GameFrame.gameOn();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		add(reanude);
		
		JButton ex = new JButton("Salir");
		ex.setFont(new Font("MV Boli", Font.PLAIN, 24));
		ex.setBounds(130, 396, 217, 63);
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(ex);
		
		JLabel title = new JLabel("Paper Flight");
		title.setForeground(new Color(0, 0, 0));
		title.setFont(new Font("MV Boli", Font.BOLD, 61));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 11, 464, 116);
		add(title);
		
		JButton btnHighScores = new JButton("High Scores");
		btnHighScores.setFont(new Font("MV Boli", Font.PLAIN, 24));
		btnHighScores.setBounds(130, 321, 217, 63);
		btnHighScores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameFrame.newScore();
				GameFrame.scoreOn();
			}
		});
		add(btnHighScores);
	}

}
