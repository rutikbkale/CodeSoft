import java.util.Scanner;

public class StudentGC {

//	Declaring variables
	static private int rollno;
	static private String name;
	static private int noSub;
	static private int[] marks;
	static private int total = 0;
	static private float percentage;
	static private String grade;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Tacking student input
		System.out.println("Enter the Student Roll Number : ");
		rollno = sc.nextInt();
		System.out.println("Enter the Student Name : ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("Number of subjects : ");
		noSub = sc.nextInt();

//		Tacking student marks
		marks = new int[noSub];
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter the marks for " + (i + 1) + " subject : ");
			marks[i] = sc.nextInt();
		}

//		Displaying Result
		System.out.println("\n------------------------- Student Result -------------------------\n\n");
		System.out.println("Student Roll No is : \t\t" + rollno);
		System.out.println("Student Name is : \t\t\t" + name);
		total = getTotalMarks(marks);
		System.out.println("Student Total Marks : \t\t" + total);
		percentage = getPercentage(total);
		System.out.println("Student Percentage : \t\t" + percentage);
		grade = getGrade(percentage);
		System.out.println("Student Grade : \t\t\t" + grade);
	}

//	Calculating Total
	static int getTotalMarks(int marks[]) {
		for (int i = 0; i < marks.length; i++) {
			total += marks[i];
		}
		return total;
	}

//	Calculating Percentage
	static float getPercentage(int total) {
		percentage = (float)total / noSub;
		return percentage;
	}

//	Calculating Grade
	static String getGrade(float per) {
		if (per > 85 && per <= 100)
			return "Distinction";
		else if (per > 75 && per <= 85)
			return "A+";
		else if (per > 65 && per <= 75)
			return "A";
		else if (per > 50 && per <= 65)
			return "B";
		else if (per > 35 && per <= 50)
			return "C";
		return "fail";
	}
}
