package superCampeones;

import java.io.Serializable;
import java.util.*;

public class Team implements Serializable, Comparable<Team>{
	
	String name;
	ArrayList<Player>  players;
	Player teamScorer;
	int points;
	int tgoals;
	int members;
	
	public Team() {
		super();
		members = 0;
	}
	
	public Team(String name, ArrayList<Player> players, int points, int tgoals, int members) {
		super();
		this.name = name;
		this.players = players;
		this.points = points;
		this.tgoals = tgoals;
		this.members = members;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Player> getPlayer() {
		return players;
	}
	public void setPlayer(ArrayList<Player> players) {
		this.players = players;
	}
	public Player getTeamScorer() {
		return teamScorer;
	}
	public void setTeamScorer() {
		Player p = new Player();
		for (int i = 0; i < players.size()-1; i++) {
			if(getPlayer().get(i).getGoals() > p.getGoals())
				p = players.get(i);
		
		this.teamScorer = p;
		}
	}
	public void setTeamScorer(Player teamScorer){
		this.teamScorer = teamScorer;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getTgoals() {
		return tgoals;
	}
	public void setTgoals(int tgoals) {
		this.tgoals = tgoals;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	
	public void addPlayer(Team team, int x){
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < x; i++) {
			Player pl = new Player();
			System.out.println("Jugador " + (i+1) + ": ");
			System.out.print("Nombre: ");
			pl.setName(sc.next());
			sc.nextLine();
			System.out.print("Id: ");
			pl.setId(sc.nextInt());
			System.out.print("Altura: ");
			pl.setHeight(toFloat(sc.next()));
			System.out.print("Peso: ");
			pl.setWeight(toFloat(sc.next()));
			System.out.print("¿Cuantas abilidades tiene?: ");
			int y = sc.nextInt();
			String[] ar = new String[y];
			String st;
			for (int j = 0; j < y; j++) {
				System.out.print("Abilidad " + (j+1) + ": ");
				st = sc.next();
				ar[j] = st;
			}
			pl.setAbilities(ar);
			pl.setGoals(0);
			System.out.println("Jugador añadido." + "\n");
			this.members+=1;
		}
		sc.close();
	}
	
	public static String arraylistToArray(ArrayList<Player> p){
		String s = null;
		for (int i = 0; i < p.size(); i++) {
			s = "\n" + p.get(i).getName()+ ", Id: " + p.get(i).getId() + ", Altura: " + p.get(i).getHeight() + ", Peso: " + p.get(i).getWeight();
		}
		return s;
	}
	
	

	@Override
	public String toString() {
		setTeamScorer();
		return "Equipo: " + name + ", Goleador: " + teamScorer.getName() + ", Puntos: " + points
				+ ", Goles: " + tgoals + ", Miembros: " + members + "\nJugadores: " + players.toString().replace("[", "").replace("]", "");
	}

	@Override
	public int compareTo(Team t) {
		int comparePoints = ((Team)t).getPoints();
		return comparePoints - this.points;
	}

	public double toFloat(String s){
		if(s.contains("."))
			s.replace(".", ",");
		return Float.parseFloat(s);
	}
	
	
}
