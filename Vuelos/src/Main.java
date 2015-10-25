import java.util.*;

import org.omg.CORBA.ExceptionList;
import org.omg.Messaging.SyncScopeHelper;

public class Main {

	public static void main(String[] args) {
		
		int hometown;
		int destination;
		int y;
		int[] s;
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		ArrayList<Airplane> airplanes = new ArrayList<>();
		
		Airplane a1 = new Airplane(03256, 132, 0, 15, "Airbus", "A318", true);
		a1.fill(a1, 0);
		Lines.addToLine(a1);
		airplanes.add(a1);
		Airplane a2 = new Airplane(12542, 156, 0, 17, "Airbus", "A319", true);
		a1.fill(a2, 0);
		Lines.addToLine(a2);
		airplanes.add(a2);
		Airplane a3 = new Airplane(28562, 180, 0, 18, "Airbus", "A320", true);
		a1.fill(a3, 0);
		Lines.addToLine(a3);
		airplanes.add(a3);
		Airplane a4 = new Airplane(15686, 220, 0, 20, "Airbus", "A321", true);
		a1.fill(a4, 0);
		Lines.addToLine(a4);
		airplanes.add(a4);
		Airplane a5 = new Airplane(45618, 6, 0, 150, 14, "Antonov", "An-124", true);
		a1.fill(a5, 0);
		Lines.addToLine(a5);
		airplanes.add(a5);
		Airplane a6 = new Airplane(56111, 6, 0, 250, 15, "Antonov", "An-225", true);
		a1.fill(a6, 0);
		Lines.addToLine(a6);
		airplanes.add(a6);
		Airplane a7 = new Airplane(46841, 3, 0, 77, 16, "Boeing", "C-17", true);
		a1.fill(a7, 0);
		Lines.addToLine(a7);
		airplanes.add(a7);
		Airplane a8 = new Airplane(68463, 5, 0, 50, 16, "Ilyushin", "Il-76", true);
		a1.fill(a8, 0);
		Lines.addToLine(a8);
		airplanes.add(a8);
		Airplane a9 = new Airplane(76153, 7, 0, 9, "Learjet", "40", true);
		a1.fill(a9, 0);
		Lines.addToLine(a9);
		airplanes.add(a9);
		Airplane a10 = new Airplane(81351, 8, 0, 8, "Learjet", "75", true);
		a1.fill(a10, 0);
		Lines.addToLine(a10);
		airplanes.add(a10);
		Airplane a11 = new Airplane(71351, 4, 0, 9, "Cessna", "510", true);
		a1.fill(a11, 0);
		Lines.addToLine(a11);
		airplanes.add(a11);
		Airplane a12 = new Airplane(92351, 9, 0, 5, "Cessna", "208B", true);
		a1.fill(a12, 0);
		Lines.addToLine(a12);
		airplanes.add(a12);
		
		Map<Integer, City> cities = new HashMap<Integer, City>();
		
		City c1 = new City("Bogota", 0, 0);
		cities.put(1, c1);
		City c2 = new City("New York", 1, 6);
		cities.put(2, c2);
		City c3 = new City("Paris", 7, 5);
		cities.put(3, c3);
		City c4 = new City("Buenos Aires", 2, -4);
		cities.put(4, c4);
		City c5 = new City("Beijing", 12, 4);
		cities.put(5, c5);
		City c6 = new City("Tokio", -5, 3);
		cities.put(6, c6);
		City c7 = new City("El Cairo", 8, -6);
		cities.put(7, c7);
		City c8 = new City("Sidney", 10, 8);
		cities.put(8, c8);
		City c9 = new City("moscu", -4, -3);
		cities.put(9, c9);
		
		ArrayList<City> citiesarray = new ArrayList<City>(cities.values());
		
		ArrayList<Pilot> pilots = new ArrayList<>();
		Pilot p1 = new Pilot(6841, "Winnie Lindsey", "3256521", 0, false);
		pilots.add(p1);
		Pilot p2 = new Pilot(8371, "Rigby Taryn", "rigby57@gmail.com", 0, false);
		pilots.add(p2);
		Pilot p3 = new Pilot(3516, "Darleen Cassarah", "684351", 0, false);
		pilots.add(p3);
		Pilot p4 = new Pilot(3183, "Hall Bailey", "hally@hotmail.com", 0, false);
		pilots.add(p4);
		Pilot p5 = new Pilot(6843, "Jinny Janelle", "6533589", 0, false);
		pilots.add(p5);
		Pilot p6 = new Pilot(7613, "Luis Conrrado", "681333", 0, false);
		pilots.add(p6);
		
		Tourist tourist = new Tourist();
		FrecuentClient frecuentclient = new FrecuentClient();
		FirstClass firstclass = new FirstClass();
		Premium premium = new Premium();
		Flight flight = new Flight();
		System.out.println("Bienvenido");
		System.out.println("Escriba el número correspondiente a lo que desea hacer.");
		System.out.println("1. Vender un vuelo.");
		System.out.println("2. Consultar el sistema de información.");
		main: while(sc.hasNext()){
			String x = sc.next();
			int cat = 0;
			switch (x) {
			case "1":
				System.out.println("Ingrese los siguientes datos");
				System.out.print("Nombre: ");
				String name = sc.next();
				System.out.print("Identificación: ");
				int id = sc.nextInt();
				System.out.print("Información de contacto: ");
				String contact = sc.next();
				System.out.println("Categoría: ");
				System.out.println("  1. Turista.");
				System.out.println("  2. Cliente Frecuente.");
				System.out.println("  3. Primera Clase.");
				System.out.println("  4. Premium.");
				categories: while(sc.hasNext()){
					cat = sc.nextInt();
					switch (cat) {
					case 1:
						tourist.setName(name);
						tourist.setId(id);
						tourist.setContact(contact);
						System.out.println("Ciudad de origen: ");
						City.cityNames(citiesarray);
						hometown = sc.nextInt();
						System.out.println("Ciudad de destino: ");
						destination = sc.nextInt();
						while(hometown == destination){
							System.out.println("La ciudad de destino no puede ser la misma que la de origen");
							System.out.println("Intente otra vez.");
							destination = sc.nextInt();
						}
						flight.setHometown(cities.get(hometown));
						flight.setDestination(cities.get(destination));
						flight.setCost(r.nextInt(100)+1);
						flight.setDay(r.nextInt(30)+1);
						flight.setMonth(r.nextInt(12));
						flight.setPlane(airplanes.get(r.nextInt(airplanes.size())));
						flight.setPilot(pilots.get(r.nextInt(pilots.size())));
						flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						while(flight.getPilot().equals(flight.getCopilot())){
								flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						}
						flight.setId(Integer.parseInt(String.format("%04d",r.nextInt(9999)+1)));
						s = new int[flight.getPlane().capacity];
						y = r.nextInt(flight.getPlane().capacity+1);
						if(s[y] == 1){
							while(s[y] == 1){
								y = r.nextInt(flight.getPlane().capacity);
							}
						}
						s[y] = 1;
						flight.setSeat(y);
						flight.getPlane().setSeats(s);
						System.out.println(flight.toString());
						break categories;
						
					case 2:
						frecuentclient.setName(name);
						frecuentclient.setId(id);
						frecuentclient.setContact(contact);
						System.out.println("Ciudad de origen: ");
						City.cityNames(citiesarray);
						hometown = sc.nextInt();
						System.out.println("Ciudad de destino: ");
						destination = sc.nextInt();
						while(hometown == destination){
							System.out.println("La ciudad de destino no puede ser la misma que la de origen");
							System.out.println("Intente otra vez.");
							destination = sc.nextInt();
						}
						flight.setHometown(cities.get(hometown));
						flight.setDestination(cities.get(destination));
						flight.setCost(r.nextInt(100)+1);
						flight.setDay(r.nextInt(30)+1);
						flight.setMonth(r.nextInt(12));
						flight.setPlane(airplanes.get(r.nextInt(airplanes.size())));
						flight.setPilot(pilots.get(r.nextInt(pilots.size())));
						flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						while(flight.getPilot().equals(flight.getCopilot())){
								flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						}
						flight.setId(Integer.parseInt(String.format("%04d",r.nextInt(9999)+1)));
						s = new int[flight.getPlane().capacity];
						System.out.print("Numero del asiento(1 - " + flight.getPlane().capacity + "): ");
						y = sc.nextInt();
						if(s[y] == 1){
							while(s[y] == 1){
								System.out.print("El asiento ya esta ocupado, ingrese otro asiento: ");
								y = sc.nextInt();
							}
						}
						s[y] = 1;
						flight.setSeat(y);
						flight.getPlane().setSeats(s);
						System.out.println(flight.toString());
						tourist.setFlight(flight);
						break categories;
						
					case 3:
						firstclass.setName(name);
						firstclass.setId(id);
						firstclass.setContact(contact);
						System.out.println("Ciudad de origen: ");
						City.cityNames(citiesarray);
						hometown = sc.nextInt();
						System.out.println("Ciudad de destino: ");
						destination = sc.nextInt();
						while(hometown == destination){
							System.out.println("La ciudad de destino no puede ser la misma que la de origen");
							System.out.println("Intente otra vez.");
							destination = sc.nextInt();
						}
						flight.setHometown(cities.get(hometown));
						flight.setDestination(cities.get(destination));
						flight.setDay(r.nextInt(30)+1);
						flight.setMonth(r.nextInt(12));
						flight.setPlane(airplanes.get(r.nextInt(airplanes.size())));
						flight.setPilot(pilots.get(r.nextInt(pilots.size())));
						flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						while(flight.getPilot().equals(flight.getCopilot())){
								flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						}
						flight.setId(Integer.parseInt(String.format("%04d",r.nextInt(9999)+1)));
						s = new int[flight.getPlane().capacity];
						System.out.print("Numero del asiento(1 - " + flight.getPlane().capacity + "): ");
						y = sc.nextInt();
						if(s[y] == 1){
							while(s[y] == 1){
								System.out.print("El asiento ya esta ocupado, ingrese otro asiento: ");
								y = sc.nextInt();
							}
						}
						s[y] = 1;
						flight.setSeat(y);
						flight.getPlane().setSeats(s);
						flight.setCost(r.nextInt(100)+1);
						System.out.println("Valor normal: " + flight.getCost() + "00");
						firstclass.setFlight(flight);
						System.out.println("Valor con descuento: " + firstclass.getFlight().getCost()*100);
						System.out.println(flight.toString());
						break categories;
						
					case 4:
						premium.setName(name);
						premium.setId(id);
						premium.setContact(contact);
						System.out.println("Ciudad de origen: ");
						City.cityNames(citiesarray);
						hometown = sc.nextInt();
						System.out.println("Ciudad de destino: ");
						destination = sc.nextInt();
						while(hometown == destination){
							System.out.println("La ciudad de destino no puede ser la misma que la de origen");
							System.out.println("Intente otra vez.");
							destination = sc.nextInt();
						}
						flight.setHometown(cities.get(hometown));
						flight.setDestination(cities.get(destination));
						flight.setCost(r.nextInt(100)+1);
						flight.setDay(r.nextInt(30)+1);
						flight.setMonth(r.nextInt(12));
						flight.setPlane(airplanes.get(r.nextInt(airplanes.size())));
						flight.setPilot(pilots.get(r.nextInt(pilots.size())));
						flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						while(flight.getPilot().equals(flight.getCopilot())){
								flight.setCopilot(pilots.get(r.nextInt(pilots.size())));
						}
						flight.setId(Integer.parseInt(String.format("%04d",r.nextInt(9999)+1)));
						s = new int[flight.getPlane().capacity];
						System.out.print("Numero del asiento(1 - " + flight.getPlane().capacity + "): ");
						y = sc.nextInt();
						if(s[y] == 1){
							while(s[y] == 1){
								System.out.print("El asiento ya esta ocupado, ingrese otro asiento: ");
								y = sc.nextInt();
							}
						}
						s[y] = 1;
						flight.setSeat(y);
						flight.getPlane().setSeats(s);
						System.out.println(flight.toString());
						break categories;
	
					default:
						System.out.println("Categoria incorrecta, por favor vuelva a intentarlo.");
						break;
					}
				}
				
				break;
			case "2":
				
				break;
			default:
				System.out.println("Entrada incorrecta, por favor vuelva a intentarlo.");
				break;
			}
		}
	}

}
