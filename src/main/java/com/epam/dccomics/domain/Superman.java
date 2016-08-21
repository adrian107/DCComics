package com.epam.dccomics.domain;

public class Superman extends DCHero {

	public void setName(String name) {
		this.name = name;
	}

	public void setGoodGuy(final GoodGuy goodGuy) {
		this.goodguy = goodGuy;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public GoodGuy getGoodGuy() {
		return this.goodguy;
	}

	@Override
	public String toString() {
		return "Superman [name=" + name + ", goodguy=" + goodguy + "]";
	}

}
