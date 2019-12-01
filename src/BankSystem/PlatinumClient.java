package BankSystem;

public class PlatinumClient extends Client {

	public PlatinumClient(int id,String name,float balance) {
		super(id, name, balance, 0.01f, 0.005f);
	}

	@Override
	public String toString() {

		return "Platinum-" + this.getId();
	}
}
