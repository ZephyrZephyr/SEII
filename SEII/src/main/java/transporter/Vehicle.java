package transporter;

public class Vehicle {
	private String name;  //车牌号
	private String engine;
	private String no;    //9位 车辆代号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String chassis;
	private String join_time;
	private String hall_id;
	
	public Vehicle(String name, String engine, String no, String chassis,
			String join_time) {
		this.name = name;
		this.engine = engine;
		this.no = no;
		this.chassis = chassis;
		this.join_time = join_time;
		this.hall_id = no.substring(3, 6);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
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
