package com.epam.dccomics.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Batmobil extends Vehicle {

	private Gun gun;
	
	public Batmobil(String name, Gun gun) {
		super(name);
		this.gun = gun;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	@Override
	public String toString() {
		return myToString();
	}
	
	private String myToString() {
		StringBuilder sb = new StringBuilder(ToStringBuilder.reflectionToString(this));
		final int idx = sb.indexOf("[");
		sb = new StringBuilder(sb.substring(idx, sb.length()));
		String str = getName() + " " + sb.toString();
		return str;
	}
	

	
}
