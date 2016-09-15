package com.epam.dccomics.domain;

import org.slf4j.LoggerFactory;

public abstract class DCHero {

	protected String name;

	protected int lifePower;

	protected int ability;

	protected GoodGuy goodGuy;

	public DCHero(final String name) {
		this.name = name;
	}

	public void setLifePower(int lifePower) {
		this.lifePower = lifePower;
	}

	public int getLifePower() {
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

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getAbility() {
		return ability;
	}

	public int decreaseLifePower(final int decrease) {
		this.lifePower -= decrease;
		if(this.lifePower < 0)
			this.lifePower = 0;
		return (int) this.lifePower;
	}
	
	public int increaseLifePower(final int increase) {
		this.lifePower += increase;
		if(this.lifePower > 100)
			this.lifePower = 100;
		return (int) this.lifePower;
	}
}
