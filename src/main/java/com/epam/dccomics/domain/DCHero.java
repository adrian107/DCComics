package com.epam.dccomics.domain;

public abstract class DCHero {

	protected String name;
	
	protected GoodGuy goodguy;
	
	public abstract String getName();
	
	public abstract GoodGuy getGoodGuy();
	
}
