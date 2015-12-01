import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics2D g2d){
		
	}

	public Rectangle2D getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Polygon getBoundsP() {
		// TODO Auto-generated method stub
		return null;
	}

}
