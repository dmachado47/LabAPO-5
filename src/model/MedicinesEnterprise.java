package model;

import java.util.ArrayList;

public class MedicinesEnterprise extends ManufacturesEnterprise implements MedicineServices{
	
	// Constant values
	
	public final static int VALID = 401;
	public final static int EXPIRED = 402;
	public final static int EXPORT = 403;
	public final static int SELL = 404;
	public final static int IMPORT_SELL = 405;
	
	// Attributes
	
	private String regulatoryInfo;
	private String sanityRegistration;
	private int status;
	private Date expirationDate;
	private int modality;
	
	public MedicinesEnterprise(String name, String nit, String address, int phone, int employees, double assets,
			int type, String representative, Building building, ArrayList<Product> products, String regulation,
			String registration, int status, Date expired, int modality) {
		
		super(name, nit, address, phone, employees, assets, type, representative, building, products);
		this.setRegulatoryInfo(regulation);
		this.setSanityRegistration(registration);
		this.setExpirationDate(expired);
		this.setModality(modality);
		
	}

	public String getRegulatoryInfo() {
		return regulatoryInfo;
	}

	public void setRegulatoryInfo(String regulatoryInfo) {
		this.regulatoryInfo = regulatoryInfo;
	}

	public String getSanityRegistration() {
		return sanityRegistration;
	}

	public void setSanityRegistration(String sanityRegistration) {
		this.sanityRegistration = sanityRegistration;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getModality() {
		return modality;
	}

	public void setModality(int modality) {
		this.modality = modality;
	}
	
	public int waterAndTrees(double monthConsumption) {
		int harvest = 0;
		if (monthConsumption >= 1 && monthConsumption <= 140) {
			harvest = 6;
		} else if (monthConsumption > 140 && monthConsumption <= 800) {
			harvest = 25;
		} else if (monthConsumption > 800) {
			harvest = 200;
		}
		return harvest;
	}
}
