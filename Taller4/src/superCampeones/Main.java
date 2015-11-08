package superCampeones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
	
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
		
		Scanner sc = new Scanner(System.in);
		Tournament banquitasUn = new Tournament();
		Team t = new Team();
		Team t2 = new Team();
		banquitasUn.setTeams(load());
		int x,y,z,w;
		System.out.println("\n      .:: BANQUITAS UN ::. \n");
		System.out.println("1. Tabla de Posiciones.");
		System.out.println("2. Ingresar Resultados.");
		System.out.println("3. Información de los Equipos");
		System.out.print("¿Qué desea hacer?: ");
		x = sc.nextInt();
		switch (x) {
		case 1:
			banquitasUn.table();
			break;
			
		case 2:
			for (int i = 0; i < banquitasUn.getTeams().size(); i++) {
				System.out.println((i+1) + ". " + banquitasUn.getTeams().get(i).getName());
			}
			banquitasUn.updateAfterMatch();
			saveTeams(banquitasUn.teams);
			
			break;
			
		case 3:
			System.out.println("\n");
			separateItems(banquitasUn.teams);
			System.out.println("1. Modificar equipos.");
			System.out.println("2. Modificar jugadores.");
			System.out.print("\n¿Qué desea hacer?: ");
			x = sc.nextInt();
			inner:switch (x) {
				case 1:
					System.out.println("\n1. Añadir Equipo.");
					System.out.println("2. Eliminar Equipo.");
					System.out.print("\n¿Qué desea hacer?: ");
					x = sc.nextInt();
					switch (x) {
						case 1:
							System.out.println("Ingrese los datos del equipo:");
							System.out.print("Nombre: ");
							t.setName(sc.nextLine());
							sc.nextLine();
							System.out.print("Puntos: ");
							t.setPoints(sc.nextInt());
							sc.nextLine();
							System.out.print("Goles: ");
							t.setTgoals(sc.nextInt());
							System.out.println("¿Cuántos jugadores desea ingresar?: ");
							x = sc.nextInt();
							t.addPlayer(t, x);
							banquitasUn.getTeams().add(t);
							saveTeams(banquitasUn.getTeams());
							System.out.println("Equipo creado.");
							break;
						case 2:
							System.out.println("\n");
							for (int i = 0; i < banquitasUn.getTeams().size(); i++) {
								System.out.println((i+1) + ". " + banquitasUn.getTeams().get(i).getName());
							}
							System.out.println("Que equipo desea eliminar?: ");
							x = sc.nextInt();
							banquitasUn.getTeams().remove(x-1);
							saveTeams(banquitasUn.getTeams());
							System.out.println("Equipo eliminado");
							break;
						default:
							System.out.println("Error, vuelva a intentarlo");
					}
					break;
				case 2:
					System.out.println("\n1. Añadir Jugador.");
					System.out.println("2. Eliminar Jugador.");
					System.out.print("\n¿Qué desea hacer?: ");
					x = sc.nextInt();
					switch (x) {
						case 1:
							System.out.println("Cuantos jugadores desea añadir?: ");
							x = sc.nextInt();
							for (int i = 0; i < banquitasUn.getTeams().size(); i++) {
								System.out.println((i+1) + ". " + banquitasUn.getTeams().get(i).getName());
							}
							System.out.println("A que equipo desea añadir ");
							y = sc.nextInt();
							t = banquitasUn.getTeams().get(y-1);
							t.addPlayer(t, x);
							saveTeams(banquitasUn.getTeams());
							break;
						case 2:
							for (int i = 0; i < banquitasUn.getTeams().size(); i++) {
								System.out.println((i+1) + ". " + banquitasUn.getTeams().get(i).getName());
								for (int j = 0; j < banquitasUn.getTeams().get(i).getPlayer().size(); j++) {
									System.out.println("  " + (j+1) + banquitasUn.getTeams().get(i).getPlayer().get(j).getName());
								}
							}
							System.out.print("De que equipo desea eliminar?: ");
							x = sc.nextInt();
							System.out.print("Que jugador desea eliminar?: ");
							y = sc.nextInt();
							banquitasUn.getTeams().get(x-1).getPlayer().remove(y-1);
							saveTeams(banquitasUn.teams);
							break;
						default:
							System.out.println("Error, vuelva a intentarlo");
					}
					break;
				default:
					System.out.println("Valor incorrecto, vuelva a intentarlo.");
					
			}
			break;
	
			default:
				System.out.println("Valor incorrecto, vuelva a intntarlo.");
			
			
		}
	}
	
}
