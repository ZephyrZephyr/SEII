package systemBL;

import java.sql.SQLException;

import data.SystemData;
import dataService.SystemDataService;
import words.Login;
import BLService.SystemBLService;

public class SystemBLController implements SystemBLService{
	private SystemDataService data;
	public SystemBLController(){
		try {
			data = new SystemData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Login judgeLogin(String id, String password) {
		// TODO Auto-generated method stub
		return data.judgeLogin(id, password);
	}

}
