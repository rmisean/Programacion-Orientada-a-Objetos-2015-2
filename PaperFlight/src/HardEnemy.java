import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class HardEnemy extends Enemy{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int lifes = 2;
	
	public HardEnemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += 2;
		checkCollisions();
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getHEnemyImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getHEnemyImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("henemy.png"));
		return ic.getImage();
	}
	
	public void checkCollisions(){
		for (int i = 0; i < GamePanel.getMissileList().size(); i++) {
			Missile m = GamePanel.getMissileList().get(i);
			
			if(getBounds().intersects(m.getBounds())){
				if(lifes != 0){
					lifes = lifes - 1;
					GamePanel.removeMissile(m);
				}else{
					GamePanel.removeHEnemy(this);
					GamePanel.removeMissile(m);
					GamePanel.totalScore+=400;
				}
			}
		}
		for (int i = 0; i < GamePanel.getBestMissileList().size(); i++) {
			BestMissiles bm = GamePanel.getBestMissileList().get(i);
			
			if(getBounds().intersects(bm.getBounds())){
				if(lifes != 0){
					lifes = lifes - 1;
					bm.lifes--;
					if(bm.lifes == 0){
						GamePanel.removeBestMissile(bm);
					}
				}else{
					GamePanel.removeHEnemy(this);
					bm.lifes--;
					if(bm.lifes == 0){
						GamePanel.removeBestMissile(bm);
					}
					GamePanel.totalScore+=400;
				}
			}
		}
		
	}
	
	public void checkOffScreen(){
		if (y >= 680)
			y = startY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getHEnemyImg().getWidth(null),getHEnemyImg().getHeight(null));
	}
}
