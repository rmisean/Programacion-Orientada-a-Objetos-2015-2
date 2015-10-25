import java.util.Arrays;

public class Airplane {
	
	int id;
	int capacity;
	int[] seats = new int[capacity];
	int traveled;
	int maxCharge;
	int maxDistance;
	String family;
	String model;
	boolean operative;
	
	public Airplane(int id, int capacity, int traveled, int maxDistance, String family, String model,
			boolean operative) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.traveled = traveled;
		this.maxDistance = maxDistance;
		this.family = family;
		this.model = model;
		this.operative = operative;
	}

	public Airplane(int id, int capacity, int traveled, int maxCharge, int maxDistance, String family, String model,
			boolean operative) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.traveled = traveled;
		this.maxCharge = maxCharge;
		this.maxDistance = maxDistance;
		this.family = family;
		this.model = model;
		this.operative = operative;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int[] getSeats() {
		return seats;
	}

	public void setSeats(int[] seats) {
		this.seats = seats;
	}

	public int getTraveled() {
		return traveled;
	}

	public void setTraveled(int traveled) {
		this.traveled = traveled;
	}

	public int getMaxCharge() {
		return maxCharge;
	}

	public void setMaxCharge(int maxCharge) {
		this.maxCharge = maxCharge;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isOperative() {
		return operative;
	}

	public void setOperative(boolean operative) {
		this.operative = operative;
	}
	
	public void fill(Airplane plane, int x){
		
		int[] a = plane.getSeats();
		for (int i = 0; i < a.length; i++) {
			a[i] = x;
		}
		plane.setSeats(a);
	}
}
