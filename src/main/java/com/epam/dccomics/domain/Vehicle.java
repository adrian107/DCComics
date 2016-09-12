package com.epam.dccomics.domain;

import com.epam.dccomics.constant.Constant;

public abstract class Vehicle {

	private String name;
	
	private int damage;

	public Vehicle(final String name) {
		this.name = name;
		this.damage = Constant.VEHICLE_DAMAGE;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + "]";
	}

}
