package BLService;

import java.util.ArrayList;

import vo.AlarmVO;
import vo.InventoryCheckVO;
import vo.InventoryCountVO;
import vo.TotalWarehouseVO;

public interface DeliveryCenterStockBLService {
	public abstract TotalWarehouseVO getTotalWarehouse(ArrayList<InventoryCheckVO> invClist);
	public abstract void exportInventoryCount(ArrayList<InventoryCountVO> invClist);
	public abstract ArrayList<AlarmVO> checkSituration(String percent,ArrayList<AlarmVO> alarmlist);
}
