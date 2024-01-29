public class Student {
	private int rollNo;
	private String name;
	private int age;
	private String gender;
	private String grade;

	// Default Constructor
	public Student() {
		super();
	}

	// Constructor using fields
	public Student(int rollNo, String name, int age, String gender, String grade) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
	}

	// Getters and Setters
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
