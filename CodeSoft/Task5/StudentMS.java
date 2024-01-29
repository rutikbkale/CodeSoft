import java.util.*;

public class StudentMS {

	private static boolean flag = true;
	private static int rollNo;
	private static String name;
	private static int age;
	private static String gender;
	private static String grade;
	private static int res;
	private static Student std = null;
	private static ArrayList<Student> list = null;
	static StudentOperation op = new StudentOperation();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println(" \n--------------- WELCOME TO STUDENT MANAGEMENT SYSTEM ---------------\n\n ");

		while (flag) {
			System.out.println("1. Adding Student : ");
			System.out.println("2. Remove Student : ");
			System.out.println("3. Search Specific Student : ");
			System.out.println("4. Display All Student : \n");
			System.out.println("Enter your choice : ");

			// Validate input choice
			int ch = 0;
			ch = numInput(ch);
			if (ch == 0) {
				System.out.println("Invalid input! Please enter a valid number.");
				sc.next(); // Clear the invalid input
			}
			switch (ch) {
			case 1:
				// Add Student
				System.out.println("\n ENTER STUDENT DETAILS : \n");
				System.out.print("Roll No : ");
				// Validate input rollNo
				rollNo = numInput(rollNo);
				if (rollNo == 0) {
					System.out.println("Invalid input! Please enter a valid number for Roll No.");
					sc.next(); // Clear the invalid input
				}

				System.out.print("Name : ");
				// Validate input name
				while (true) {
					sc.nextLine();
					name = sc.nextLine();
					if (name.matches("^[a-zA-Z\\s]+$")) {
						break;
					} else {
						System.out.println("Invalid input! Name should not contain numbers or special characters.");
					}
				}

				System.out.print("Age : ");
				// Validate input age
				age = numInput(age);
				if (age == 0) {
					System.out.println("Invalid input! Please enter a valid number for Age.");
					sc.next(); // Clear the invalid input
				}

				System.out.print("Gender : ");
				// Validate input gender
				while (true) {
					sc.nextLine();
					gender = sc.nextLine();
					if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")
							|| gender.equalsIgnoreCase("other")) {
						break;
					} else {
						System.out.println("Invalid input! Gender should be 'male', 'female', or 'other'.");
					}
				}

				System.out.print("Grade : ");
				// Validate input grade
				while (true) {
					grade = sc.nextLine();
					if (!grade.isEmpty() && !grade.matches(".*\\d.*")) {
						break;
					} else {
						System.out.println("Invalid input! Grade should not be empty or contain numbers.");
					}
				}

				std = new Student(rollNo, name, age, gender, grade);
				res = op.saveStudent(std);
				if (res > 0) {
					System.out.println("Student Record has been saved successfully .....");
					flag = isExit();
				} else {
					System.out.println("Something went wrong !!!");
				}
				break;

			case 2:
				System.out.println("Enter that student Roll No you want to delete : ");
				// Validate input rollNo
				rollNo = numInput(rollNo);
				if (rollNo == 0) {
					System.out.println("Invalid input! Please enter a valid number for Roll No.");
					sc.next(); // Clear the invalid input
				}
				res = op.removeStudent(rollNo);
				if (res > 0) {
					System.out.println("Student Record has been removed successfully .....");
				} else {
					System.out.println("Something went wrong !!!");
				}
				flag = isExit();
				break;

			case 3:
				System.out.println("Enter that student Roll No you want to search : ");
				// Validate input rollNo
				rollNo = numInput(rollNo);
				if (rollNo == 0) {
					System.out.println("Invalid input! Please enter a valid number for Roll No.");
					sc.next(); // Clear the invalid input
				}
				std = op.searchStudent(rollNo);
				if (std.getRollNo() > 0) {
					System.out.println("\n--------------- STUDENT DETAIL ---------------\n");
					System.out.println("Student RollNo is : \t\t" + std.getRollNo());
					System.out.println("Student Name is : \t\t" + std.getName());
					System.out.println("Student Age is : \t\t" + std.getAge());
					System.out.println("Student Gender is : \t\t" + std.getGender());
					System.out.println("Student Grade is : \t\t" + std.getGrade());
				} else {
					System.out.println("Student not found !!!");
				}
				flag = isExit();
				break;

			case 4:
				list = op.displayStudentList();
				if (list != null && !list.isEmpty()) {
					Iterator<Student> i = list.iterator();
					System.out.println("\n------------------ STUDENT DETAILS -------------------\n");
					int a = 1;
					while (i.hasNext()) {
						Student std = i.next();
						System.out.println("---------------" + a + " STUDENT DETAIL ---------------");
						System.out.println("Student RollNo is : \t\t" + std.getRollNo());
						System.out.println("Student Name is : \t\t" + std.getName());
						System.out.println("Student Age is : \t\t" + std.getAge());
						System.out.println("Student Gender is : \t\t" + std.getGender());
						System.out.println("Student Grade is : \t\t" + std.getGrade());
						System.out.println();
						a++;
					}
				} else {
					System.out.println("The student list is empty.");
				}
				flag = isExit();
				break;

			default:
				System.out.println("Please enter valid choice !!!");
				flag = isExit();
			}
		}
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

	// for number input
	static int numInput(int num) {
		if (sc.hasNextInt()) {
			num = sc.nextInt();
			return num;
		} else {
			return 0;
		}
	}
}
