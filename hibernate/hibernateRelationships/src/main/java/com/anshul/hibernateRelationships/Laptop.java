package com.anshul.hibernateRelationships;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {

	@Id
	private int lid;
	
	private String lname;
	
	/*@ManyToOne //One to many will be in student
	private Student stud;

	public Student getStudent() {
		return stud;
	}

	public void setStudent(Student student) {
		this.stud = student;
	}*/
	
	@ManyToMany
	private List<Student> stud = new ArrayList<Student>();

	public List<Student> getStud() {
		return stud;
	}

	public void setStud(List<Student> stud) {
		this.stud = stud;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int i) {
		this.lid = i;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	
	
}
