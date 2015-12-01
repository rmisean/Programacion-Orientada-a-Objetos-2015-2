import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class WeaponUp extends Enemy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeaponUp(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += 1;
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getWeaponUpImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getWeaponUpImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("wup.png"));
		return ic.getImage();
	}
	
	public void checkOffScreen(){
		if (y >= 680)
			y = startY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getWeaponUpImg().getWidth(null),getWeaponUpImg().getHeight(null));
	}
	
}
