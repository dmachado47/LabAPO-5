package model;

import java.util.ArrayList;

public abstract class ManufacturesEnterprise extends Enterprise {
	
	protected ArrayList<Product> products;
	
	public ManufacturesEnterprise(String name, String nit, String address, int phone, int employees, double assets,
			int type, String representative, Building building, ArrayList<Product> products) {
		super(name, nit, address, phone, employees, assets, type, representative, building);
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
}