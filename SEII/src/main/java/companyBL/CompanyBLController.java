package companyBL;

import java.sql.SQLException;
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
		try {
			data = new CompanyData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTotalPrice(ArrayList<ReceiptVO> receiptList) {
		double price = 0;
		for(int i = 0;i<receiptList.size();i++){
			price += Double.parseDouble(receiptList.get(i).getAmount());
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

	public ArrayList<StaffVO> getStaffByDepartment(String departmentName) {
		return data.getStaffByDep(departmentName);
	}

	public void addAmountIntoAccount(String name,String amount) {
		data.saveAmountIntoAccount(name, String.valueOf(Double.parseDouble(amount)+Double.parseDouble(data.getAmountByExactName(name))));
	}

	public ArrayList<String> getStaffByAccount(String name) {
		String[] temps = name.split(".");
		String dep = temps[2];
		return data.getStaffByDepartment(dep);
	}

	public ArrayList<String> getCarsByAccount(String name) {
		String[] temps = name.split(".");
		String dep = temps[2];
		return data.getCarsByDepartment(dep);
	}
}
