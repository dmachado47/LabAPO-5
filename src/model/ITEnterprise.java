package model;

import java.util.ArrayList;

public class ITEnterprise extends ServicesEnterprise implements TechnologyServices{

	// Relations
	
	private ArrayList<ITService> services;
	
	public ITEnterprise(String name, String nit, String address, int phone, int employees, double assets, int type,
			String representative, Building building, ArrayList<Survey> surveys, ArrayList<ITService> itservices) {
		
		super(name, nit, address, phone, employees, assets, type, representative, building, surveys);
		setServices(itservices);
	}

	public ArrayList<ITService> getServices() {
		return services;
	}

	public void setServices(ArrayList<ITService> services) {
		this.services = services;
	}

	public int energyAndTrees(double energyConsumption) {
		int harvest = 0;
		if (energyConsumption >= 1 && energyConsumption <= 1000) {
			harvest = 6;
		} else if (energyConsumption > 1000 && energyConsumption <= 3000) {
			harvest = 25;
		} else if (energyConsumption > 3000) {
			harvest = 200;
		}
		return harvest;
	}

}
