package model;

public class ITService {
	
	// Constant Values
	
	public static final int CONSULTANCY = 201;
	public static final int TRAINING = 202;
	public static final int CUSTOM_SOFTWARE = 203;
	public static final int IAAS = 204;
	public static final int SAAS = 205;
	public static final int PAAS = 206;
	
	// Attributes
	
	private String nameService;
	private int typeService;
	
	public ITService(String name, int type) {
		this.nameService = name;
		this.typeService = type;
		
	}

	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public int getTypeService() {
		return typeService;
	}

	public void setTypeService(int typeService) {
		this.typeService = typeService;
	}
}
