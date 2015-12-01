import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class LifeUp extends Enemy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LifeUp(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += 1;
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getLifeUpImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getLifeUpImg(){
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("lifeup.png"));
		return ic.getImage();
	}
	
	public void checkOffScreen(){
		if (y >= 680)
			y = startY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getLifeUpImg().getWidth(null),getLifeUpImg().getHeight(null));
	}
	
}
