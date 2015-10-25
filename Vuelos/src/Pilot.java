
public class Pilot extends Person{
	
	int hours;
	boolean assigned;
	
	public Pilot(int id, String name, String contact, int hours, boolean assigned) {
		super(id, name, contact);
		this.hours = hours;
		this.assigned = assigned;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
}
