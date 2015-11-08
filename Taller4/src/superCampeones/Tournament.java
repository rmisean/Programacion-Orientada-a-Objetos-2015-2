package superCampeones;

import java.text.Format;
import java.util.*;

public class Tournament {
	
	ArrayList<Team> teams;
	Player tournamentScorer;

	
	public Tournament() {
		super();
	}
	
	public Tournament(ArrayList<Team> teams, Player tournamentScorer) {
		super();
		this.teams = teams;
		this.tournamentScorer = tournamentScorer;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public Player getTournamentScorer() {
		return tournamentScorer;
	}
	public void setTournamentScorer() {
		Player scorer = new Player();
		for (int i = 0; i < teams.size()-1; i++) {
			if(teams.get(i).getTeamScorer().getGoals() > scorer.getGoals())
				scorer = teams.get(i).getTeamScorer();
		}
		this.tournamentScorer = scorer;
	}
	
	public int getNumberOfTeams(){
		return teams.size();
	}
	
	public void table(){
		Collections.sort(getTeams());
		System.out.println("\nTabla de posiciones actual.\n");
		System.out.println(String.format(" \t%-15s   \t%-10s   \t%-5s   \t%-5s", "Equipos", "Puntos", "Goles", "Goleador"));	
		for (int i = 0; i < teams.size(); i++) {
			if(getTeams().get(i).getMembers() == 0)
				System.out.println(String.format(" \t%-15s   \t%-10s   \t%-5s   \t%-5s", getTeams().get(i).getName(), getTeams().get(i).getPoints(), getTeams().get(i).getTgoals(), "No Disponinle"));
			else if(getTeams().get(i).getMembers() == 1)
				System.out.println(String.format(" \t%-15s   \t%-10s   \t%-5s   \t%-5s", getTeams().get(i).getName(), getTeams().get(i).getPoints(), getTeams().get(i).getTgoals(), getTeams().get(i).getPlayer().get(0).getName()));
			else{
				getTeams().get(i).setTeamScorer();
				System.out.println(String.format(" \t%-15s   \t%-10s   \t%-5s   \t%-5s", getTeams().get(i).getName(), getTeams().get(i).getPoints(), getTeams().get(i).getTgoals(), getTeams().get(i).getTeamScorer().getName()));
	
			}
		}
	}
	
	public void updateAfterMatch(){
		Scanner sc = new Scanner(System.in);
		int a,b,x,y,s1,s2,p,temp,temp2;
		int k = 0;
		System.out.print("Ingrese primer participante: ");
		a = sc.nextInt();
		System.out.print("Goles: ");
		b = sc.nextInt();
		for (int i = 0; i < getTeams().get(a-1).getPlayer().size(); i++) {
			System.out.println("  " + (i+1) + getTeams().get(a-1).getPlayer().get(i).getName());
		}
		if(b != 0){
			while(k < b) {
				System.out.print("Ingrese jugador: ");
				temp = sc.nextInt();
				Player pl = getTeams().get(a-1).getPlayer().get(temp);
				System.out.print("Ingrese goles marcados: ");
				temp2 = sc.nextInt();
				int g = pl.getGoals() + temp2;
				getTeams().get(a-1).getPlayer().get(temp).setGoals(g);
				k=+temp2;
			}
		}
		System.out.print("Ingrese segundo participante: ");
		x = sc.nextInt();
		System.out.print("Goles: ");
		y = sc.nextInt();
		k = 0;
		for (int i = 0; i < getTeams().get(x-1).getPlayer().size(); i++) {
			System.out.println("  " + (i+1) + getTeams().get(x-1).getPlayer().get(i).getName());
		}
		if(b != 0){
			while(k < y) {
				System.out.print("Ingrese jugador: ");
				temp = sc.nextInt();
				Player pl = getTeams().get(x-1).getPlayer().get(temp);
				System.out.print("Ingrese goles marcados: ");
				temp2 = sc.nextInt();
				int g = pl.getGoals() + temp2;
				getTeams().get(x-1).getPlayer().get(temp).setGoals(g);
				k=+temp2;
			}
		}
		
		s1 = getTeams().get(a-1).getTgoals() + b;
		s2 = getTeams().get(x-1).getTgoals() + y;
		
		getTeams().get(a-1).setTgoals(s1);
		getTeams().get(x-1).setTgoals(s2);
		
		if(b > y){
			p = getTeams().get(a-1).getPoints() + 3;
			getTeams().get(a-1).setPoints(p);
		}else if(b < y){
			p = getTeams().get(x-1).getPoints() + 3;
			getTeams().get(x-1).setPoints(p);
		}else{
			p = getTeams().get(a-1).getPoints() + 1;
			getTeams().get(a-1).setPoints(p);
			p = getTeams().get(x-1).getPoints() + 1;
			getTeams().get(x-1).setPoints(p);
		}
	}
	
}
