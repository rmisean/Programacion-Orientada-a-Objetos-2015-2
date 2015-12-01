import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class SuperEnemy extends Enemy{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random r = new Random();
	int lifes = r.nextInt(10 - 4 + 1) + 4;
	
	public SuperEnemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += 1;
		checkCollisions();
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getSEnemyImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getSEnemyImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("senemy.png"));
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
					GamePanel.removeSEnemy(this);
					GamePanel.removeMissile(m);
					GamePanel.totalScore+=1000;
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
					GamePanel.removeSEnemy(this);
					bm.lifes--;
					if(bm.lifes == 0){
						GamePanel.removeBestMissile(bm);
					}
					GamePanel.totalScore+=1000;
				}
			}
		}
		
	}
	
	public void checkOffScreen(){
		if (y >= 680)
			y = startY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getSEnemyImg().getWidth(null),getSEnemyImg().getHeight(null));
	}
	
}
