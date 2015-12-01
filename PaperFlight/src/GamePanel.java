

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User u = AccountPanel.u;
	Timer mainTimer;
	Player player;
	static Chronometer ch = new Chronometer();
	
	static ArrayList<Enemy> enemies = new ArrayList<>();
	static ArrayList<HardEnemy> hEnemies = new ArrayList<>();
	static ArrayList<SuperEnemy> sEnemies = new ArrayList<>();
	static ArrayList<Missile> missiles = new ArrayList<>();
	static ArrayList<BestMissiles> bestMissiles = new ArrayList<>();
	static ArrayList<LifeUp> lifeUps = new ArrayList<>();
	static ArrayList<WeaponUp> weaponsUps = new ArrayList<>();
	
	int enemyCount = 4;
	public static int level = 1;
	static Random rand = new Random();
	public static int totalScore = 0;
	public double time = 0.0;
	
	public static boolean pause = true;
	static int n = 2;
	
	public GamePanel(){
		setFocusable(true);
		
		player = new Player(205,440);
		
		addKeyListener(new KeyAdapt(player));
		
		mainTimer = new Timer(10, this);
		mainTimer.start();
		
		startGame();
		
	}
	
	public GamePanel(int x, int y, int s){
		setFocusable(true);
		
		player = new Player(x,y);
		
		addKeyListener(new KeyAdapt(player));
		enemies.clear();
		hEnemies.clear();
		sEnemies.clear();
		missiles.clear();
		bestMissiles.clear();
		lifeUps.clear();
		weaponsUps.clear();
		level = 1;
		totalScore = 0;
		mainTimer = new Timer(10, this);
		mainTimer.start();
		ch.setClock(0, 0, s);
		startGame();
	}
	
	public GamePanel(User u){
		setFocusable(true);
		
		player = u.getPlayer();
		
		addKeyListener(new KeyAdapt(player));
		enemies = u.getEnemies();
		hEnemies = u.gethEnemies();
		sEnemies = u.getsEnemies();
		lifeUps = u.getLifeUps();
		missiles = u.getMissiles();
		bestMissiles = u.getBestMissiles();
		weaponsUps = u.getWeaponUps();
		level = u.getLevel();
		totalScore = u.getTotalScore();
		mainTimer = new Timer(10, this);
		mainTimer.start();
		int h = u.getSeconds()/3600;
		int m = (u.getSeconds()/60)%60;
		int s = u.getSeconds()%60;
		ch.setClock(h, m, s);
		startGame();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		player.draw(g2d);
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemyT = 	enemies.get(i);
			enemyT.draw(g2d);
		}
		
		for (int i = 0; i < hEnemies.size(); i++) {
			HardEnemy enemyT = 	hEnemies.get(i);
			enemyT.draw(g2d);
		}
		
		for (int i = 0; i < sEnemies.size(); i++) {
			SuperEnemy enemyT = sEnemies.get(i);
			enemyT.draw(g2d);
		}
		
		for (int i = 0; i < missiles.size(); i++) {
			Missile m = missiles.get(i);
			m.draw(g2d);
		}
		
		for (int i = 0; i < bestMissiles.size(); i++) {
			BestMissiles bm = bestMissiles.get(i);
			bm.draw(g2d);
		}
		
		for (int i = 0; i < lifeUps.size(); i++) {
			LifeUp lf = lifeUps.get(i);
			lf.draw(g2d);
		}
		
		for (int i = 0; i < weaponsUps.size(); i++) {
			WeaponUp wu = weaponsUps.get(i);
			wu.draw(g2d);
		}
		
		Font sfont = new Font("Arial", Font.BOLD, 20);
		g2d.setFont(sfont);
		g2d.drawString(String.valueOf(totalScore), 10, 30);
		g2d.drawString(ch.clock(), 400, 30);
		if(player.lifes < 9){
			int xt = 10;
			for (int i = 0; i <= player.lifes; i++) {
				g2d.drawImage(player.getHeartImg(), xt, 40, null);
				xt = xt + 21;
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(GameFrame.getCurrentCard() == this){
			this.requestFocusInWindow();
			pauseUnPauseCh();
			mainTimer.start();
			player.update();
			
			for (int i = 0; i < enemies.size(); i++) {
				Enemy te = enemies.get(i);
				te.update();
			}
			
			for (int i = 0; i < hEnemies.size(); i++) {
				HardEnemy te = hEnemies.get(i);
				te.update();
			}
			
			for (int i = 0; i < sEnemies.size(); i++) {
				SuperEnemy te = sEnemies.get(i);
				te.update();
			}
			
			for (int i = 0; i < missiles.size(); i++) {
				Missile m = missiles.get(i);
				m.update();
			}
			
			for (int i = 0; i < bestMissiles.size(); i++) {
				BestMissiles bm = bestMissiles.get(i);
				bm.update();
			}
			
			for (int i = 0; i < lifeUps.size(); i++) {
				LifeUp lf = lifeUps.get(i);
				lf.update();
			}
			
			for (int i = 0; i < weaponsUps.size(); i++) {
				WeaponUp we = weaponsUps.get(i);
				we.update();
			}
			repaint();
			levelUp();
			
		}else{
			
		}
		u.setEnemies(enemies);
		u.sethEnemies(hEnemies);
		u.setsEnemies(sEnemies);
		u.setLifeUps(lifeUps);
		u.setMissiles(missiles);
		u.setBestMissiles(bestMissiles);
		u.setWeaponUps(weaponsUps);
		u.setLevel(level);
		u.setTotalScore(totalScore);
		u.setPlayer(player);
		u.setSeconds(ch.getSeconds());
		User.saveUser(u);
	}
	
	public static void addEnemy(Enemy e){
		enemies.add(e);
	}
	
	public static void removeEnemy(Enemy e){
		enemies.remove(e);
	}
	
	public static ArrayList<Enemy> getEnemyList(){
		return enemies;
	}
	
	public static void addHEnemy(HardEnemy e){
		hEnemies.add(e);
	}
	
	public static void removeHEnemy(HardEnemy e){
		hEnemies.remove(e);
	}
	
	public static ArrayList<HardEnemy> getHEnemyList(){
		return hEnemies;
	}
	
	public static void addSEnemy(SuperEnemy e){
		sEnemies.add(e);
	}
	
	public static void removeSEnemy(SuperEnemy e){
		sEnemies.remove(e);
	}
	
	public static ArrayList<SuperEnemy> getSEnemyList(){
		return sEnemies;
	}
	
	public static void addMissile(Missile m){
		missiles.add(m);
	}
	
	public static void removeMissile(Missile m){
		missiles.remove(m);
	}
	
	public static ArrayList<Missile> getMissileList(){
		return missiles;
	}
	
	public static void addBestMissile(BestMissiles bm){
		bestMissiles.add(bm);
	}
	
	public static void removeBestMissile(BestMissiles bm){
		bestMissiles.remove(bm);
	}
	
	public static ArrayList<BestMissiles> getBestMissileList(){
		return bestMissiles;
	}
	
	public static void addLifeUps(LifeUp lf){
		lifeUps.add(lf);
	}
	
	public static void removeLifeUps(LifeUp lf){
		lifeUps.remove(lf);
	}
	
	public static ArrayList<LifeUp> getLifeUpsList(){
		return lifeUps;
	}
	
	public static void addWeaponUps(WeaponUp wu){
		weaponsUps.add(wu);
	}
	
	public static void removeWeaponUps(WeaponUp wu){
		weaponsUps.remove(wu);
	}
	
	public static  ArrayList<WeaponUp> getWeaponUpsList(){
		return weaponsUps;
	}
	
	public void startGame(){
		enemyCount = level*4;
		for (int i = 0; i < enemyCount; i++) {
			addEnemy(new Enemy(rand.nextInt(400), -100 + -rand.nextInt(600 + (100*level))));
		}
		if(level != 1){
			for (int i = 0; i < level+rand.nextInt(2); i++) {
				addHEnemy(new HardEnemy(rand.nextInt(400), -100 + -rand.nextInt(600 + (100*level))));
			}
		}
		if(level % 5 == 0){
			for (int i = 0; i < level+rand.nextInt(4); i++) {
				addSEnemy(new SuperEnemy(rand.nextInt(400), -100 + -rand.nextInt(600 + (100*level))));
			}
		}
		if(level % 3 == 0){
			for (int i = 0; i < 1+rand.nextInt(1); i++) {
				addLifeUps(new LifeUp(rand.nextInt(400), -100 + -rand.nextInt(600 + (100*level))));
			}
		}
		if(level % 2 == 0){
			for (int i = 0; i < 1+rand.nextInt(1); i++) {
				addWeaponUps(new WeaponUp(rand.nextInt(400), -100 + -rand.nextInt(600 + (100*level))));
			}
		}
	}

	public void levelUp(){
		if(enemies.size() == 0 && hEnemies.size() == 0 && sEnemies.size() == 0){
			totalScore+=(200-(ch.getSecondsScore()*10));
			if(totalScore < 0)
				totalScore = 0;
			level += 1;
			enemies.clear();
			hEnemies.clear();
			sEnemies.clear();
			missiles.clear();
			bestMissiles.clear();
			weaponsUps.clear();
			JOptionPane.showMessageDialog(null, "Nivel " + (level-1) + " completado \n A ver hasta donde llegas...");
			startGame();
		}
	}
	
	public void pauseUnPauseCh(){
		
		if(GameFrame.getCurrentCard() == this){
			try {
				if(n == 2){
					Chronometer.timer.start();
					n++;
				}
				n=0;
			} catch (Exception e2) {
				e2.getMessage();
			}
		}else{
			try {
				if(n == 1){
					Chronometer.timer.stop();
					n++;
				}
				n=0;
				Chronometer.timer.removeActionListener(Chronometer.al);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getMessage();
			}
		}
		
	}
	
}
