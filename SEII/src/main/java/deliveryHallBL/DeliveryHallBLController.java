package deliveryHallBL;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DeliveryHallData;
import dataService.DeliveryHallDataService;
import transporter.Vehicle;
import transporter.Vehicle_Driver;
import vo.CollectionVO;
import words.Date;
import BLService.DeliveryHallBLService;

public class DeliveryHallBLController implements DeliveryHallBLService{

	private DeliveryHallDataService data;
	public DeliveryHallBLController(){
		try {
			data = new DeliveryHallData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addVehicle(String name, String engine, String chassis,
			String join_time) {
		String no = getVehicleNo("235","001");  //235,001 need change
		Vehicle vehicle = new Vehicle(name,engine,no,chassis,join_time);
		data.addVehicle(vehicle);
	}
	String getVehicleNo(String center_no,String hall_no){
		ArrayList<String> noList = data.getVehicleNoList(hall_no);
		if(noList.size()!=0){
			String no = noList.get(noList.size()-1).substring(6);
			return center_no+hall_no+addZero(3,String.valueOf(Integer.parseInt(no)+1));    //3
		}else{
			return center_no+hall_no+"001";
		}
	}
	String addZero(int len,String target){
		String res = "";
		for(int i = 0;i<len-target.length();i++){
			res = res +"0";
		}
		return res+target;
	}
	public void updateVehicle(String no,String name, String engine, String chassis,
			String join_time) {
		data.deleteVehicle(no);
		data.addVehicle(new Vehicle(name,engine,no,chassis,join_time));
	}

	public void deleteVehicle(String no) {
		data.deleteVehicle(no);
	}

	public void addDriver(String name, String birthday, String indentity,
			String phone, String unit, String sex, String join_time) {
		String no = getDriverNo("235","001");
		Vehicle_Driver driver = new Vehicle_Driver(no,name,birthday,indentity,phone,unit,sex,join_time);
		data.addDriver(driver);
	}
	String getDriverNo(String center_no,String hall_no){
		ArrayList<String> noList = data.getDriverNoList(hall_no);
		if(noList.size()!=0){
			String no = noList.get(noList.size()-1).substring(6);
			return center_no+hall_no+addZero(3,String.valueOf(Integer.parseInt(no)+1));    //3
		}else{
			return center_no+hall_no+"001";
		}
	}

	public ArrayList<CollectionVO> getCollectionByDate(Date date) {
		String d = date.getYear()+"-"+date.getMonth()+"-"+date.getDay();
		return data.getCollectionByDate(d);
	}

}
