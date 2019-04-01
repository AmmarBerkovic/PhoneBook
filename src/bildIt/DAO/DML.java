package bildIt.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class DML {
	private static String query;

	public static void insertInto(Users user) throws SQLException {
		query = "insert into users values (" + user.getId() + ",'" + user.getIme() + "','" + user.getPrezime() + "','"
				+ user.getBroj() + "','" + user.getPassword() + "')";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
			ContactList(user);
		} finally {
			Users.adding(Users.getUsers(), user);
			ConnectionManager.getInstance().close();
		}

	}

	/// check code once more
	public static void insertInto(Users user, Contact cont) throws SQLException {
		query = "insert into user" + Users.getLoggedId() + " values (" + cont.getPrim() + "," + cont.getFore() + ")";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
		} finally {
			Users.adding(user.getContacts(), cont);
			ConnectionManager.getInstance().close();
		}
	}

	public static void ContactList(Users user) throws SQLException {
		query = "create table user" + user.getId() + "(Id integer auto_increment primary key," + "Kontakt integer,"
				+ "foreign key (Kontakt) references users (Id)" + "); ";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
		} finally {
			ConnectionManager.getInstance().close();
		}

	}

}
