package model;

public class Student {
	private String studentID, title, name, surname, cardID, address, race, religion, bloodType, tel, email, height, weight, parentTel, disease, enrollAt;
	private int age;
	public Student(String studentID, String title, String name, String surname, 
			String cardID, String address, String race, String religion, 
			String bloodType, String tel, String email, String height, String weight, 
			String parentTel, String disease, String enrollAt) {

		this.studentID = studentID;
		this.title = title;
		this.name = name;
		this.surname = surname;
		this.cardID = cardID;
		this.address = address;
		this.race = race;
		this.religion = religion;
		this.bloodType = bloodType;
		this.tel = tel;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.parentTel = parentTel;
		this.disease = disease;
		this.enrollAt = enrollAt;
		
	}
	public Object[] getInfo() {
		Object[] info = new Object[5];
		info[0] = studentID;
		info[1] = name;
		info[2] = surname;
		info[3] = enrollAt;
		info[4] = " ดูข้อมูลเพิ่มเติม";
		return info;
	}
	public String getStudentID() {
		return this.studentID;
	}
}
