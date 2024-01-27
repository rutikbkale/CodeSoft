import java.util.Random;
import java.util.Scanner;

class NumberGame {

	static Random rand = new Random();
	static int systemNum, flag, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		systemNum = rand.nextInt(100);
		flag = 1;
		count = 0;
		do {
			System.out.println("Enter your Guess : ");
			int userNum = sc.nextInt();
			if (userNum > systemNum) {
				System.out.println("Your Guess is big..");
				count++;
			} else if (userNum < systemNum) {
				System.out.println("Your Guess is small");
				count++;
			} else {
				count++;
				System.out.println("You won the game ..... With " + count + " Guesses.");
				System.out.println("Do you want to play Again ?(Y/N)");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					reset();
				} else {
					flag = 0;
					System.out.println("Thanks for playing ...");
				}
			}
		} while (flag == 1);
	}

	static void reset() {
		count = 0;
		flag = 1;
		systemNum = rand.nextInt(100);
	}

}