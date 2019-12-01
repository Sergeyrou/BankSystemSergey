package BankSystem;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// SetBalance
		Account account = new Account(123, 5000);
		account.setBalance(1000);
		System.out.println(account);
		// getInstance
		System.out.println(Bank.getInstance());
		// GoldClient
		GoldClient goldClient = new GoldClient(421, "vanya", 214);
		System.out.println(goldClient);
		PlatinumClient platinumClient = new PlatinumClient(124, "dafd", 1453);
		System.out.println(platinumClient);

		Date myDate = new Date();
		System.out.println(myDate);
		
	}
}
