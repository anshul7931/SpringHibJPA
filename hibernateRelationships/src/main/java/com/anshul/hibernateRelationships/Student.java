package com.anshul.hibernateRelationships;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int rollno;
	
	private String name;
	
	private int marks;
	
	/*@OneToOne
	private Laptop lappy;//lappy_lid will be created under student table as foreign key

	
	public Laptop getLaptop() {
		return lappy;
	}

	public void setLaptop(Laptop laptop) {
		this.lappy = laptop;
	}*/
	
/*	@OneToMany(mappedBy="stud")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
*/
	
	@ManyToMany(mappedBy="stud")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
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

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}
