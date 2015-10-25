import java.util.ArrayList;
import java.util.Map;

public class City {
	
	private String name;
	private int x;
	private int y;
	
	public City(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double getDistance(City c1, City c2){
		
		double d = Math.sqrt(Math.pow(c2.getX()-c1.getX(), 2)+ Math.pow(c2.getY() - c1.getY(), 2));
		return d;
		
	}
	
	public static void cityNames(ArrayList<City> cities){
		
		for (int i = 0; i < cities.size(); i = i + 3) {
			
			System.out.print(String.format(" %1d %-15s \t%d %-15s \t%d %-15s\n", i+1 , " " + cities.get(i).getName(),i+2 , " " + cities.get(i+1).getName(), i+3 , " " + cities.get(i+2).getName()));
		}
		
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
