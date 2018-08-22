package com.anshul.hibernateHQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int sid;
	
	private String rollno;
	
	private String name;
	
	private int marks;

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int i) {
		this.marks = i;
	}
}
