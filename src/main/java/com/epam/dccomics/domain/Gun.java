package com.epam.dccomics.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Gun extends Weapon {

	public Gun(String name) {
		super(name);
	}

	@Override
	public String shoot() {
		return "Gun shoot";
	}

	@Override
	public String toString() {
		return myToString();
	}

	private String myToString() {
		StringBuilder sb = new StringBuilder(ToStringBuilder.reflectionToString(this));
		final int idx = sb.indexOf("[");
		sb = new StringBuilder(sb.substring(idx, sb.length()));
		String str = "Gun-" + sb.toString();
		return str;
	}

}
