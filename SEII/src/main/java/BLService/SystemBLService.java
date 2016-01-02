package BLService;

import words.Login;

public interface SystemBLService {
	public abstract Login judgeLogin(String id,String password);
}
