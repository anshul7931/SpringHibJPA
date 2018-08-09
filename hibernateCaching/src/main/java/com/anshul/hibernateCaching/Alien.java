package com.anshul.hibernateCaching;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="alien_table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	@Id
	private int aid;
	
	private AlienName aname;
	
	public AlienName getAname() {
		return aname;
	}

	public void setAname(AlienName aname) {
		this.aname = aname;
	}

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
