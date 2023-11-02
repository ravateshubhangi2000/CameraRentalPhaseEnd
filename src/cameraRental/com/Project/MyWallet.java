package cameraRental.com.Project;

public class MyWallet {
private int myBalance = 10000;
	
	public void creditAmount(float amount) {
		myBalance += amount;
	}
	
	public void debitAmount(float amount) {
		myBalance -= amount;
	}

	public int getMyBalance() {
		return myBalance;
	}	
	

}
