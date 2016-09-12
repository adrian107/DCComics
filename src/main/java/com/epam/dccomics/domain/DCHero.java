package com.epam.dccomics.domain;

import org.slf4j.LoggerFactory;

public abstract class DCHero {
	
	protected String name;

	protected double lifePower;

	protected int ability;
	
	protected GoodGuy goodGuy;

	public DCHero(final String name) {
		this.name = name;
	}

	public void setLifePower(double lifePower) {
		this.lifePower = lifePower;
	}
	
	public double getLifePower() {
		return lifePower;
	}
	
	public String getName() {
		return this.name;
	}

	public GoodGuy getGoodGuy() {
		return this.goodGuy;
	}
	
	public void setGoodGuy(GoodGuy goodGuy) {
		this.goodGuy = goodGuy;
	}

}
