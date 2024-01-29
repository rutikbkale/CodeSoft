import java.sql.*;
import java.util.ArrayList;

public class StudentOperation {
	Connection con = DBClass.getConnect();
	String query = null;
	PreparedStatement psmt = null;
	Statement smt = null;

	// Saving the student information
	int saveStudent(Student std) throws Exception {
		query = "insert into student values(?,?,?,?,?)";
		psmt = con.prepareStatement(query);
		psmt.setInt(1, std.getRollNo());
		psmt.setString(2, std.getName());
		psmt.setInt(3, std.getAge());
		psmt.setString(4, std.getGender());
		psmt.setString(5, std.getGrade());
		int res = psmt.executeUpdate();
		return res;
	}

	// Removing the student information
	int removeStudent(int rollNo) throws Exception {
		query = "delete from student where rollno=" + rollNo;
		psmt = con.prepareStatement(query);
		int res = psmt.executeUpdate();
		return res;
	}

	// Searching specific student
	Student searchStudent(int rollNo) throws Exception {
		query = "select * from student where rollno =" + rollNo;
		smt = con.createStatement();
		ResultSet set = smt.executeQuery(query);
		Student std = new Student();
		while (set.next()) {
			std.setRollNo(set.getInt("rollno"));
			std.setName(set.getString("name"));
			std.setAge(set.getInt("age"));
			std.setGender(set.getString("gender"));
			std.setGrade(set.getString("grade"));
		}
		return std;
	}

	// Displaying student list
	ArrayList<Student> displayStudentList() throws Exception {
		query = "select * from student";
		smt = con.createStatement();
		ResultSet set = smt.executeQuery(query);

		ArrayList<Student> list = new ArrayList<Student>();
		while (set.next()) {
			Student std = new Student();
			std.setRollNo(set.getInt("rollno"));
			std.setName(set.getString("name"));
			std.setAge(set.getInt("age"));
			std.setGender(set.getString("gender"));
			std.setGrade(set.getString("grade"));
			list.add(std);
		}
		return list;
	}
}
