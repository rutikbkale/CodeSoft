import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ATM {

	private static boolean flag;
	private static int ch, actNo, pin, amount;
	private static Connection con = DBClass.getConnect();
	private static Statement smt = null;
	private static PreparedStatement psmt = null;
	private static ResultSet set = null;
	private static String query = null;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		// Enter user info for validity
		System.out.println("Enter Account NO : ");
		actNo = sc.nextInt();
		System.out.println("Enter your PIN : ");
		pin = sc.nextInt();
		flag = isValidAct(actNo, pin);

		if (flag) {
			while (flag) {
				System.out.println(" \n\n------------------------- Welcome to the ATM -------------------------\n\n");
				System.out.println("1.For checking balance : ");
				System.out.println("2. For withdrawling amount : ");
				System.out.println("3. For depositing amount : ");
				System.out.println("4. Exit : \n");

				// Enter user operation
				System.out.println("Enter your choice : ");
				ch = sc.nextInt();

				switch (ch) {
				case 1:
					amount = getBalance(actNo);
					System.out.println("Your current balance is : "+amount);
					flag = isExit();
					break;

				case 2:
					System.out.println("Enter amount to withdraw : ");
					int wamount = sc.nextInt();
					withdrawAmount(wamount, actNo);
					flag = isExit();
					break;

				case 3:
					System.out.println("Enter amount to deposit : ");
					int damount = sc.nextInt();
					depositAmount(damount, actNo);
					flag = isExit();
					break;

				case 4:
					flag = false;
					break;

				default:
					System.out.println("Please Enter valid choice !");
					flag = isExit();

				}
			}
		} else {
			System.out.println("Sorry Please enter valid details ...");
		}

	}

	static boolean isValidAct(int actNo, int pin) throws Exception {
	    boolean isValid = false;
	    try (PreparedStatement psmt = con.prepareStatement("SELECT actNo, pin FROM bankaccount WHERE actNo = ? AND pin = ?")) {
	        psmt.setInt(1, actNo);
	        psmt.setInt(2, pin);
	        try (ResultSet rs = psmt.executeQuery()) {
	            isValid = rs.next(); // Check if a record was found
	        }
	    }
	    return isValid;
	}


	// for checking balance
	static int getBalance(int actNo) throws Exception {
		query = "select amount from bankaccount where actNo = " + actNo;
		smt = con.createStatement();
		set = smt.executeQuery(query);
		while (set.next()) {
			amount = set.getInt("amount");
		}
		return amount;
	}

	// for withdrawing amount
	static void withdrawAmount(int wamount, int actNo) throws Exception {
		query = "select amount from bankaccount where actNo = " + actNo;
		smt = con.createStatement();
		set = smt.executeQuery(query);
		while (set.next()) {
			amount = set.getInt("amount");
		}
		if (wamount > amount) {
			System.out.println("You don't have sufficient balance to withdraw .");
			System.out.println("Your current balance is : " + amount);
		} else {
			System.out.println(wamount + " RS has withdrawl successfully from your account .");
			amount = amount - wamount;
			System.out.println("Your current balance is : " + amount);
			query = "update bankaccount set amount = ? where actNo = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, amount);
			psmt.setInt(2, actNo);
			psmt.executeUpdate();
		}
	}

	// for depositing amount
	static void depositAmount(int damount, int actNo) throws Exception {
		query = "select amount from bankaccount where actNo = " + actNo;
		smt = con.createStatement();
		set = smt.executeQuery(query);
		while (set.next()) {
			amount = set.getInt("amount");
		}
		amount = amount + damount;
		System.out.println(
				"You have successfully depositing the amount " + damount + " .\nyour current balance is :" + amount);
		query = "update bankaccount set amount = ? where actNo = ?";
		psmt = con.prepareStatement(query);
		psmt.setInt(1, amount);
		psmt.setInt(2, actNo);
		psmt.executeUpdate();
	}

	// for exit
	static boolean isExit() {
		System.out.println("Do you want to continue (Y/N)?");
		char a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y')
			return true;
		else
			return false;
	}

}
