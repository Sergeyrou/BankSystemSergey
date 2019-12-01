package BankSystem;

public class RegularClient extends Client {

	/*
	 * public RegularClient(int id, String name, float balance, Account[] accounts,
	 * float commissionRate, float interestRate, Logger lg) { super(id, name,
	 * balance, accounts, 0.03f, interestRate, lg);
	 * 
	 * }
	 */

	public RegularClient(int id,String name,float balance) {
		super(id, name, balance, 0.01f, 0.005f);
	}

	@Override
	public String toString() {

		return "Regular-" + this.getId();
	}

}
