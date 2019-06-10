package model;

public class Date {
	
	private int month;
	private int year;
	
	public Date(int month, int year) {
		this.setMonth(month);
		this.setYear(year);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return this.month + "/" + this.year;
	}
}
