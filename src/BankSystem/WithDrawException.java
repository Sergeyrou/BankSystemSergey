package BankSystem;

@SuppressWarnings("serial")
public class WithDrawException extends Exception {

	private int clientId;
	private float currentBalance;
	private float withDrawAmount;
	

	public WithDrawException(int clientId, float currentBalance, float withDrawAmount, String message) {
		super(message);
		this.clientId = clientId;
		this.currentBalance = currentBalance;
		this.withDrawAmount = withDrawAmount;
	}

	public int getClientId() {
		return clientId;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public float getWithDrawAmount() {
		return withDrawAmount;
	}
	

}
