package BankSystem;

import java.util.Date;

public class Log {

	private long timestamp;
	private int clientId;
	private String description;
	private float amount;


	public Log(long timestamp, int clientId, String description, float amount) {
		setTimestamp(timestamp);
		setClientId(clientId);
		setDescription(description);
		setAmount(amount);
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		
		return "Log [Current date=" + new Date(this.getTimestamp()) + ", getClientId()=" + getClientId() + ", getDescription()="
				+ getDescription() + ", getAmount()=" + getAmount() + "]";
	}

}
