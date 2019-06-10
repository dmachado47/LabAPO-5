package model;

public class Survey {
	
	public final static int MAX_Q_A = 3;
	
	private String[] questions;
	private int[] answers;
	
	public Survey() {
		setQuestions(new String[MAX_Q_A]);
		setAnswers(new int[MAX_Q_A]);
		
		questions[0] = new String("How satisfied are you with the offered service?");
		questions[1] = new String("How satisfied are you with our response times given?");
		questions[2] = new String("How satisfied are you with cost/benefit ratio for the acquired service?");
	}
	
	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public int[] getAnswers() {
		return answers;
	}

	public void setAnswers(int[] answers) {
		this.answers = answers;
	}
	
	public double surveyAverage() {
		int sum = 0;
		for (int i = 0; i < answers.length; i++) {
			sum += answers[i];
		}
		return sum / answers.length;
		
	}
	
	public String toString() {
		String survey = "";
		survey += "--------------- Survey Results ---------------\n";
		for (int i=0; i < MAX_Q_A; i++) {
			survey += questions[i] + " A: " + answers[i] + "/5 \n";
		}
		survey += "--------------- End of Results ---------------\n";
		
		return survey;
	}
}
