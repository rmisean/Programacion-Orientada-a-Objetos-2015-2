import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class BestMissiles extends Missile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int lifes = 3;
	
	public BestMissiles(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y -= 4;
		if(this.y < -35){
			GamePanel.removeBestMissile(this);
		}
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getBestMissileImg(), x, y, null);
	}
	
	public Image getBestMissileImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("bestmissile.png"));
		return ic.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getBestMissileImg().getWidth(null),getBestMissileImg().getHeight(null));
	}

}
