package model;

public class Student {
	private String name, surname, address, studentID, enrollAt;
	private int age;
	public Student(String name, String surname, String address, String studentID, String enrollAt) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.studentID = studentID;
		this.enrollAt = enrollAt;
	}
	public String[] getInfo() {
		String[] info = new String[5];
		info[0] = studentID;
		info[1] = name;
		info[2] = surname;
		info[3] = address;
		info[4] = enrollAt;
		return info;
	}
}
