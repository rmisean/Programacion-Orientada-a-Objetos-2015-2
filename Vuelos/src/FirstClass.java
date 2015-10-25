
public class FirstClass extends FrecuentClient{
	
	public FirstClass() {
	}
	
	public FirstClass(int id, String name, String contact, Flight flight) {
		super(id, name, contact, flight);
		double c = flight.getCost();
		this.flight.setCost(c * 0.85);
	}

	

}
