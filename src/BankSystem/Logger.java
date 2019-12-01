package BankSystem;

import java.util.ArrayList;

public class Logger {

	private String driverName;

	public Logger(String driverName) {

		setDriverName(driverName);
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public static void log(Log log) {
		log.toString();
	}

	public ArrayList<Log> getLogs() {
		return new ArrayList<Log>();
	}
}
