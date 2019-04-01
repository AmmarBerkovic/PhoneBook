package bildIt.BO;

import java.util.List;

import bildIt.DTO.Users;
import bildIt.UI.Strings;

public class Checks {
	public static boolean compatibleLength(String str, int range) {
		if (str.length() < range)
			return false;
		System.out.print(Strings.exception("String is longer than it sholud be!!!"));
		return true;
	}

	public static boolean noDigits(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				System.out.print(Strings.exception("String shoud not have digits!!!"));
				return true;
			}
		}
		return false;
	}

	public static boolean firstLetter(String str) {
		if (Character.isUpperCase(str.charAt(0)))
			return false;
		System.out.print(Strings.exception("String should have first letter uppercase"));
		return true;
	}

	public static boolean onlyDigits(String numbers) {
		for (int i = 0; i < numbers.length(); i++) {
			if (!Character.isDigit(numbers.charAt(i))) {
				System.out.print(Strings.exception("String shoud have only digits!!!"));
				return true;
			}
		}
		return false;
	}

	public static boolean CompId(List<Users> list, int id) {
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				counter++;
			}
		}
		if (counter != 0)
			return true;
		else
			return false;
	}

	public static boolean init(List<Users> list, String name, String pass) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getIme()) && pass.equals(list.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}

}
