package bildIt.UI;

public class Strings {

	public static String menu() {
		return print(0, 1) + " 1 - Login\n 2 - Register\n 3 - Exit" + print(1, 0, 1, 2);
	}

	public static String exception(String error) {
		return print(0, 0, 0, 1) + "Error: " + error + print(1, 0, 0, 0, 1, 3);
	}

	public static String userMenu() {
		return print(0, 0, 1)
				+ "   1 - Add new contact\n   2 - Edit contact\n   3 - Delete Contact\n   4 - List all contact\n   5 - Find contact\n   6 - Log out"
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

}
