package com.epam.dccomics.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Batman extends DCHero {

	public Batman(final String name) {
		super(name);
	}

	private Batmobil batmobil;

	public void setName(final String name) {
		this.name = name;
	}

	public void setGoodGuy(final GoodGuy goodGuy) {
		this.goodGuy = goodGuy;
	}

	public Batmobil getBatmobil() {
		return batmobil;
	}

	public void setBatmobil(Batmobil batmobil) {
		this.batmobil = batmobil;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public GoodGuy getGoodGuy() {
		return this.goodGuy;
	}

	@Override
	public String toString() {
		return myToString();
	}

	private String myToString() {
		StringBuilder sb = new StringBuilder(ToStringBuilder.reflectionToString(this));
		final int idx = sb.indexOf("[");
		sb = new StringBuilder(sb.substring(idx, sb.length()));
		String str = "Batman " + sb.toString();
		return str;
	}

}
