
public class Premium extends FirstClass{

	Airplane plane;
	
	public Premium() {
	}
	
	public Premium(int id, String name, String contact, Flight flight) {
		super(id, name, contact, flight);
		// TODO Auto-generated constructor stub
	}

	public Premium(int id, String name, String contact, Flight flight, Airplane plane) {
		super(id, name, contact, flight);
		this.flight.setPlane(plane);
		
	}

	

}
