package com.example.demo.PowerSystemEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ps7")
public class PowerSystemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="batteryName")
	private String batteryName;
	
	@Column(name= "postcode")
	private Integer postcode;
	
	
	@Column(name= "battery_capacity")
	private int batteryCapacity;
	
	public String getBatteryName() {
		return batteryName;
	}
	public void setBatteryName(String batteryName) {
		this.batteryName = batteryName;
	}
	public Integer getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = Integer.valueOf(postcode);  
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public PowerSystemEntity(long id, String batteryName, String postcode, int batteryCapacity) {
		this.id = id;
		this.batteryName = batteryName;
		this.postcode = Integer.valueOf(postcode);  
		this.batteryCapacity = batteryCapacity;
	}
	public PowerSystemEntity() {
		
	}
	

}
