package bildIt.DTO;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String ime;
	private String prezime;
	private String broj;
	private String password;
	private int id;
	private List<Contact> contacts = new ArrayList<>();

	private static List<Users> users = new ArrayList<>();
	private static int loggedId;

	public static int getLoggedId() {
		return loggedId;
	}

	public static void setLoggedId(int loggedId) {
		Users.loggedId = loggedId;
	}

	public Users(int id, String ime, String prezime, String broj, String password, List<Contact> contacts) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.password = password;
		this.broj = broj;
		this.contacts = contacts;

	}

	public Users(int id, String ime, String prezime, String broj, String password) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.password = password;
		this.broj = broj;

	}

	public static void Pokazi(List<Users> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Prvi: \nId - " + list.get(i).getPassword() + "\nIme - " + list.get(i).getIme()
					+ list.get(i).getContacts().get(0).getPrim());
		}
	}
	
	public static void taj(String name,String password,List<Users> list) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getIme()) && password.equals(list.get(i).getPassword())) {
				Users.setLoggedId(users.get(i).getId());
			}
		}
	}

	public static void adding(List<Contact> list, Contact cont) {
		list.add(cont);
	}
	
	public static void adding(List<Users> list, Users user) {
		list.add(user);
	}

	// need insert
	public static void mapa() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<Users> getUsers() {
		return users;
	}

	public static void setUsers(List<Users> users) {
		Users.users = users;
	}

}
