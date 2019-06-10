package model;

public abstract class Enterprise {
	
	// Constant values
	
	public static final int FARMING_HUNTING = 101;
	public static final int MINING_QUARRY = 102;
	public static final int MANUFACTURING = 103;
	public static final int ELECTRIC_GAS = 104;
	public static final int BUILDING = 105;
	public static final int RETAILERS = 106;
	public static final int TRANSPORT_COMMS = 107;
	public static final int FINANCIAL_INSURANCE = 108;
	public static final int SOCIAL_COMMUNITY = 109;
	
	// Attributes
	
	protected String name;
	protected String assignedNIT;
	protected String address;
	protected int contactPhone;
	protected int numberEmployees;
	protected double assetsValue;
	protected int organizationType;
	protected String legalRepresentative;
	
	// Relations
	
	protected Building enterpriseBuilding;
	
	public Enterprise(String name, String nit, String address, int phone, int employees, double assets, 
			int type, String representative, Building building) {
		
		this.name = name;
		this.assignedNIT = nit;
		this.address = address;
		this.contactPhone = phone;
		this.assetsValue = assets;
		this.organizationType = type;
		this.legalRepresentative = representative;
		this.enterpriseBuilding = building;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignedNIT() {
		return assignedNIT;
	}

	public void setAssignedNIT(String assignedNIT) {
		this.assignedNIT = assignedNIT;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(int contactPhone) {
		this.contactPhone = contactPhone;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	public double getAssetsValue() {
		return assetsValue;
	}

	public void setAssetsValue(double assetsValue) {
		this.assetsValue = assetsValue;
	}

	public int getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(int organizationType) {
		this.organizationType = organizationType;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public Building getEnterpriseBuilding() {
		return enterpriseBuilding;
	}

	public void setEnterpriseBuilding(Building enterpriseBuilding) {
		this.enterpriseBuilding = enterpriseBuilding;
	}
	
	public String toString() {
		String infoEnterprise = "";
		infoEnterprise += "--------------- Enterprise Details --------------- \n";
		infoEnterprise += "Enterprise Name: " + this.name + "\n";
		infoEnterprise += "Assigned NIT: " + this.assignedNIT + "\n";
		infoEnterprise += "Current Address: " + this.address + "\n";
		infoEnterprise += "Phone Number: " + this.contactPhone + "\n";
		infoEnterprise += "Number of Employees: " + this.numberEmployees + "\n";
		infoEnterprise += "Current Assets: " + this.assetsValue + "\n";
		infoEnterprise += "Organization Type: " + this.organizationType + "\n";
		infoEnterprise += "Legal Representative name: " + this.legalRepresentative + "\n";
		infoEnterprise += "Building where the Enterprise is Located: " + this.enterpriseBuilding.getName() + "\n";
		
		return infoEnterprise;
	}
	
	public boolean assignCubicleToEmployee(String name, String charge, String email) {
		boolean assigned = false;
		Cubicle[][] theCubicles = enterpriseBuilding.getCubicles();
		for (int i = 0; i < theCubicles.length && !assigned; i++) {
			for (int j = 0; j < theCubicles[i].length && !assigned; j++) {
				Cubicle temp = theCubicles[i][j];
				if (temp.isAvailable()) {
					temp.fillCubicle(name, charge, email);
					assigned = true;
				}
			}
		}
		return assigned;
	}
	
	public int searchExtensionInL(String nameEmployee) {
		int Lextension = -1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor(); // X
		int floors = enterpriseBuilding.getFloors(); // Y
		boolean found = false;
		for (int i = cubs - 1; i >= 0 && !found; i--) {
			Cubicle c = enterpriseBuilding.getCubicles()[0][i];
			String e = c.getEmployeeName();
			if(e.equalsIgnoreCase(nameEmployee)) {
				Lextension = c.getExtension();
				found = true;
			}
		} if(!found) {
			for (int j = 0; j < floors && ! found; j++) {
				Cubicle cf = enterpriseBuilding.getCubicles()[j][0];
				String em = cf.getEmployeeName();
				if(em.equalsIgnoreCase(nameEmployee)) {
					Lextension = cf.getExtension();
					found = true;
				}
			}
		}
		return Lextension;
	}
	
	// This method only executes in a matrix of minimum 3x3, and that matrix must be square.
	public int searchExtensionInZ(String nameEmployee) {
		int Zextension = -1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor(); // X
		int floors = enterpriseBuilding.getFloors(); // Y
		boolean found = false;
		if (cubs != floors || cubs < 3 || floors < 3) {
			System.out.println("This search only executes in a square matrix of at least 3x3");
		}
		if (cubs == floors && cubs >= 3 && floors >= 3) {
			for (int w = 0; w < cubs && !found; w++) {
				Cubicle cw = enterpriseBuilding.getCubicles()[floors - 1][w];
				String ew = cw.getEmployeeName();
				if(ew.equalsIgnoreCase(nameEmployee)) {
					Zextension = cw.getExtension();
					found = true;
				}
			}
			for (int x = floors - 2; x > 0 && !found; x--) {
				for (int y = cubs - 2; y > 0 && !found; y--) {
					Cubicle cxy = enterpriseBuilding.getCubicles()[x][y];
					String exy = cxy.getEmployeeName();
					if(exy.equals(nameEmployee)) {
						Zextension = cxy.getExtension();
						found = true;
					}
				}
			}
			for (int z = 0; z < cubs && !found; z++) {
				Cubicle cz = enterpriseBuilding.getCubicles()[0][z];
				String ez = cz.getEmployeeName();
				if(ez.equalsIgnoreCase(nameEmployee)) {
					Zextension = cz.getExtension();
					found = true;
				}
			}
		}
		return Zextension;
	}
	
	// This method only executes in a matrix of minimum 3x3, and that matrix must be square.
	public int searchExtensionInX(String nameEmployee) {
		int Xextension = -1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor(); // X
		int floors = enterpriseBuilding.getFloors(); // Y
		boolean found = false;
		if (cubs != floors || cubs < 3 || floors < 3) {
			System.out.println("This search only executes in a square matrix of at least 3x3");
		}
		if (cubs == floors && cubs >= 3 && floors >= 3) {
			for (int x = 0; x < cubs && !found; x++) {
				for (int y = 0; y < cubs && !found; y++) {
					Cubicle c1 = enterpriseBuilding.getCubicles()[x][y];
					String e1 = c1.getEmployeeName();
					if (e1.equalsIgnoreCase(nameEmployee)) {
						Xextension = c1.getExtension();
						found = true;
					}
				}
			}
			for (int z = floors - 1; z >= 0 && !found; z--) {
				for (int w = cubs - 1; w >= 0 && !found; w--) {
					Cubicle c2 = enterpriseBuilding.getCubicles()[z][w];
					String e2 = c2.getEmployeeName();
					if (e2.equalsIgnoreCase(nameEmployee)) {
						Xextension = c2.getExtension();
						found = true;
					}
				}
			}
		}
		return Xextension;
	}
	
	public int searchExtensionInO(String nameEmployee) {
		int Oextension = -1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor(); // X
		int floors = enterpriseBuilding.getFloors(); // Y
		boolean found = false;
		for (int i = cubs - 1; i >= 0 && !found; i--) {
			Cubicle c1 = enterpriseBuilding.getCubicles()[cubs-1][i];
			String name1 = c1.getEmployeeName();
			if(name1.equalsIgnoreCase(nameEmployee)) {
				Oextension = c1.getExtension();
				found = true;
			}
		}
		for (int j = floors - 2; j >= 0 && !found; j--) {
			Cubicle c2 = enterpriseBuilding.getCubicles()[j][0];
			String name2 = c2.getEmployeeName();
			if(name2.equalsIgnoreCase(nameEmployee)) {
				Oextension = c2.getExtension();
				found = true;
			}
		}
		for (int k = 1; k < cubs && !found; k--) {
			Cubicle c3 = enterpriseBuilding.getCubicles()[0][k];
			String name3 = c3.getEmployeeName();
			if(name3.equalsIgnoreCase(nameEmployee)) {
				Oextension = c3.getExtension();
				found = true;
			}
		}
		for (int l = 1; l < floors && !found; l--) {
			Cubicle c4 = enterpriseBuilding.getCubicles()[l][cubs - 1];
			String name4 = c4.getEmployeeName();
			if(name4.equalsIgnoreCase(nameEmployee)) {
				Oextension = c4.getExtension();
				found = true;
			}
		}
		return Oextension;
	}
	
	public int searchExtensionRowSpiral(String nameEmployee) {
		int spiralExtension = -1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor();
		int floors = enterpriseBuilding.getFloors();
		boolean found = false;
		
		if (!enterpriseBuilding.floorNumberIsRequired()) {
			System.out.println("It's not possible to make this search in a building whose number of floors is ODD.");
		} else {
			int floorCount = 0;
			
			// Search until the floor below the last floor.
			while (floorCount < floors - 1) {
				for (int i = 0; i < cubs && !found; i++) {
					Cubicle cx = enterpriseBuilding.getCubicles()[floorCount][i];
					String nx = cx.getEmployeeName();
					if (nx.equalsIgnoreCase(nameEmployee)) {
						spiralExtension = cx.getExtension();
						found = true;
					}
				}
				for (int j = cubs - 1; j >= 0  && !found; j--) {
					Cubicle cy = enterpriseBuilding.getCubicles()[floorCount+1][j];
					String ny = cy.getEmployeeName();
					if (ny.equalsIgnoreCase(nameEmployee)) {
						spiralExtension = cy.getExtension();
						found = true;
					}
				}
			}
			
			// Search in last floor, if previous searches had no result.
			for (int k = 0; k < cubs && !found; k++) {
				Cubicle cz = enterpriseBuilding.getCubicles()[floors-1][k];
				String nz = cz.getEmployeeName();
				if (nz.equalsIgnoreCase(nameEmployee)) {
					spiralExtension = cz.getExtension();
					found = true;
				}
			}
		}
		return spiralExtension;
	}
	
	public String reportEmployeeMails(String charge) {
		String report = "List of Employees: \n";
		int counter = 1;
		int cubs = enterpriseBuilding.getCubiclesPerFloor();
		int floors = enterpriseBuilding.getFloors();
		int firstcub = 0; int firstfloor = 0;
		while (counter <= cubs * floors) {
			for (int a = firstcub; a <= cubs - 1; a++) {
				Cubicle ca = enterpriseBuilding.getCubicles()[firstfloor][a];
				String ma = ca.getEmail();
				String cha = ca.getPosition();
				if (cha.equalsIgnoreCase(charge)) {
					report += ma + "\n";
				}
				
				counter++;
			}
			for (int b = firstfloor + 1; b <= floors - 1; b++) {
				Cubicle cb = enterpriseBuilding.getCubicles()[b][floors - 1];
				String mb = cb.getEmail();
				String chb = cb.getPosition();
				if (chb.equalsIgnoreCase(charge)) {
					report += mb + "\n";
				}
				counter++;
			}
			for (int c = cubs - 2; c >= firstcub; c--) {
				Cubicle cc = enterpriseBuilding.getCubicles()[floors - 1][c];
				String mc = cc.getEmail();
				String chc = cc.getPosition();
				if (chc.equalsIgnoreCase(charge)) {
					report += mc + "\n";
				}
				counter++;
			}
			for (int d = floors - 2; d >= firstfloor + 1; d--) {
				Cubicle cd = enterpriseBuilding.getCubicles()[d][firstfloor];
				String md = cd.getEmail();
				String chd = cd.getPosition();
				if (chd.equalsIgnoreCase(charge)) {
					report += md + "\n";
				}
				counter++;
			}
		}		
		return report;
	}
}
