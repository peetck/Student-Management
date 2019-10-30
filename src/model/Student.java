package model;

public class Student {
	private String studentID, title, name, surname, cardID, address, race, religion, bloodType, tel, email, height, weight, parentTel, disease, enrollAt;
	private int age;
	private double midterm_score, final_score, assignment1, assignment2;
	public Student(String studentID, String title, String name, String surname, 
			String cardID, String address, String race, String religion, 
			String bloodType, String tel, String email, String height, String weight, 
			String parentTel, String disease, String enrollAt, double midterm_score, 
			double final_score, double assignment1, double assignment2) {

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
		
		
		this.midterm_score = midterm_score;
		this.final_score = final_score;
		this.assignment1 = assignment1;
		this.assignment2 = assignment2;
	}
	public void setScore( double assignment1, double assignment2, double midterm_score, double final_score) {
		this.midterm_score = midterm_score;
		this.final_score = final_score;
		this.assignment1 = assignment1;
		this.assignment2 = assignment2;
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
	public Object[] getScore() {
		Object[] score = new Object[7];
		score[0] = studentID;
		score[1] = String.format("%.3f", assignment1);
		score[2] = String.format("%.3f", assignment2);
		score[3] = String.format("%.3f", midterm_score);
		score[4] = String.format("%.3f", final_score);
		
		double allScore = this.assignment1 + this.assignment2 + midterm_score + final_score;
		score[5] = String.format("%.3f", allScore);
		if (allScore >= 80) {
			score[6] = "A";
		}
		else if (allScore >= 75) {
			score[6] = "B+";
		}
		else if (allScore >= 70) {
			score[6] = "B";
		}
		else if (allScore >= 65) {
			score[6] = "C+";
		}
		else if (allScore >= 60) {
			score[6] = "C";
		}
		else if (allScore >= 55) {
			score[6] = "D+";
		}
		else if (allScore >= 50) {
			score[6] = "D";
		}
		else {
			score[6] = "F";
		}
		return score;
	}
	public String getStudentID() {
		return this.studentID;
	}
}
