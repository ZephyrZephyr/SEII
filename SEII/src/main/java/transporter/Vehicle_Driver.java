package transporter;


public class Vehicle_Driver {
	private String no;  //司机编号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String name;
	private String birthday;
	private String indentity_id;
	private String phone;
	private String unit;
	private String sex;
	private String join_time;
	private String hall_id;
	
	public Vehicle_Driver(String no, String name, String birthday,
			String indentity_id, String phone, String unit, String sex,String join_time) {
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.indentity_id = indentity_id;
		this.phone = phone;
		this.unit = unit;
		this.sex = sex;
		this.join_time = join_time;
		this.setHall_id(no.substring(3, 6));
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIndentity_id() {
		return indentity_id;
	}
	public void setIndentity_id(String indentity_id) {
		this.indentity_id = indentity_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJoin_time() {
		return join_time;
	}
	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}
	public String getHall_id() {
		return hall_id;
	}
	public void setHall_id(String hall_id) {
		this.hall_id = hall_id;
	}
}
