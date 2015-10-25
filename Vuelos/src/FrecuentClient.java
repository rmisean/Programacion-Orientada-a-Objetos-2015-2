
public class FrecuentClient extends Tourist{

	int seat;
	
	public FrecuentClient() {
	}
	
	public FrecuentClient(int id, String name, String contact, Flight flight) {
		super(id, name, contact, flight);
	}

	public void assignSeat(int seat){
		if(flight.plane.seats[seat] == 1)
			System.out.println("El asiento ya esta asignado.");
		else
			flight.plane.seats[seat] = 1;
	}

}
