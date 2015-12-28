package companyBL;

import java.util.ArrayList;

import data.CompanyData;
import dataService.CompanyDataService;
import vo.AccountVO;
import vo.CostAndIncome;
import vo.DepartmentAccountVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import vo.Receipt_SimpleVO;
import vo.StaffVO;
import words.Date;
import BLService.CompanyBLService;

public class CompanyBLController implements CompanyBLService{
	
	private CompanyDataService data;
	public CompanyBLController(){
		data = new CompanyData();
	}

	public String getTotalPrice(ArrayList<Receipt_SimpleVO> receiptList) {
		double price = 0;
		for(int i = 0;i<receiptList.size();i++){
			price += Double.parseDouble(receiptList.get(i).getPrice());
		}
		return String.valueOf(price);
	}

	public CostAndIncome getCostAndIncome(Date date) {
		
		return new CostAndIncome(getIncome(date),getCost(date));
	}
	String getCost(Date date){
		ArrayList<PaymentVO> paymentList = data.getPaymentlist(date);
		double cost = 0;
		for(int i = 0;i<paymentList.size();i++){
			cost += Double.parseDouble(paymentList.get(i).getAmount());
		}
		return String.valueOf(cost);
	}
	String getIncome(Date date){
		ArrayList<ReceiptVO> receiptList = data.getReceiptlist(date);
		double income = 0;
		for(int i = 0;i<receiptList.size();i++){
			income += Double.parseDouble(receiptList.get(i).getAmount());
		}
		return String.valueOf(income);
	}

	public void addAccount(String name) {
		data.addAccount(new Account(name));
	}

	public ArrayList<AccountVO> getAccountByName(String name) {
		ArrayList<Account> accountList = data.getAccountList();
		ArrayList<AccountVO> res = new ArrayList<AccountVO>();
		for(int i=0;i<accountList.size();i++){
			Account temp = accountList.get(i);
			if(temp.getName().contains(name)){
				res.add(new AccountVO(temp.getName(),temp.getAmount()));
			}
		}
		return res;
	}

	public DepartmentAccountVO getDepAccountByName(String name) {
		Account account = data.getAccountByName(name);
		String dep = account.getDepartment();
		return new DepartmentAccountVO(dep,account.getAmount(),data.getStaffByDepartment(dep),data.getCarsByDepartment(dep));
	}

	public void initAccount(String name) {
		data.initAccount(name);		
	}

	public void changeSalary(String staffId, String salary) {
		data.updateSalary(staffId, salary);
	}

	public void moveStaff(String staffId, String newDep) {
		data.changeStaffDep(staffId, newDep);
	}

	public void updateDepartment(String depId, String newName,
			String newManager, String newParent) {
		data.updateDepartment(depId, newName, newManager, newParent);
	}

	public ArrayList<StaffVO> getStaffByDepartment(String departmentId) {
		return data.getStaffByDep(departmentId);
	}
}
