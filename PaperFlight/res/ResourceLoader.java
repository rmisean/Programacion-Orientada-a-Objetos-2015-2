import java.awt.Image;
import java.awt.Toolkit;

public class ResourceLoader {
	
	static ResourceLoader rl = new ResourceLoader();
	
	public static Image getImage(String filename){
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("images/" + filename));
	}
	
}
