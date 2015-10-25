import java.util.ArrayList;

public class Flight {
	
	int id;
	double cost;
	int day;
	int month;
	int seat;
	Pilot pilot;
	Pilot copilot;
	City hometown;
	City destination;
	Airplane plane;
	
	public Flight(){
	}
	
	public Flight(int id, double cost, int day, int month, int seat, Pilot pilot, Pilot copilot,
			City hometown, City destination, Airplane plane) {
		super();
		this.id = id;
		this.cost = cost;
		this.day = day;
		this.month = month;
		this.seat = seat;
		this.pilot = pilot;
		this.copilot = copilot;
		this.hometown = hometown;
		this.destination = destination;
		this.plane = plane;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Pilot getCopilot() {
		return copilot;
	}

	public void setCopilot(Pilot copilot) {
		this.copilot = copilot;
	}

	public City getHometown() {
		return hometown;
	}
	public void setHometown(City hometown) {
		this.hometown = hometown;
	}
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Vuelo #" + id + ", Valor: " + cost + "00, Dia: " + day + ", Mes: " + month + ", Asiento: " + seat
				+ ", Piloto: " + pilot + ", Copiloto: " + copilot + ", Origen: " + hometown + ", Destino: "
				+ destination + ", Avion = " + plane.getFamily() + " " + plane.getModel();
	}
	
	
	
}
