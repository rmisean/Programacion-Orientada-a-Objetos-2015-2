import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Missile extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Missile(int x, int y) {
		super(x, y);
	}
	
	public void update(){
		y -= 3;
		if(this.y < -25){
			GamePanel.removeMissile(this);
		}
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getMissileImg(), x, y, null);
	}
	
	public Image getMissileImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("missile.png"));
		return ic.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getMissileImg().getWidth(null),getMissileImg().getHeight(null));
	}
}
