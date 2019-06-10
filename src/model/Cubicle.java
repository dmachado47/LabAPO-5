package model;

public class Cubicle {
	
	// Attributes
	
	private String employeeName;
	private String position;
	private String email;
	private int extension;
	
	public Cubicle(String name, String position, String mail, int extension) {
		
		this.employeeName = name;
		this.position = position;
		this.email = mail;
		this.extension = extension;
		
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employee) {
		employeeName = employee;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String charge) {
		position = charge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int xten) {
		extension = xten;
	}
	
	public void fillCubicle(String employee, String employeeCharge, String employeeMail) {
		this.employeeName = employee;
		this.position = employeeCharge;
		this.email = employeeMail;
	}
	
	public void makeAvailable() {
		this.employeeName = "";
		this.position = "";
		this.email = "";
	}
	
	public boolean isAvailable() {
		boolean noEmployee = this.employeeName.equals("");
		boolean noCharge = this.position.equals("");
		boolean noEmail = this.email.equals("");
		
		return noEmployee && noCharge && noEmail;
	}

}