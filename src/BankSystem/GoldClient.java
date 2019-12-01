package BankSystem;

import java.util.Arrays;

public class GoldClient extends Client {

	public GoldClient(int id,String name,float balance) {
		super(id, name, balance, 0.01f, 0.005f);
	}

	@Override
	public String toString() {
		return "GoldClient [id=" + id + ", name=" + name + ", balance=" + balance + ", accounts="
				+ Arrays.toString(accounts.toArray()) + ", commissionRate=" + commissionRate + ", interestRate=" + interestRate
				+ "]";
	}

}
