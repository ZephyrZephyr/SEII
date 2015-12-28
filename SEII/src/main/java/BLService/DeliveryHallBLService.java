package BLService;

import java.util.ArrayList;

import vo.CollectionVO;
import words.Date;

public interface DeliveryHallBLService {
	public abstract void addVehicle(String name,String engine,String chassis,String join_time);
	public abstract void updateVehicle(String no,String name,String engine,String chassis,String join_time);
	public abstract void deleteVehicle(String no);
	
	public abstract void addDriver(String name,String birthday,String indentity,
			String phone,String unit,String sex,String join_time);
	
	//search 方法就在当前表单中找到目标，找到后标注即可。
	public abstract ArrayList<CollectionVO> getCollectionByDate(Date date);
}
