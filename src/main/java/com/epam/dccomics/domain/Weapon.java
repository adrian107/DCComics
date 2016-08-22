package com.epam.dccomics.domain;

public abstract class Weapon {

	protected String name;

	public Weapon(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public abstract String shoot();

//	@Override
//	public String toString() {
//		return "Weapon [name=" + name + "]";
//	}
	
	
}
