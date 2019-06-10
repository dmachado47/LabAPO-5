package model;

public class Building {
	
	private String name;
	private int floors;
	private int cubiclesPerFloor;
	
	private Cubicle[][] cubicles;
	
	public Building(String name, int floors, int cubsFloor) {
		
		this.name = name;
		this.floors = floors;
		this.cubiclesPerFloor = cubsFloor;
		
		cubicles = new Cubicle[floors][cubsFloor];
		
	}

	public String getName() {
		return name;
	}

	public void setName(String thename) {
		name = thename;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int thefloors) {
		floors = thefloors;
	}

	public int getCubiclesPerFloor() {
		return cubiclesPerFloor;
	}

	public void setCubiclesPerFloor(int thecubicles) {
		cubiclesPerFloor = thecubicles;
	}

	public Cubicle[][] getCubicles() {
		return cubicles;
	}

	public void setCubicles(Cubicle[][] buildingcubs) {
		cubicles = buildingcubs;
	}
	
	public boolean floorNumberIsRequired() {
		if (this.floors - 1 % 2 == 0 && this.floors >= 3) {
			return false;
		} else {
			return true;
		}
		
	}

}
