package deliveryCenterStockBL;

import java.util.ArrayList;

import data.DeliveryCenterStockData;
import dataService.DeliveryCenterStockDataService;
import vo.AlarmVO;
import vo.InventoryCheckVO;
import vo.InventoryCountVO;
import vo.TotalWarehouseVO;
import BLService.DeliveryCenterStockBLService;

public class DeliveryCenterStockBLController implements DeliveryCenterStockBLService{

	public TotalWarehouseVO getTotalWarehouse(ArrayList<InventoryCheckVO> invClist) {
		double in = 0;
		double ex = 0;
		for(int i = 0;i<invClist.size();i++){
			InventoryCheckVO temp = invClist.get(i);
			if(temp.getInOrOut().equalsIgnoreCase("in")){
				in += Double.parseDouble(temp.getAmount());
			}else{
				ex += Double.parseDouble(temp.getAmount());
			}
		}
		return new TotalWarehouseVO(String.valueOf(in),String.valueOf(ex));
	}

	public void exportInventoryCount(ArrayList<InventoryCountVO> invClist) {
		DeliveryCenterStockDataService data = new DeliveryCenterStockData();
		data.ExportInventoryCountTable(invClist);
	}

	public ArrayList<AlarmVO> checkSituration(String percent,ArrayList<AlarmVO> alarmlist) {
		for(int i = 0;i<alarmlist.size();i++){
			AlarmVO temp = alarmlist.get(i);
			temp.setWarning(Double.parseDouble(temp.getSaturation())>=Double.parseDouble(percent)?true:false);
			alarmlist.set(i, temp);
		}
		return alarmlist;
	}

}
