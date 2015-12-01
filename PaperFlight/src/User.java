
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String password;
	Player player;
	ArrayList<Enemy> enemies;
	ArrayList<HardEnemy> hEnemies;
	ArrayList<SuperEnemy> sEnemies;
	ArrayList<Missile> missiles;
	ArrayList<BestMissiles> bestMissiles;
	ArrayList<LifeUp> lifeUps;
	ArrayList<WeaponUp> weaponUps;
	int sFirst = 0;
	int sSecond = 0;
	int sThird = 0;
	int level;
	int totalScore;
	int seconds;
	
	public User(String name, String password, Player player, ArrayList<Enemy> enemies, ArrayList<HardEnemy> hEnemies, ArrayList<SuperEnemy> sEnemies, ArrayList<LifeUp> lifeUps, ArrayList<Missile> missiles, ArrayList<BestMissiles> bestMissiles, ArrayList<WeaponUp> weaponUps, int level, int totalScore, int seconds, int sFirst, int sSecond, int sThird) {
		this.name = name;
		this.password = password;
		this.player = player;
		this.enemies = enemies;
		this.hEnemies = hEnemies;
		this.sEnemies = sEnemies;
		this.lifeUps = lifeUps;
		this.missiles = missiles;
		this.bestMissiles = bestMissiles;
		this.weaponUps = weaponUps;
		this.level = level;
		this.totalScore = totalScore;
		this.seconds = seconds;
		this.sFirst = sFirst;
		this.sSecond = sSecond;
		this.sThird = sThird;
	}
	
	public User(String name, String password){
		this.name = name;
		this.password = password;
	}
	
	public int getsFirst() {
		return sFirst;
	}

	public void setsFirst(int sFirst) {
		this.sFirst = sFirst;
	}

	public int getsSecond() {
		return sSecond;
	}

	public void setsSecond(int sSecond) {
		this.sSecond = sSecond;
	}

	public int getsThird() {
		return sThird;
	}

	public void setsThird(int sThird) {
		this.sThird = sThird;
	}

	public ArrayList<Missile> getMissiles() {
		return missiles;
	}

	public void setMissiles(ArrayList<Missile> missiles) {
		this.missiles = missiles;
	}

	public ArrayList<BestMissiles> getBestMissiles() {
		return bestMissiles;
	}

	public void setBestMissiles(ArrayList<BestMissiles> bestMissiles) {
		this.bestMissiles = bestMissiles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<WeaponUp> getWeaponUps() {
		return weaponUps;
	}

	public void setWeaponUps(ArrayList<WeaponUp> weaponUps) {
		this.weaponUps = weaponUps;
	}

	public ArrayList<LifeUp> getLifeUps() {
		return lifeUps;
	}

	public void setLifeUps(ArrayList<LifeUp> lifeUps) {
		this.lifeUps = lifeUps;
	}

	public ArrayList<SuperEnemy> getsEnemies() {
		return sEnemies;
	}

	public void setsEnemies(ArrayList<SuperEnemy> sEnemies) {
		this.sEnemies = sEnemies;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<HardEnemy> gethEnemies() {
		return hEnemies;
	}

	public void sethEnemies(ArrayList<HardEnemy> hEnemies) {
		this.hEnemies = hEnemies;
	}
	
	public static User loadUser(String n){
		
		String fileName = "./" + n + ".pf";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			User u = (User) ois.readObject();
			ois.close();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void saveUser(User u){
		String fileName = "./" + u.getName() + ".pf";
		try {
			FileOutputStream fos = new FileOutputStream(fileName,false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(u);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void organizeHighScore(User u, int n){
		int a = u.getsFirst();
		int b = u.getsSecond();
		int c = u.getsThird();
		
		if(n > a){
			c = b;
			b = a;
			a = n;
		}else if(n > b && n != a){
			c = b;
			b = n;
		}else if(n > c && n != b && n != a){
			c = n;
		}
		u.setsFirst(a);
		u.setsSecond(b);
		u.setsThird(c);
		User.saveUser(u);
	}
	
}
