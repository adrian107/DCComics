package com.epam.dccomics.domain;

public abstract class DCHero {

	public DCHero(final String name) {
		this.name = name;
	}
	
	
	protected String name;
	
	protected GoodGuy goodGuy;
	
	public abstract String getName();
	
	public abstract GoodGuy getGoodGuy();
	
}
