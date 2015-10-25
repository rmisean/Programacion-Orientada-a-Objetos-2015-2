
public class Tourist extends Person{

	Flight flight;
	
	public Tourist() {
	}

	public Tourist(int id, String name, String contact, Flight flight) {
		super(id, name, contact);
		this.flight = flight;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	
}
