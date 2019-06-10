package model;

import java.util.ArrayList;

public class PublicServicesEnterprise extends ServicesEnterprise implements ProcultureTaxes{
	
	public static final int SEWERAGE = 501;
	public static final int ENERGY = 502;
	public static final int AQUEDUCT = 503;
	
	private int typePublicService;
	private int totalSubscribers;
	private int lowStratumSubs;
	
	public PublicServicesEnterprise(String name, String nit, String address, int phone, int employees, double assets,
			int type, String representer, Building build, ArrayList<Survey> survs, int publicService, int totalSubs,
			int specialSubs) {
		
		super(name, nit, address, phone, employees, assets, type, representer, build, survs);
		typePublicService = type;
		totalSubscribers = totalSubs;
		lowStratumSubs = specialSubs;
		
	}

	public int getTypePublicService() {
		return typePublicService;
	}

	public void setTypePublicService(int typePublicService) {
		this.typePublicService = typePublicService;
	}

	public int getTotalSubscribers() {
		return totalSubscribers;
	}

	public void setTotalSubscribers(int totalSubscribers) {
		this.totalSubscribers = totalSubscribers;
	}

	public int getLowStratumSubs() {
		return lowStratumSubs;
	}

	public void setLowStratumSubs(int lowStratumSubs) {
		this.lowStratumSubs = lowStratumSubs;
	}

	public double calculateProcultureTax() {
		double lowStratum = this.lowStratumSubs / this.totalSubscribers;
		double tax = 0.40 -lowStratum;
		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}
	}
	
}
