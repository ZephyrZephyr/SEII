package BLService;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CostAndIncome;
import vo.DepartmentAccountVO;
import vo.ReceiptVO;
import vo.Receipt_SimpleVO;
import vo.StaffVO;
import words.Date;

public interface CompanyBLService {
	public abstract String getTotalPrice(ArrayList<ReceiptVO> receiptList);
	public abstract CostAndIncome getCostAndIncome(Date date);
	public abstract void addAccount(String name);
	public abstract ArrayList<AccountVO> getAccountByName(String name);
	public abstract DepartmentAccountVO getDepAccountByName(String name);
	public abstract void initAccount(String name);
	public abstract void changeSalary(String staffId,String salary);
	public abstract void moveStaff(String staffId,String newDep);
	public abstract void updateDepartment(String depId,String newName,String newManager,String newParent);
	public abstract ArrayList<StaffVO> getStaffByDepartment(String departmentName);
	public abstract void addAmountIntoAccount(String name,String amount);
	public abstract ArrayList<String> getStaffByAccount(String name);
	public abstract ArrayList<String> getCarsByAccount(String name);
}
