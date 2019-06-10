package model;

import java.util.ArrayList;

public class EducationEnterprise extends ServicesEnterprise implements ProcultureTaxes{
	
	// Constant values
	
	public static final int HIGH_SCHOOL = 301;
	public static final int UNIVERSITY = 302;
	
	// Attributes
	
	private String approvalRegistry;
	private int accreditateYears;
	private int knowledge11Rank;
	private int knowledgeProRank;
	private String principal;
	private int educationalSector;
	private int activeSpecialStudents;
	private int activeStudents;
	
	public EducationEnterprise(String name, String nit, String address, int phone, int employees, double assets,
			int type, String represent, Building build, ArrayList<Survey> surveys, String approved, int years,
			int rank11, int rankPro, String principal, int sector, int specialStudents, int active) {
		
		super(name, nit, address, phone, employees, assets, type, represent, build, surveys);
		this.approvalRegistry = approved;
		this.accreditateYears = years;
		this.knowledge11Rank = rank11;
		this.knowledgeProRank = rankPro;
		this.principal = principal;
		this.activeSpecialStudents = specialStudents;
		this.activeStudents = active;
		
	}

	public String getApprovalRegistry() {
		return approvalRegistry;
	}

	public void setApprovalRegistry(String approvalRegistry) {
		this.approvalRegistry = approvalRegistry;
	}

	public int getAccreditateYears() {
		return accreditateYears;
	}

	public void setAccreditateYears(int accreditateYears) {
		this.accreditateYears = accreditateYears;
	}

	public int getKnowledge11Rank() {
		return knowledge11Rank;
	}

	public void setKnowledge11Rank(int knowledge11Rank) {
		this.knowledge11Rank = knowledge11Rank;
	}

	public int getKnowledgeProRank() {
		return knowledgeProRank;
	}

	public void setKnowledgeProRank(int knowledgeProRank) {
		this.knowledgeProRank = knowledgeProRank;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public int getEducationalSector() {
		return educationalSector;
	}

	public void setEducationalSector(int educationalSector) {
		this.educationalSector = educationalSector;
	}

	public int getActiveSpecialStudents() {
		return activeSpecialStudents;
	}

	public void setActiveSpecialStudents(int activeSpecialStudents) {
		this.activeSpecialStudents = activeSpecialStudents;
	}

	public int getActiveStudents() {
		return activeStudents;
	}

	public void setActiveStudents(int activeStudents) {
		this.activeStudents = activeStudents;
	}
	
	public String toString() {
		String info = super.toString();
		
		return info;
	}

	public double calculateProcultureTax() {
		double special = this.activeSpecialStudents / this.activeStudents;
		double tax = 0.20 - special;
		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}
	}
}
