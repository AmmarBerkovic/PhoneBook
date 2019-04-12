package bildIt.UI;

import java.util.ArrayList;
import java.util.List;

import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class Strings {

	public static String menu() {
		return print(0, 1) + " 1 - Login\n 2 - Register\n 3 - Exit" + print(1, 0, 1, 2);
	}

	public static String exception(String error) {
		return print(0, 0, 0, 1) + "Error: " + error + print(1, 0, 0, 0, 1, 3);
	}

	public static String userMenu() {
		return print(0, 0, 1)
				+ "   1 - Add new contact\n   2 - Edit account\n   3 - Delete Contact\n   4 - List all contact\n   5 - Find contact\n   6 - Log out"
				+ print(1, 0, 0, 1, 2);
	}

	public static String print(int... numbers) {
		String str = "";
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 0:
				str += "=============";
				break;
			case 1:
				str += "\n";
				break;
			case 2:
				str += "Input: ";
				break;
			case 3:
				str += "Try again: ";
				break;
			}
		}
		return str;
	}

	public static String usersLoop(List<Users> list) {
		String text = "";
		for (int i = 0; i < list.size(); i++) {
			text += print(0, 0, 0, 1) + "Id - " + list.get(i).getId() + "|| Ime - " + list.get(i).getIme()
					+ " ||Prezime - " + list.get(i).getPrezime() + print(1);
		}
		text += print(0, 0, 0, 1, 2);
		return text;
	}

	public static String contactLoop(List<Contact> list) {
		String text = "";
		List<Integer> Ids = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Ids.add(list.get(i).getFore());
		}
		for (int i = 0; i < Ids.size(); i++) {
			for (int j = 0; j < Users.getUsers().size(); j++) {
				if (Users.getUsers().get(j).getId() == Ids.get(i)) {
					text += print(0, 0, 0, 1) + "Ime: " + Users.getUsers().get(j).getIme() + " ||Prezime - "
							+ Users.getUsers().get(j).getPrezime() + " ||Broj - " + Users.getUsers().get(j).getBroj()+"\n";
					break;
				}
			}
		}

		return text;
	}
	public static String contLoop(List<Contact> list) {
		String text = "";
		List<Integer> Ids = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Ids.add(list.get(i).getFore());
		}
		for (int i = 0; i < Ids.size(); i++) {
			for (int j = 0; j < Users.getUsers().size(); j++) {
				if (Users.getUsers().get(j).getId() == Ids.get(i)) {
					text += print(0, 0, 0, 1) + "Ime: " + Users.getUsers().get(j).getIme() + " ||Prezime - "
							+ Users.getUsers().get(j).getPrezime() + " ||Id - " + Users.getUsers().get(j).getId();
					break;
				}
			}
		}

		return text;
	}
	public static String witch(){
		return "Pick Id:\n"+Strings.contLoop(Users.findById(Users.getLoggedId(), Users.getUsers()).getContacts());
		
	}

}
