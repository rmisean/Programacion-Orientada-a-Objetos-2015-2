package superCampeones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class Files {
	
	public static ArrayList<Team> load(){
		
		Team team;
		try {
			FileInputStream fis = new FileInputStream("Teams.t");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Team> teams = (ArrayList<Team>)ois.readObject();
			ois.close();
			return teams;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void saveTeams(ArrayList<Team> team){
		
		try {
			FileOutputStream fos = new FileOutputStream("Teams.t");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(team);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void separateItems(ArrayList<Team> t){
		for (int i = 0; i < t.size(); i++) {
			System.out.println(t.get(i) +"\n");
		}
	}
	
	public static void main(String[] args) {

		ArrayList<Team> team = new ArrayList<>();
		team.add(new Team("Borrachos", new ArrayList<Player>(){{
			add(new Player("Jhon Casas", 345345, 1, 1.65, 67, new String[]{"Romper"}));
			add(new Player("Jose Cortes", 648316, 1, 1.59, 61, new String[]{"Tiro Largo"}));
			add(new Player("Luis Albeda", 353438, 2, 1.70, 73, new String[]{""}));
			add(new Player("Daniel Porto", 486312, 0, 1.72, 71, new String[]{"Defensa Magna"}));
			add(new Player("Pedro Nuñez", 489461, 1, 1.74, 80, new String[]{"Desliz"}));
			}}, 3, 5, 5));
		team.add(new Team("Camperos", new ArrayList<Player>(){{
			add(new Player("Dominic Amoro", 215507, 0, 1.65, 69, new String[]{""}));
			add(new Player("Singprasert Bunnark", 586000, 0, 1.73, 81, new String[]{"Robo"}));
			add(new Player("Theodor Capelloman", 279106, 2, 2.02, 90, new String[]{"Doble Shoot"}));
			add(new Player("Arthur Antines", 941554, 0, 2.03, 82, new String[]{""}));
			add(new Player("Juan Díaz", 419248, 1, 1.64, 54, new String[]{"Tiro Fugaz"}));
			}}, 4, 3, 5));
		team.add(new Team("InfelizesFC", new ArrayList<Player>(){{
			add(new Player("Alan Pascal", 693865, 2, 1.95, 97, new String[]{"Paso Fugaz"}));
			add(new Player("Manfred Margus", 531834, 0, 1.51, 54, new String[]{"Resorte"}));
			add(new Player("Hermann Kaltz", 502270, 0, 1.76, 78, new String[]{""}));
			add(new Player("Gino Hernandez", 443550, 2, 1.59, 63, new String[]{"Super D"}));
			add(new Player("Gabriel Galván", 331296, 0, 1.84, 79, new String[]{""}));
			}}, 3, 4, 5));
		team.add(new Team("Tapitas", new ArrayList<Player>(){{
			add(new Player("Tsubasa Oozora", 625033, 5, 1.75, 72, new String[]{"Tiro con chanfle"}));
			add(new Player("Tsuyoshi Oda", 489722, 2, 1.61, 61, new String[]{"Pase triple"}));
			add(new Player("Masato Nakazato", 129593, 1, 1.87, 73, new String[]{"Hurto Fantasma"}));
			add(new Player("Tsuyoshi Oda", 998146, 0, 1.62, 71, new String[]{"Defensa Divina"}));
			add(new Player("Toshiya Okano", 847267, 1, 1.83, 80, new String[]{"Corriente"}));
			}}, 12, 9, 5));
		team.add(new Team("Playita Team", new ArrayList<Player>(){{
			add(new Player("Tristin Cheyenne", 175375, 0, 1.63, 67, new String[]{""}));
			add(new Player("David Hernando", 614593, 2, 1.77, 61, new String[]{"Corte Invisible"}));
			add(new Player("Garnett Paco", 444968, 0, 1.82, 73, new String[]{""}));
			add(new Player("Ilbert Thad", 986584, 1, 1.61, 71, new String[]{""}));
			add(new Player("Spencer Donovan", 760003, 1, 1.70, 80, new String[]{"Atajada x2"}));
			}}, 2, 4, 5));
		team.add(new Team("BatasUN", new ArrayList<Player>(){{
			add(new Player("Rene Donato", 851764, 3, 1.58, 67, new String[]{""}));
			add(new Player("Grosvenor Myron", 193041, 2, 1.66, 61, new String[]{""}));
			add(new Player("Martie Barnabas", 804682, 0, 1.64, 73, new String[]{"Impenetrable"}));
			add(new Player("Emmerson Harvey", 295163, 0, 1.78, 71, new String[]{"Super salto"}));
			add(new Player("Ash Marshal", 489461, 0, 1.71, 80, new String[]{"Desliz x2"}));
			}}, 3, 5, 5));
		team.add(new Team("Lexicos de Marx", new ArrayList<Player>(){{
			add(new Player("Glenn Winslow", 507136, 1, 1.92, 67, new String[]{""}));
			add(new Player("Ben Terance", 823400, 0, 1.87, 61, new String[]{"Tiro campal"}));
			add(new Player("Dacre Holden", 391133, 1, 1.78, 73, new String[]{"Hoyo"}));
			add(new Player("Xuan Logan", 197538, 0, 1.90, 71, new String[]{"Shooter Champion"}));
			add(new Player("Diego Braidy", 172086, 0, 2.10, 80, new String[]{""}));
			}}, 3, 2, 5));
		team.add(new Team("Sin Techo", new ArrayList<Player>(){{
			add(new Player("Rafe Trafford", 206940, 0, 1.81, 89, new String[]{""}));
			add(new Player("Brendan Dave", 985485, 2, 1.95, 75, new String[]{"Ardor infalible"}));
			add(new Player("Asher Jools", 257901, 0, 1.87, 73, new String[]{""}));
			add(new Player("Rodney Roque", 761328, 2, 1.76, 71, new String[]{""}));
			add(new Player("Adair Rogelio", 110518, 2, 2.11, 92, new String[]{"Ruptura"}));
			}}, 6, 6, 5));
		
		saveTeams(team);
		
		ArrayList<Team> t1 = load();
		separateItems(t1);
	}
	
}
