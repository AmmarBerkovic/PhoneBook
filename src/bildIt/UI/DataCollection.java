package bildIt.UI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bildIt.BO.Checks;
import bildIt.DAO.DML;
import bildIt.DTO.Contact;
import bildIt.DTO.Users;

public class DataCollection {
	private static Scanner input = new Scanner(System.in);

	public static Users register() {
		System.out.print("Set name!!! " + Strings.print(1, 2));
		String name = "", password = "", surname = "", number = "";
		do {
			name = input.next();
		} while (!Checks.compatibleLength(name, 20) || !Checks.noDigits(name) || !Checks.firstLetter(name));

		System.out.print("Set password: " + Strings.print(1, 2));
		do {
			password = input.next();
		} while (!Checks.compatibleLength(password, 20));

		System.out.print("Set surname: " + Strings.print(1, 2));
		do {
			surname = input.next();
		} while (!Checks.compatibleLength(surname, 20) || !Checks.noDigits(surname) || !Checks.firstLetter(surname));
		System.out.print("Set number: " + Strings.print(1, 2));
		do {
			number = input.next();
		} while (!Checks.onlyDigits(number));
		int id = 0;
		do {
			id = Users.getUsers().get(Users.getUsers().size() - 1).getId() + 1;
		} while (Checks.CompId(Users.getUsers(), id));
		return new Users(id, name, surname, number, password, new ArrayList<>());
	}

	public static boolean login() {
		String name = "", password = "";
		System.out.print("Enter name!!! " + Strings.print(1, 2));
		name = input.next();
		System.out.print("Enter password: " + Strings.print(1, 2));
		password = input.next();
		Users.confLog(name, password, Users.getUsers());
		if (Checks.init(Users.getUsers(), name, password))
			return true;
		else
			return false;

	}

	public static Contact pick() {
		Contact cont = new Contact();
		System.out.println(Strings.usersLoop(Users.getUsers()));
		int choose = input.nextInt();
		cont.setFore(choose);
		cont.setPrim(Users.getUsers().get(Users.getLoggedId()).getContacts().size() + 1);
		return cont;
	}

	public static void update() throws SQLException {
		System.out.print("Witch colloumn do you want to change: ");
		String coll = input.next();
		System.out.print("With what do you want to change it with: ");
		String change = input.next();
		DML.update(coll, change);
		Users.findById(Users.getLoggedId(), Users.getUsers()).update(coll, change);

	}

	public static void DeleteUserWithId() throws SQLException {
		System.out.println(Strings.witch());
		int choose = input.nextInt();
		Users.findById(Users.getLoggedId(), Users.getUsers()).delete(choose);
		DML.deleteUser(choose);
	}
	
	public static List<Users> findBy() {
		List<Users> list=new ArrayList<>();
		System.out.println("Insert colloumn: ");
		String coll=input.next();
		System.out.println("Insert key: ");
		String change=input.next();
		if(coll.equals("Ime")) {
			list.addAll(Users.findById(Users.getLoggedId(), Users.getUsers()).findByName(change));
		} else if(coll.equals("Prezime")) {
			list.addAll(Users.findById(Users.getLoggedId(), Users.getUsers()).findBySurname(change));
		} else if(coll.equals("Broj")) {
			list.addAll(Users.findById(Users.getLoggedId(), Users.getUsers()).findByNumber(change));
		} else {
			System.out.println("Colloumn not found!!!");
		}
		return list;
	}

}
