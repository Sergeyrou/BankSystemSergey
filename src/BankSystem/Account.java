package BankSystem;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private float balance;

	

	public Account(int id, float balance) {

		setId(id);
		setBalance(balance);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float bal) {
		Log Moshe = new Log(new Date().getTime(), getId(), "Account update - change balance", bal);
		Logger.log(Moshe);
		this.balance = bal;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			return this.id == ((Account) obj).id;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	
	
	
}
