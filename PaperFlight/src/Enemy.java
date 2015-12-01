import java.awt.*;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Enemy extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int startY;
	
	public Enemy(int x, int y) {
		super(x, y);
		startY = y;
	}
	
	public void update(){
		y += 1;
		checkCollisions();
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getEnemyImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getEnemyImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("enemy.png"));
		return ic.getImage();
	}
	
	public void checkCollisions(){
		for (int i = 0; i < GamePanel.getMissileList().size(); i++) {
			Missile m = GamePanel.getMissileList().get(i);
			
			if(getBounds().intersects(m.getBounds())){
				GamePanel.removeEnemy(this);
				GamePanel.removeMissile(m);
				GamePanel.totalScore+=200;
			}
		}
		
		for (int i = 0; i < GamePanel.getBestMissileList().size(); i++) {
			BestMissiles bm = GamePanel.getBestMissileList().get(i);
			
			if(getBounds().intersects(bm.getBounds())){
				GamePanel.removeEnemy(this);
				bm.lifes--;
				if(bm.lifes == 0){
					GamePanel.removeMissile(bm);
				}
				GamePanel.totalScore+=200;
			}
		}
	}
	
	public void checkOffScreen(){
		if (y >= 680)
			y = startY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getEnemyImg().getWidth(null),getEnemyImg().getHeight(null));
	}
	
}
