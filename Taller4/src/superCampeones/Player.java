package superCampeones;

import java.io.Serializable;
import java.util.Arrays;

public class Player implements Serializable{
	
	String name;
	int id;
	int goals;
	double height;
	double weight;
	String[] abilities;
	
	public Player() {}
	
	public Player(String name, int id, double height, double weight, String[] abilities) {
		super();
		this.name = name;
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.abilities = abilities;
	}
	
	public Player(String name, int id, int goals, double height, double weight, String[] abilities) {
		super();
		this.name = name;
		this.id = id;
		this.goals = goals;
		this.height = height;
		this.weight = weight;
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String[] getAbilities() {
		return abilities;
	}
	public void setAbilities(String[] abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "\n"+ name + ", ID: " + id + ", Altura: " + height + ", Peso: " + weight + ", Abilidades: "
				+ Arrays.toString(abilities);
	}
	
	
	
}
