package BankSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Client implements Serializable {

	protected int id;
	protected String name;
	protected float balance;
	protected ArrayList<Account> accounts = new ArrayList<>();
	protected final float commissionRate;
	protected final float interestRate;

	public Client(float commissionRate, float interestRate) {
		this.commissionRate = commissionRate;
		this.interestRate = interestRate;
	}

	public Client(int id, String name, float balance, float commissionRate, float interestRate) {

		setId(id);
		setName(name);
		setBalance(balance);
		this.commissionRate = commissionRate;
		this.interestRate = interestRate;

	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;

	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void addAccount(Account acc) {
		final int accountIndex = accounts.indexOf(acc);
		if (accountIndex >= 0) {
			System.out.println("This account already exists");
			return;
		} else {
			Log l1 = new Log(new Date().getTime(), acc.getId(), "account update - account added",
					acc.getBalance());
			Logger.log(l1);
			accounts.add(acc);
		}

	}

	public Account getAccount(int id) {
		for (int i = 0; i < accounts.size(); i++) {
			Account curAcc = accounts.get(i);
			if (curAcc.getId() == id) {
				return curAcc;
			}
		}
		System.out.println("Account does not exist");
		return null;
	}

	public void removeAccount(Account acc) {
		int indexOfAcc = accounts.indexOf(acc);
		if (indexOfAcc >= 0) {
			Log l1 = new Log(new Date().getTime(), acc.getId(), "The Account has been removed", acc.getBalance());
			Logger.log(l1);
		} else {

			System.out.println("Account id does not exist");
		}
	}

	public void deposit(float amount) {
		setBalance(getBalance() + (amount - amount * getCommissionRate()));
	}

	public void withdraw(float amount) throws WithDrawException {
		float commission = amount * getCommissionRate();
		if (amount + commission > getBalance())
			throw new WithDrawException(getId(), getBalance(), amount, "withdraw exception");
		Bank.updateTotalCommission(commission);
		setBalance(getBalance() - (amount + commission));
	}

	public void autoUpdateAccounts() {
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			account.setBalance(account.getBalance() + account.getBalance() * getInterestRate());
			Log l1 = new Log(new Date().getTime(), account.getId(), "The interest has been added",
					account.getBalance() * getInterestRate());
			Logger.log(l1);
		}
	}

	public float getFortune() {
		float sum = getBalance();
		for (int i = 0; i > accounts.size(); i++) {
			sum += accounts.get(i).getBalance();
		}
		return sum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			return this.id == ((Client) obj).id;
		}

		return false;

	}
}
