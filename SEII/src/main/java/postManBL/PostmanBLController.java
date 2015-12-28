package postManBL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import data.PostmanData;
import dataService.PostmanDataService;
import vo.ArriveVO;
import words.Address;
import words.Date;
import words.DeliveryType;
import BLService.PostmanBLService;

public class PostmanBLController implements PostmanBLService{

	public String getTotalPrice(Address departure, Address destination,DeliveryType dtype,String weight) {
		String from_center = getCenterByAddress(departure);
		String to_center = getCenterByAddress(destination);
		double result = Double.parseDouble(weight)*23* (getKmByCenters(from_center,to_center)/1000);
		if(dtype.equals(DeliveryType.economy)){
			return String.valueOf((result/23)*18);
		}else if(dtype.equals(DeliveryType.standard)){
			return String.valueOf(result);
		}else{
			return String.valueOf((result/23)*25);
		}
	}
	String getCenterByAddress(Address add){
		String province = add.getProvince();
		if(province.equalsIgnoreCase("Beijing")){
			return "Beijing";
		}else if(province.equalsIgnoreCase("Shanghai")){
			return "Shanghai";
		}else if(province.equalsIgnoreCase("Guangdong")){
			return "Guangzhou";
		}else{
			return "Nanjing";
		}
	}
	double getKmByCenters(String from,String to){
		if(from.equals("Beijing")){
			if(to.equals("Shanghai")){
				return 1064.7;
			}else if(to.equals("Guangzhou")){
				return 1888.8;
			}else{
				return 900.0;
			}
		}else if(from.equals("Shanghai")){
			if(to.equals("Beijing")){
				return 1064.7;
			}else if(to.equals("Guangzhou")){
				return 1213;
			}else{
				return 266;
			}
		}else if(from.equals("Guangzhou")){
			if(to.equals("Beijing")){
				return 1888.8;
			}else if(to.equals("Shanghai")){
				return 1213;
			}else{
				return 1132;
			}
		}else{
			if(to.equals("Beijing")){
				return 900;
			}else if(to.equals("Shanghai")){
				return 266;
			}else{
				return 1132;
			}
		}
	}
	public ArriveVO getArriveTime(Address departure, Address destination,Date departure_time) {
		PostmanDataService data;
		try {
			data = new PostmanData();
			ArrayList<String> timeList = data.getArriveTimeList(departure, destination);
			String use_days = getAverageDays(timeList);
			String arriveDate = computeArrivetime(departure_time,use_days);
			ArriveVO result = new ArriveVO(departure.getProvince()+departure.getCity(), destination.getProvince()+destination.getCity(),
					departure_time.getYear()+"-"+departure_time.getMonth()+"-"+departure_time.getDay(),arriveDate, use_days);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	String getAverageDays(ArrayList<String> list){
		int len = list.size();
		int result = 0;
		if(len==0){
			return "0";
		}else{
			for(int i = 0;i<len;i++){
				result += Integer.parseInt(list.get(i));
			}
			return String.valueOf(result/len);
		}
	}
	String computeArrivetime(Date departure_time,String averagedays){
		Date result = departure_time.addDays(averagedays);
		return result.getYear()+"-"+result.getMonth()+"-"+result.getDay();
	}
	public String getTicketNo() {
		PostmanDataService data;
		try {
			data = new PostmanData();
			ArrayList<String> tickets = data.getTicketIdList();
			Calendar c = Calendar.getInstance();	
			String year = String.valueOf(c.get(Calendar.YEAR));
			String month = String.valueOf(Integer.parseInt(String.valueOf(c.get(Calendar.MONTH)))+1);
			
			//Calendar.Month 是 0,1,2,...,11
			
			String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			System.out.println(year+month+day);
			if(tickets.size()!=0){
				String last = tickets.get(tickets.size()-1);
				String date = last.substring(0,8);
				
				String y = date.substring(0, 4);
				String m = date.substring(4, 6);
				String d = date.substring(6, 8);
		
				if(year.equals(y)&&month.equals(m)&&day.equals(d)){
					return date+addZero(2,String.valueOf(Integer.parseInt(last.substring(8))+1)); //2
				}else{
					return year+month+day+"01";
				}
			}
			return year+month+day+"01";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	String addZero(int len,String target){
		String res = "";
		for(int i = 0;i<len-target.length();i++){
			res = res +"0";
		}
		return res+target;
	}
}
