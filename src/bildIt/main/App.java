package bildIt.main;

import java.sql.SQLException;
import java.util.Scanner;

import bildIt.DAO.DLL;
import bildIt.DAO.DML;
import bildIt.DTO.Users;
import bildIt.UI.DataCollection;
import bildIt.UI.Strings;

public class App {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		DLL.MajorWithdraw("users");
		DLL.MinorWithdraw(Users.getUsers());
		menu();
	}

	public static void menu() throws SQLException {
		int choose = 0;
		while (choose != 3) {
			System.out.print(Strings.menu());
			choose = ScanInt();
			switch (choose) {
			case 1:
				if (DataCollection.login())
					userMenu();
				else
					System.out.println(Strings.exception("User not found!!"));
				break;
			case 2:
				DML.insertInto(DataCollection.register());
				break;
			default:
				Users.Pokazi(Users.getUsers());
				break;
			}
		}
	}

	public static void userMenu() {
		System.out.println("taj: "+Users.getLoggedId());
		System.out.println(Strings.userMenu());
		int choose = 0;
		while (choose != 6) {
			System.out.print(Strings.userMenu());
			choose = ScanInt();
			switch (choose) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}

	public static int ScanInt() {
		int cross = 0, broj = 0;
		do {
			try {
				broj = input.nextInt();
				cross = 1;
			} catch (Exception e) {
				input.next();
				System.out.print(Strings.exception("Input not acceptable!!!"));
			}
		} while (cross == 0);
		return broj;
	}

}
