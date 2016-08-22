package com.epam.dccomics.domain;

public abstract class Vehicle {

	final String name;

	public Vehicle(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + "]";
	}

}
