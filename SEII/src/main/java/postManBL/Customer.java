package postManBL;

import words.Address;

public class Customer {
	private String name;
	private String cell_phone;
	private Address address;
	private String unit;
	private String telephone;
	
	public Customer(String name,String cell,Address add,String unit,String tele){
		this.name = name;
		this.cell_phone = cell;
		this.address = add;
		this.unit = unit;
		this.telephone = tele;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
