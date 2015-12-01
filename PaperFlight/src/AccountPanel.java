

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AccountPanel extends JPanel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static User u;
    
    Cipher desCipher;
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		AccountPanel.u = u;
	}

	public AccountPanel() {
		this.setLayout(null);
		
		JLabel login = new JLabel("Ingrese datos de la cuenta");
		login.setFont(new Font("MV Boli", Font.PLAIN, 20));
		login.setBounds(99, 127, 267, 35);
		add(login);
		
		JLabel us = new JLabel("Usuario");
		us.setFont(new Font("MV Boli", Font.PLAIN, 20));
		us.setBounds(99, 173, 70, 22);
		add(us);
		
		JLabel ps = new JLabel("Contrase\u00F1a");
		ps.setFont(new Font("MV Boli", Font.PLAIN, 20));
		ps.setBounds(99, 215, 108, 22);
		add(ps);
		
		JTextField usField = new JTextField();
		usField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		usField.setBounds(217, 173, 143, 20);
		add(usField);
		usField.setColumns(10);
		
		JPasswordField psField = new JPasswordField();
		psField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		psField.setBounds(217, 219, 143, 20);
		add(psField);
		
		JButton log = new JButton("Ingresar");
		log.setFont(new Font("MV Boli", Font.PLAIN, 14));
		log.setBounds(42, 269, 89, 23);
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String us = usField.getText();
				String ps = new String(psField.getPassword());

			    if (us.isEmpty() || ps.isEmpty()){
			            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			    }

			    
			    
			    ArrayList<String> udb = UserDB.load();
			    if(udb.size() == 0){
			    	JOptionPane.showMessageDialog(null, "Usuario no registrado.\nIntente Otra vez.", "Error ", JOptionPane.ERROR_MESSAGE);
			    }else{
			    	boolean exist = false;
				    for (String s : udb) {
				    	if (us.equals(s)){
				    		u = User.loadUser(us);
						    if (u.getPassword().equals(ps)){
						    	GameFrame.menuOn();
						    }else{
						    	JOptionPane.showMessageDialog(null, "Usuario o contraseña erroneos.", "Error ", JOptionPane.ERROR_MESSAGE);
						    }
					    	exist = true;
					    	break;
					    }
					}
				    if(exist == false){
				    	JOptionPane.showMessageDialog(null, "Usuario no registrado.\nIntente Otra vez.", "Error ", JOptionPane.ERROR_MESSAGE);
				    }
			    }
			    
			}
		});
		add(log);
		
		JButton nw = new JButton("Nuevo");
		nw.setFont(new Font("MV Boli", Font.PLAIN, 14));
		nw.setBounds(141, 269, 89, 23);
		nw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String us = usField.getText();
				String ps = new String(psField.getPassword());

			    if (us.isEmpty() || ps.isEmpty()){
			            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			    }

			    
			    ArrayList<String> udb = UserDB.load();
			    if(udb.size() == 0){
			    	u = new User(us, ps);
			    	u.setsFirst(0);
			    	u.setsSecond(0);
			    	u.setsThird(0);
			    	User.saveUser(u);
			    	udb.add(us);
			    	UserDB.save(udb);
			        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.", "Ok ", JOptionPane.INFORMATION_MESSAGE);
			        GameFrame.menuOn();
			    }else{
			    	boolean exist = false;
				    for (String s : udb) {
				    	if (us.equals(s)){
					    	JOptionPane.showMessageDialog(null, "Usuario ya registrado.\nIntente Otra vez.", "Error ", JOptionPane.ERROR_MESSAGE);
					    	exist = true;
					    	break;
					    }
					}
				    if(exist == false){
				    	u = new User(us, ps);
				    	User.saveUser(u);
				    	udb.add(us);
				    	UserDB.save(udb);
				        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.", "Ok ", JOptionPane.INFORMATION_MESSAGE);
				        GameFrame.menuOn();
				    }
			    }
			    
			}
		});
		add(nw);
		
		JButton ex = new JButton("Salir");
		ex.setFont(new Font("MV Boli", Font.PLAIN, 14));
		ex.setBounds(376, 269, 89, 23);
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
		
		JButton btnGlobalScores = new JButton("Global Scores");
		btnGlobalScores.setFont(new Font("MV Boli", Font.PLAIN, 14));
		btnGlobalScores.setBounds(240, 269, 126, 23);
		btnGlobalScores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					GameFrame.newGlobalScores();
					GameFrame.globalScoresOn();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		add(btnGlobalScores);
	}
	
	public byte[] encode(String s){
		 // Initialize the cipher for encryption
	    try {
	    	
	    	KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	        SecretKey myDesKey = keygenerator.generateKey();
			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	    //sensitive information
	    byte[] text = s.getBytes();
	   
	    // Encrypt the text
	    byte[] textEncrypted = null;
		try {
			textEncrypted = desCipher.doFinal(text);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

	    return textEncrypted;
	}
	
	public String decode(byte[] textEncrypted){
		 // Initialize the same cipher for decryption
	    try {
	    	
	    	KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	        SecretKey myDesKey = keygenerator.generateKey();
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	    // Decrypt the text
	    byte[] textDecrypted = null;
		try {
			textDecrypted = desCipher.doFinal(textEncrypted);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	    
	    return new String(textDecrypted);
	}
	
}
