package com.epam.dccomics.domain;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Superman extends DCHero {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(Superman.class);

	public Superman(final String name) {
		super(name);
	}

	@PostConstruct
	public void init() {
		logger.debug("{} is created", getName());
		this.lifePower = 100;
	}

	public void setGoodGuy(final GoodGuy goodGuy) {
		this.goodGuy = goodGuy;
	}

	@Override
	public String toString() {
		return myToString();
	}

	private String myToString() {
		StringBuilder sb = new StringBuilder(ToStringBuilder.reflectionToString(this));
		final int idx = sb.indexOf("[");
		sb = new StringBuilder(sb.substring(idx, sb.length()));
		String str = "Superman " + sb.toString();
		return str;
	}

}
