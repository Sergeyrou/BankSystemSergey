package BankSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import javax.lang.model.type.NullType;

public class Bank {
	private float balance;
	private static Bank instance = new Bank();
	ArrayList<Client> clients;

	private static float totalCommision = 0;

	private Bank() {
		clients = new ArrayList<Client>();
		load();
	}

	public static Bank getInstance() {
		return instance;
	}

	public float getBalance() {
		float sum = 0;
		for (int i = 0; i < clients.size(); i++) {
			sum += clients.get(i).getFortune();
		}
		return sum;

	}

	public void setBalance(float Balance) {
		this.balance = getBalance() + totalCommision;

	}

	public void addClient(Client c1) {
		clients.add(c1);
		Log Moshe = new Log(new Date().getTime(), c1.getId(), "Account update - change balance", c1.getFortune());
		Logger.log(Moshe);

	}

	public void removeClient(Client client) {
		final int clientIndex = clients.indexOf(client);
		if (clientIndex != -1) {
			Log Moshe = new Log(new Date().getTime(), client.getId(), "Account update - removed account",
					client.getFortune());
			Logger.log(Moshe);
			clients.remove(clientIndex);
		} else {
			System.out.println("Id does not exist");
		}

	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void viewLogs() {

	}

	public void startAccountUpdater() {

	}

	public static void updateTotalCommission(float commission) {
		totalCommision += commission;
	}

	public void printClientList() {
		for (Client client : clients) {
			System.out.println(client.toString());

		}
	}

	@Override
	public String toString() {
		return "Bank [balance=" + balance + ", clients=" + Arrays.toString(clients.toArray()) + "]";
	}

	public void store() throws IOException {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			File myDataFile = new File("c:/moshe/bank.data");
			if (!myDataFile.exists()) {
				myDataFile.createNewFile();
			}
			fileOutputStream = new FileOutputStream(myDataFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (Client client : clients) {
				objectOutputStream.writeObject(client);
			}

			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			File myDataFile = new File("c:/moshe/bank.data");
			if (!myDataFile.exists()) {
				myDataFile.createNewFile();
				return;
			}

			FileInputStream fileInputStream = new FileInputStream(myDataFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Object object;
			ArrayList<Client> clientList = new ArrayList<>();
			while ((object = objectInputStream.readObject()) != null) {
				clientList.add((Client) object);
			}
			clients = (ArrayList<Client>) Collections.checkedList(clientList, Client.class);

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Could not load from bank data");
			e.printStackTrace();
		}

	}
}
