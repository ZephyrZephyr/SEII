package companyBL;

public class Account {
	private String name;        //company.unit.department  名称中包含公司名，单位名，部门名
	private String amount;
	private String company;
	private String unit;
	private String department;
	
	public Account(String name) {
		this.name = name;
		String[] temp = name.split(".");
		this.company = temp[0];
		this.unit = temp[1];
		this.department = temp[2];
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
