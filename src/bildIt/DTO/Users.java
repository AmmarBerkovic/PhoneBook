package bildIt.DTO;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String Ime;
	private String Prezime;
	private String Broj;
	private String Password;
	private int Id;
	private List<Contact> contacts = new ArrayList<>();

	private static List<Users> users = new ArrayList<>();
	private static int loggedId;

	public Users(int id, String ime, String prezime, String broj, String password, List<Contact> contacts) {
		this.Id = id;
		this.Ime = ime;
		this.Prezime = prezime;
		this.Password = password;
		this.Broj = broj;
		this.contacts = contacts;

	}

	public Users(int id, String ime, String prezime, String broj, String password) {
		this.Id = id;
		this.Ime = ime;
		this.Prezime = prezime;
		this.Password = password;
		this.Broj = broj;

	}

	/**
	 *
	 * @param id   orijentir po kojem se trazi id
	 * @param list lista u kojoj se trazi objekt tipa Users
	 * @return Returns clan collekcije list kojem je id 3
	 */
	///pokusaj s mapom
	public static Users findById(int id, List<Users> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		return null;
	}

	public List<Users> findByName(String str) {
		List<Users> list = new ArrayList<>();
		for (int i = 0; i < this.getContacts().size(); i++) {
			if (findById(this.getContacts().get(i).getFore(), users).getIme().equals(str)) {
				list.add(findById(this.getContacts().get(i).getFore(), users));
			}
		}
		return list;
	}

	// provjerava da li se podatci podudaraju sa odredjenom metodom
	public static void confLog(String name, String password, List<Users> list) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getIme()) && password.equals(list.get(i).getPassword())) {
				Users.setLoggedId(users.get(i).getId());
			}
		}
	}

	public void delete(int choose) {
		for (int i = 0; i < this.getContacts().size(); i++) {
			if (choose == this.getContacts().get(i).getFore()) {
				this.getContacts().remove(i);
			}
		}
	}

	// adding contact to userlist
	public static void adding(List<Contact> list, Contact cont) {
		list.add(cont);
	}

	// adding users to user list
	public static void adding(List<Users> list, Users user) {
		list.add(user);
	}

	public void update(String coll, String chose) {
		switch (coll) {
		case "ime":
			this.setIme(chose);
			break;
		case "prezime":
			this.setPrezime(chose);
			break;
		case "broj":
			this.setBroj(chose);
			break;
		case "password":
			this.setPassword(chose);
			break;
		}
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		this.Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		this.Prezime = prezime;
	}

	public String getBroj() {
		return Broj;
	}

	public void setBroj(String broj) {
		this.Broj = broj;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public static List<Users> getUsers() {
		return users;
	}

	public static void setUsers(List<Users> users) {
		Users.users = users;
	}

	public static int getLoggedId() {
		return loggedId;
	}

	public static void setLoggedId(int loggedId) {
		Users.loggedId = loggedId;
	}

}
