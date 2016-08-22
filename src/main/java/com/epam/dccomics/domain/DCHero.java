package com.epam.dccomics.domain;

import org.slf4j.LoggerFactory;

public abstract class DCHero {
	
	protected String name;

	protected double lifePower;

	protected GoodGuy goodGuy;

	public DCHero(final String name) {
		this.name = name;
	}

	public void setLifePower(double lifePower) {
		this.lifePower = lifePower;
	}
	
	public String getName() {
		return this.name;
	}

	public GoodGuy getGoodGuy() {
		return this.goodGuy;
	}

}
