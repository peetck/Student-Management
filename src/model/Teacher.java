package model;
import java.util.*;
public class Teacher{
    private ArrayList<Student> students;
    public Teacher(){
    	students = new ArrayList<Student>();
    	
    }
    public void addStudent(Student student) {
    	students.add(student);
    }
    public ArrayList<Student> getStudents(){
    	return this.students;
    }
    
    public void setStudents(ArrayList<Student> arr) {
    	this.students = arr;
    }
}