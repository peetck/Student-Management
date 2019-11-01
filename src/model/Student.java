package model;
import java.util.*;
public class Student {

	private HashMap<String, String> information;
	private HashMap<String, Double> score;
	private String picturePath;
	public Student(HashMap<String, String> information, HashMap<String, Double> score, String picturePath) {
		
		this.information = new HashMap<String, String>();
		this.score = new HashMap<String, Double>();
		
		for (String i : information.keySet()) {
			this.information.put(i, information.get(i));
		}
		
		for (String i : score.keySet()) {
			this.score.put(i, score.get(i));
		}
		
		this.picturePath = picturePath;
		
	}

	public void setScore( double assignment1, double assignment2, double midterm_score, double final_score) {
		this.information.put("midterm_score", "" + midterm_score);
		this.information.put("final_score", "" + final_score);
		this.information.put("assignment1", "" + assignment1);
		this.information.put("assignment2", "" + assignment2);

	}
	public Object[] getInfo() {
		Object[] info = new Object[5];
		
		info[0] = this.information.get("studentID");
		info[1] = this.information.get("name");
		info[2] = this.information.get("surname");
		info[3] = this.information.get("enrollAt");
		info[4] = " ดูข้อมูลเพิ่มเติม";
		
		return info;
	}
	public Object[] getScore() {
		Object[] score = new Object[7];
		score[0] = this.information.get("studentID");
		score[1] = String.format("%.3f", this.score.get("assignment1"));
		score[2] = String.format("%.3f", this.score.get("assignment2"));
		score[3] = String.format("%.3f", this.score.get("midterm_score"));
		score[4] = String.format("%.3f", this.score.get("final_score"));
		
		double allScore = this.score.get("assignment1") + this.score.get("assignment2") + this.score.get("midterm_score") + this.score.get("final_score");
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
		return this.information.get("studentID");
	}
	public String getPicturePath() {
		return this.picturePath;
	}
}
