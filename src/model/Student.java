package model;

public class Student {
	private String name, surname, address, studentID;
	private int age;
	public Student(String name, String surname, String address, String studentID) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.studentID = studentID;
	}
	public String[] getInfo() {
		String[] info = new String[4];
		info[0] = name;
		info[1] = surname;
		info[2] = address;
		info[3] = studentID;
		return info;
	}
}
