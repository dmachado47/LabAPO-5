package model;

import java.util.ArrayList;

public class Holding {
	
	// Attributes
	
	private String holdingName;
	
	// Relations
	
	private Building holdingBuilding;
	private ArrayList<Enterprise> enterprises;
	
	public Holding (String name, Building building, ArrayList<Enterprise> enterprises) {
		this.setHoldingName(name);
		this.setHoldingBuilding(building);
		this.setEnterprises(enterprises);
	}

	public String getHoldingName() {
		return holdingName;
	}

	public void setHoldingName(String theName) {
		holdingName = theName;
	}

	public Building getHoldingBuilding() {
		return holdingBuilding;
	}

	public void setHoldingBuilding(Building newBuilding) {
		holdingBuilding = newBuilding;
	}

	public ArrayList<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(ArrayList<Enterprise> companies) {
		enterprises = companies;
	}
	
	public EducationEnterprise searchEducationEnterprise(String nit) {
		EducationEnterprise e = null;
		for (int x = 0; x < enterprises.size(); x++) {
			String tnit = enterprises.get(x).getAssignedNIT();
			if (tnit.equals(nit) && enterprises.get(x) instanceof EducationEnterprise) {
				e = (EducationEnterprise) enterprises.get(x);
			}
		}
		return e;
	}
	
	public MedicinesEnterprise searchMedicinesEnterprise(String nit) {
		MedicinesEnterprise e = null;
		for (int x = 0; x < enterprises.size(); x++) {
			String tnit = enterprises.get(x).getAssignedNIT();
			if (tnit.equals(nit) && enterprises.get(x) instanceof MedicinesEnterprise) {
				e = (MedicinesEnterprise) enterprises.get(x);
			}
		}
		return e;
	}
	
	public double getProcultureTaxes(String nitEnterprise) {
		double proculture = 0.0;
		EducationEnterprise ent = this.searchEducationEnterprise(nitEnterprise);
		if (ent == null) {
			proculture = -1;
		} else {
			proculture = ent.calculateProcultureTax();
		}
		return proculture;
	}
	
	public double getTreesToHarvestMedicines(String nitEnterprise, double consumption) {
		int trees = 0;
		MedicinesEnterprise med = this.searchMedicinesEnterprise(nitEnterprise);
		if (med == null) {
			trees = -1;
		} else {
			trees = med.waterAndTrees(consumption);
		}
		return trees;
	}
	
	public boolean registerNewEnterprise() {
		return false;
	}
}
