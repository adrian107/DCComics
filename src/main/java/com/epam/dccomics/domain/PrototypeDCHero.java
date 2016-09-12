package com.epam.dccomics.domain;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PrototypeDCHero extends DCHero {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(PrototypeDCHero.class);
	
	private static int ID = 1;

	public PrototypeDCHero(final String name) {
		super(name + "_" + ID);
		ID++;
	}

	@PostConstruct
	public void init() {
		logger.debug("{} is created", getName());
		this.lifePower = 100;
	}
	

	@Override
	public String toString() {
		return myToString();
	}

	private String myToString() {
		StringBuilder sb = new StringBuilder(ToStringBuilder.reflectionToString(this));
		final int idx = sb.indexOf("[");
		sb = new StringBuilder(sb.substring(idx, sb.length()));
		String str = getName() + " " + sb.toString();
		return str;
	}

}
