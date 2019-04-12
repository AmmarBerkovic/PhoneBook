package bildIt.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class DML {
	private static String query;

	public static void insertIntoUsers(Users user) throws SQLException {
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

	public static void deleteUser(int id) throws SQLException {
		query = "delete from user"+Users.getLoggedId()+" where Kontakt ="+id;
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
		} finally {
			ConnectionManager.getInstance().close();
		}
		
	}
	public static void update(String kolona,String promjena) throws SQLException {
		query ="UPDATE users SET "+kolona+"='"+promjena+"' Where id="+Users.getLoggedId();
		System.out.println();
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
		} finally {
			ConnectionManager.getInstance().close();
		}
	}

	public static void insertIntoContact(Contact cont) throws SQLException {
		query = "insert into user" + Users.getLoggedId() + " values (DEFFAULT," + cont.getFore() + ")";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				Statement stat = conn.createStatement();) {
			stat.executeUpdate(query);
		} finally {
			Users.adding(Users.findById(Users.getLoggedId(), Users.getUsers()).getContacts(), cont);
			ConnectionManager.getInstance().close();
		}
	}

	// kreiranje tabele za novog usera
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
