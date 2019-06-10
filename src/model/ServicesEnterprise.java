package model;

import java.util.ArrayList;

public abstract class ServicesEnterprise extends Enterprise{
	
	protected ArrayList<Survey> surveys;
	
	public ServicesEnterprise(ArrayList<Survey> surveys) {
		super("", "", "", -1, 0, 0.0, -1, "", null);
		this.surveys = surveys;
	}

	public ServicesEnterprise(String name, String nit, String address, int phone, int employees, double assets,
			int type, String representative, Building building, ArrayList<Survey> surveys) {
		super(name, nit, address, phone, employees, assets, type, representative, building);
		this.surveys = surveys;
	}

	public ArrayList<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(ArrayList<Survey> surveys) {
		this.surveys = surveys;
	}
	
	public double calculateCustomerSatisfaction() {
		int numberOfSurveys = surveys.size();
		double satisfaction = 0.0;
		double sum = 0.0;
		if (numberOfSurveys < 10 || numberOfSurveys > 50) {
			satisfaction = -1.0;
		} else {
			for (int i = 0; i < numberOfSurveys; i++) {
				Survey s = surveys.get(i);
				sum += s.surveyAverage();
			}
			satisfaction = sum / numberOfSurveys;
		}
		return satisfaction;
	}
}