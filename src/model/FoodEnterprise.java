package model;

import java.util.ArrayList;

public class FoodEnterprise extends ManufacturesEnterprise{

	public FoodEnterprise(String name, String nit, String address, int phone, int employees, double assets, int type,
			String representative, Building building, ArrayList<Product> products) {
		super(name, nit, address, phone, employees, assets, type, representative, building, products);
		
	}

}
