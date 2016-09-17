package com.epam.dccomics.domain;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;

import com.epam.dccomics.constant.Constant;

import ch.qos.logback.classic.Logger;

public class LexLutor extends DCHero {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(LexLutor.class);

	private Limousine limousine;

	public LexLutor(final String name) {
		super(name);
	}

	@PostConstruct
	public void init() {
		logger.debug("{} is created", getName());
	}

	public Limousine getLimousine() {
		return limousine;
	}

	public void setLimousine(Limousine limousine) {
		this.limousine = limousine;
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
