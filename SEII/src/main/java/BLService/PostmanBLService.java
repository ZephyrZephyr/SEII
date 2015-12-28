package BLService;

import vo.ArriveVO;
import words.Address;
import words.Date;
import words.DeliveryType;

public interface PostmanBLService {
	public abstract String getTotalPrice(Address departure,Address destination,DeliveryType dtype,String weight);
	public abstract ArriveVO getArriveTime(Address departure,Address destination,Date departure_time);
	public abstract String getTicketNo();
}
