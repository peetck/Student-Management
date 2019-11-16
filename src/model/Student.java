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

	public void setScore(int select, double assignment, double project, double midterm, double Final) {
		this.score.put("s" + select + "_assignment", assignment);
		this.score.put("s" + select + "_project", project);
		this.score.put("s" + select + "_midterm", midterm);
		this.score.put("s" + select + "_final", Final);
	}
	
	public Object[] getTableHeadInfo() {
		Object[] info = new Object[6];
		
		info[0] = this.information.get("studentID");
		info[1] = this.information.get("name");
		info[2] = this.information.get("surname");
		info[3] = this.information.get("enrollAt");
		info[4] = "ดูข้อมูลเพิ่มเติม";
		info[5] = "ลบนักเรียน";
		
		return info;
	}
	public HashMap<String, Double> getScore(){
		return this.score;
	}
	

	public Object[] getGrade(int select) {
		Object[] score = new Object[7];
		score[0] = this.information.get("studentID");
		score[1] = String.format("%.3f", this.score.get("s" + select + "_assignment"));
		score[2] = String.format("%.3f", this.score.get("s" + select + "_project"));
		score[3] = String.format("%.3f", this.score.get("s" + select + "_midterm"));
		score[4] = String.format("%.3f", this.score.get("s" + select + "_final"));
		
		double allScore = this.score.get("s" + select + "_assignment") + this.score.get("s" + select + "_project")
		+ this.score.get("s" + select + "_midterm") + this.score.get("s" + select + "_final");
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
	public String getName() {
		return this.information.get("name");
	}
	public String getSurname() {
		return this.information.get("surname");
	}
	public String getPicturePath() {
		return this.picturePath;
	}
	
	public HashMap<String, String> getInformation(){
		return this.information;
	}

}
