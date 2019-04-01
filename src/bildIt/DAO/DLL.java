package bildIt.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class DLL {
	private static String query;

	// izvlacenje svih podataka sem imenika
	public static void MajorWithdraw(String str) throws SQLException {
		query = "Select * from " + str;
		try (Connection connection = ConnectionManager.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			while (rs.next()) {
				Users.getUsers().add(new Users(rs.getInt("Id"), rs.getString("Ime"), rs.getString("Prezime"),
						rs.getString("Broj"), rs.getString("Sifra")));
			}
		} finally {
			ConnectionManager.getInstance().close();
		}

	}

	// izvlacenje imenika za svakog usera
	public static void MinorWithdraw(List<Users> users) throws SQLException {
		for (int i = 0; i < users.size(); i++) {
			query = "Select * from user" + users.get(i).getId();
			try (Connection connection = ConnectionManager.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(query)) {
				while (rs.next()) {
					Users.adding(users.get(i).getContacts(), new Contact(rs.getInt("Id"), rs.getInt("Kontakt")));
				}
			} finally {
				ConnectionManager.getInstance().close();
			}
		}

	}

}
