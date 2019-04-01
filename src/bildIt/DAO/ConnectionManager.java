package bildIt.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private Connection connection = null;
	// podatci potrebni za konektovanje sa sqlom
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Password123!";
	private static final String CONN_STRING = "jdbc:mysql://localhost/phonebook?useSSL=false&serverTimezone=UTC";
	private static ConnectionManager instance = null;

	// privatni konstruktor - klasa moze biti instancirana samo unutar sebe
	private ConnectionManager() {

	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Konekcija otvorena.");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		System.out.println("Konekcija zatvorena.");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}

}
