import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int velX = 0;
	int speed = 3;
	int lifes = 2;
	int check = 2;
	int delay = 0;
	boolean moreWeapons = false;
	boolean weaponsUp = false;
	User u = AccountPanel.u;

	public Player(int x, int y) {
		super(x, y);
	}

	public void update() {
		x += velX;
		checkColissions();
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null);
		//g2d.draw(getBounds());
	}

	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("plane.png"));
		return ic.getImage();
	}

	public Image getHeartImg() {
		ImageIcon ic = new ImageIcon(ResourceLoader.getImage("heart.png"));
		return ic.getImage();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
			if(x < 2){
				velX = 0;
			}else{
				velX = -speed;
			}
		} else if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
			if(x > 401){
				velX = 0;
			}else{
				velX = speed;
			}
		} else if (key == KeyEvent.VK_SPACE){
			addMissile();			
		} else if (key == KeyEvent.VK_ESCAPE){
			GameFrame.pauseOn();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT)) {
			velX = 0;
		} else if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT)) {
			velX = 0;
		} else if (key == KeyEvent.VK_SPACE){
			delay = 0;
		}

	}

	public Polygon getBoundsP() {
		Polygon t = new Polygon(new int[] {x+2, x+(getPlayerImg().getWidth(null)/2), (x+getPlayerImg().getWidth(null))-2}, new int[] {(y+getPlayerImg().getHeight(null))-3, y, (y+getPlayerImg().getHeight(null))-3}, 3); 
		return t;
	}
	
	/*
	 * Notas de versión final
	 * 
	 * Los 3 for correspondientes a los 3 tipos de enemigos se han cambiado por uno solo
	 * que representa un arraylist de entidades. Para que asi al añadir un nuevo enemigo
	 * solo se tiene que llamar a entites.addAll(Inserte aqui arraylist de enemigos);
	 * y evitar la redundancia de codigo, empleando correctamente herencia.
	 * 
	 * Dada la posibilidad de que haya un score negativo, se ha arreglado
	 * en la clase GamePanel linea 334.
	 * 
	 * Dado que se podia eliminar un enemigo si este aparecer en la pantalla, se ha añadido
	 * que si la posición del misil en y es -(alto de la imagen), este misil se debe eliminar.
	 * Arreglado en la clase Missile linea 21 y la clase BestMissile linea 23.
	 * 
	 */

	public void checkColissions(){
		ArrayList<Entity> entities = new ArrayList<>();
		entities.addAll(GamePanel.getEnemyList());
		entities.addAll(GamePanel.getHEnemyList());
		entities.addAll(GamePanel.getSEnemyList());
		Random rand = new Random();
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if(getBoundsP().intersects(e.getBounds())){
				if(lifes == 0){
					User.organizeHighScore(u, GamePanel.totalScore);
					GameFrame.newScore();
					User.saveUser(u);
					GameFrame.removeCard("game");
					JOptionPane.showMessageDialog(null, "Fin del juego\nHas llegado hasta el nivel " + GamePanel.level + "\nPuntos: " + GamePanel.totalScore);
					GameFrame.menuOn();
					
				}else{
					lifes = lifes - 1;
					moreWeapons = false;
					weaponsUp = false;
					int n = GamePanel.getEnemyList().size();
					int h = GamePanel.getHEnemyList().size();
					int s = GamePanel.getSEnemyList().size();
					GamePanel.sEnemies.clear();
					GamePanel.hEnemies.clear();
					GamePanel.enemies.clear();
					GamePanel.weaponsUps.clear();
					for (int j = 0; j < n/2; j++) {
						GamePanel.addEnemy(new Enemy(rand.nextInt(400), -100 + -rand.nextInt(600)));
					}
					for (int j = 0; j < h/2; j++) {
						GamePanel.addHEnemy(new HardEnemy(rand.nextInt(400), -100 + -rand.nextInt(600)));
					}
					for (int j = 0; j < s/2; j++) {
						GamePanel.addSEnemy(new SuperEnemy(rand.nextInt(400), -100 + -rand.nextInt(600)));
					}
				}
			}
		}
		
		ArrayList<LifeUp> lifeUps = GamePanel.getLifeUpsList();
		for (int i = 0; i < lifeUps.size(); i++) {
			LifeUp lf = lifeUps.get(i);
			if(getBoundsP().intersects(lf.getBounds())){
				GamePanel.removeLifeUps(lf);
				if(lifes < 9){
					lifes++;
				}
			}
		}
		ArrayList<WeaponUp> weaponUps = GamePanel.getWeaponUpsList();
		for (int i = 0; i < weaponUps.size(); i++) {
			WeaponUp wu = weaponUps.get(i);
			if(getBoundsP().intersects(wu.getBounds())){
				if(moreWeapons == false){
					GamePanel.removeWeaponUps(wu);
					moreWeapons = true;
				}else{
					if(weaponsUp == false){
						GamePanel.removeWeaponUps(wu);
						weaponsUp = true;
					}
				}
			}
		}
	}
	
	public void addMissile(){
		
		if((moreWeapons == false) && (weaponsUp == false)){
			if(delay == 0){
				GamePanel.addMissile(new Missile(x + (getPlayerImg().getWidth(null)/ 2) - 12, y));
				delay = 1;
			}
		}else if((moreWeapons == true) && (weaponsUp == false)){
			if(delay == 0){
				GamePanel.addMissile(new Missile(x + (getPlayerImg().getWidth(null)/ 4) - 12, y));
				GamePanel.addMissile(new Missile(x + (3*(getPlayerImg().getWidth(null)/ 4)) - 12, y));
				delay = 1;
			}	
		}else if((moreWeapons == true) && (weaponsUp == true)){
			if(delay == 0){
				GamePanel.addBestMissile(new BestMissiles(x + (getPlayerImg().getWidth(null)/ 4) - 12, y));
				GamePanel.addBestMissile(new BestMissiles(x + (3*(getPlayerImg().getWidth(null)/ 4)) - 12, y));
				delay = 1;
			}
		}
	}

}