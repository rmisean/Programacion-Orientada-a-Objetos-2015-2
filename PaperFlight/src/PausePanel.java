import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PausePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PausePanel() {
		setLayout(null);
		JButton cont = new JButton("Continuar");
		cont.setFont(new Font("MV Boli", Font.PLAIN, 24));
		cont.setBounds(130, 325, 217, 63);
		cont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameFrame.gameOn();
			}
		});
		add(cont);
		
		JButton ex = new JButton("Salir");
		ex.setFont(new Font("MV Boli", Font.PLAIN, 24));
		ex.setBounds(130, 399, 217, 63);
		ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User.saveUser(AccountPanel.u);
				GameFrame.menuOn();
			}
		});
		add(ex);
		
		JLabel pause = new JLabel("Pausa");
		pause.setForeground(new Color(0, 0, 0));
		pause.setFont(new Font("MV Boli", Font.BOLD, 61));
		pause.setHorizontalAlignment(SwingConstants.CENTER);
		pause.setBounds(10, 26, 464, 116);
		add(pause);
		
		JLabel aiz = new JLabel("A/Flecha Izq: Volar a la Izquierda");
		aiz.setHorizontalAlignment(SwingConstants.CENTER);
		aiz.setFont(new Font("MV Boli", Font.PLAIN, 22));
		aiz.setBounds(37, 164, 395, 39);
		add(aiz);
		
		JLabel dde = new JLabel("D/Flecha Der: Volar a la Derecha");
		dde.setHorizontalAlignment(SwingConstants.CENTER);
		dde.setFont(new Font("MV Boli", Font.PLAIN, 22));
		dde.setBounds(37, 214, 395, 39);
		add(dde);
		
		JLabel esd = new JLabel("Espacio: Disparar");
		esd.setHorizontalAlignment(SwingConstants.CENTER);
		esd.setFont(new Font("MV Boli", Font.PLAIN, 22));
		esd.setBounds(37, 264, 395, 39);
		add(esd);
		if(GameFrame.getCurrentCard() == this)
			this.requestFocusInWindow();
	}

}
