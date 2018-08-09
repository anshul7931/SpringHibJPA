package com.anshul.hibernateInitial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity//(name="alien") -> This will change the name of entity and the table
@Table(name="alien")// ->Change the name of table only.
public class Alien {
	
	@Id
	private int aid;
	
	//@Transient//Now name wont be stored in the table
	//private String aname;
	
	private AlienName aname;
	
	public AlienName getAname() {
		return aname;
	}

	public void setAname(AlienName aname) {
		this.aname = aname;
	}

	@Column(name="alien_color")
	private String color;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	

}
