import java.util.*;

public class Lines {
	
	private static ArrayList<Airplane> commercial = new ArrayList<>();
	private static ArrayList<Airplane> cargo = new ArrayList<>();
	private static ArrayList<Airplane> business = new ArrayList<>();
	
	public static void addToLine(Airplane plane){
		if((plane.capacity <= 10) && (plane.maxCharge > 12))
			cargo.add(plane);
		else if((plane.capacity <= 10) && (plane.capacity >= 3))
			business.add(plane);
		else if(plane.capacity >= 50)
			commercial.add(plane);
	}
	
	public void status(ArrayList<Airplane> line){
		String o;
		System.out.println("Lista de aviones y estado: ");
		for (int i = 0; i < line.size(); i++) {
			if(line.get(i).isOperative() == true)
				o = "NO";
			else
				o = "SI";
			System.out.println(line.get(i).getFamily() + " " + line.get(i).getModel() + ". En mantenimiento: " + o );
		}
		
	}

	public ArrayList<Airplane> getCommercial() {
		return commercial;
	}

	public void setCommercial(ArrayList<Airplane> commercial) {
		this.commercial = commercial;
	}

	public ArrayList<Airplane> getCargo() {
		return cargo;
	}

	public void setCargo(ArrayList<Airplane> cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Airplane> getBusiness() {
		return business;
	}

	public void setBusiness(ArrayList<Airplane> business) {
		this.business = business;
	}
	
}
