package bildIt.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bildIt.BO.Checks;
import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class DataCollection {
	private static Scanner input = new Scanner(System.in);

	public static Users register() {
		System.out.print("Set name!!! " + Strings.print(1, 2));
		String name = "", password = "", surname = "", number = "";
		do {
			name = input.next();
		} while (Checks.compatibleLength(name, 20) && Checks.noDigits(name) && Checks.firstLetter(name));

		System.out.print("Set password: " + Strings.print(1, 2));
		do {
			password = input.next();
		} while (Checks.compatibleLength(password, 20));

		System.out.print("Set surname: " + Strings.print(1, 2));
		do {
			surname = input.next();
		} while (Checks.compatibleLength(surname, 20) && Checks.noDigits(surname) && Checks.firstLetter(name));
		System.out.print("Set number: " + Strings.print(1, 2));
		do {
			number = input.next();
		} while (Checks.onlyDigits(number));
		int id = 0;
		do {
			id = Users.getUsers().get(Users.getUsers().size() - 1).getId() + 1;
		} while (Checks.CompId(Users.getUsers(), id));
		List<Contact> list = new ArrayList<>();
		return new Users(id, name, surname, number, password, list);
	}

	public static boolean login() {
		String name = "", password = "";
		System.out.print("Enter name!!! " + Strings.print(1, 2));
		name = input.next();
		System.out.print("Enter password: " + Strings.print(1, 2));
		password = input.next();
		Users.taj(name, password, Users.getUsers());
		if (Checks.init(Users.getUsers(), name, password))
			return true;
		else
			return false;

	}

	public static String table() {
		System.out.print("Enter the name of the table: ");
		return input.next();
	}

}
