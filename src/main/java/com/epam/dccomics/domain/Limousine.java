package com.epam.dccomics.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Limousine extends Vehicle {

	public Limousine(String name) {
		super(name);
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
