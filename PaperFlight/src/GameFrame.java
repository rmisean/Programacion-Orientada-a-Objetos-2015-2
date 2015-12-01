
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameFrame extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static CardLayout cardLayout;
    static JPanel mainPanel;
    AccountPanel account;
    MenuPanel menu;
    GamePanel game;
    ScorePanel score;
    PausePanel pause;
    GlobalScoresPanel globalScores;
    
    public GameFrame() {
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		setLayout(new BorderLayout());
		account = new AccountPanel();
		menu = new MenuPanel();
		pause = new PausePanel();
		mainPanel.add(account,"account");
		mainPanel.add(menu, "menu");
		mainPanel.add(pause, "pause");
		add(mainPanel);
		setVisible(true);
	}
    
    public static JPanel getCurrentCard()
    {
        JPanel card = null;
        for (Component comp : mainPanel.getComponents() ) {
            if (comp.isVisible() == true) {
                card = (JPanel)comp;
            }
        }
        return card;
    }
    
    public static void removeCard(String s){
    	try {
    		for (Component comp : mainPanel.getComponents() ) {
        		if(comp.getName().equals(s)){
    	            mainPanel.remove(comp);
    	            cardLayout.removeLayoutComponent(comp);
        		}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    }
    
    public static void newGame(){
    	try {
    		for (Component comp : mainPanel.getComponents() ) {
        		if(comp.getName().equals("game")){
    	            mainPanel.remove(comp);
    	            cardLayout.removeLayoutComponent(comp);
        		}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    	
    	GamePanel game = new GamePanel(205, 440, 0);
		mainPanel.add(game);
		cardLayout.addLayoutComponent(game, "game");
		mainPanel.validate();
    }
    
    public static void newScore(){
    	try {
    		for (Component comp : mainPanel.getComponents() ) {
        		if(comp.getName().equals("score")){
    	            mainPanel.remove(comp);
    	            cardLayout.removeLayoutComponent(comp);
        		}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    	
    	ScorePanel score = new ScorePanel();
		mainPanel.add(score);
		cardLayout.addLayoutComponent(score, "score");
		mainPanel.validate();
    }
    
    public static void newGlobalScores(){
    	try {
    		for (Component comp : mainPanel.getComponents() ) {
        		if(comp.getName().equals("globalScore")){
    	            mainPanel.remove(comp);
    	            cardLayout.removeLayoutComponent(comp);
        		}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    	
    	GlobalScoresPanel globalScores = new GlobalScoresPanel();
		mainPanel.add(globalScores);
		cardLayout.addLayoutComponent(globalScores, "globalScores");
		mainPanel.validate();
    }
    
    public static void reanudeGame(User u){
    	try {
    		for (Component comp : mainPanel.getComponents() ) {
        		if(comp.getName().equals("game")){
    	            mainPanel.remove(comp);
    	            cardLayout.removeLayoutComponent(comp);
        		}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    	
    	GamePanel game = new GamePanel(u);
		mainPanel.add(game);
		cardLayout.addLayoutComponent(game, "game");
		mainPanel.validate();
    }
    
    public static void menuOn() {
        cardLayout.show(mainPanel, "menu");
    }
    
    public static void accountOn() {
        cardLayout.show(mainPanel, "account");
    }
    
    public static void gameOn() {
        cardLayout.show(mainPanel, "game");
    }
    
    public static void pauseOn() {
        cardLayout.show(mainPanel, "pause");
    }
    
    public static void scoreOn() {
        cardLayout.show(mainPanel, "score");
    }
    
    public static void globalScoresOn() {
        cardLayout.show(mainPanel, "globalScores");
    }
	
	public void actionPerformed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
