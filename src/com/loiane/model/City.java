package com.loiane.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * City POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@JsonAutoDetect
@Entity
@Table(name="CITY")
public class City {

	private int id;
	private int stateId;
	private String name;
	
	@Id
	@GeneratedValue
	@Column(name="CITY_ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="STATE_ID", nullable=false)
	public int getStateId() {
		return stateId;
	}
	
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	@Column(name="CITY_NAME", nullable=false, length=50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
