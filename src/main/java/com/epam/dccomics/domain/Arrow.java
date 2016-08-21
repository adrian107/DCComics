package com.epam.dccomics.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Arrow extends DCHero {
	
	public void setName(final String name) {
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
//		return "Arrow [name=" + this.name + ", goodguy=" + this.goodguy + "]";
		return ToStringBuilder.reflectionToString(this);
	}

}
