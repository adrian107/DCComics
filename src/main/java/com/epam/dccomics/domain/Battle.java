package com.epam.dccomics.domain;

import org.slf4j.LoggerFactory;

import com.epam.dccomics.TooWeakLifePowerException;
import com.epam.dccomics.constant.Constant;

import ch.qos.logback.classic.Logger;

public class Battle {

	private static Logger logger = (Logger) LoggerFactory.getLogger(Battle.class);

	private String place;

	public Battle(DCHero goodGuyDcHero, DCHero badGuyDcHero) {
		super();

		fight(goodGuyDcHero, badGuyDcHero);
	}

	public void fight(DCHero goodGuyDcHero, DCHero badGuyDcHero) {

		checkHeroes(goodGuyDcHero, badGuyDcHero);
		logger.debug("Fighting {} against {}...", goodGuyDcHero.getName(), badGuyDcHero.getName());

		try {
			checkLifePowers(goodGuyDcHero, badGuyDcHero);
		} catch (TooWeakLifePowerException e) {
			e.printStackTrace();
		}

	}

	/*
	 * I will just indicate the exception, and I catch it, in order to don't
	 * stop the program
	 */
	private void checkHeroes(DCHero goodGuyDcHero, DCHero badGuyDcHero) {
		if (goodGuyDcHero.getGoodGuy() != GoodGuy.GOOD_GUY || badGuyDcHero.getGoodGuy() != GoodGuy.BAD_GUY) {
			throw new IllegalArgumentException(goodGuyDcHero.getName() + " can't fight agains " + badGuyDcHero.getName()
					+ ". " + "First parameter needs to be a GOOD GUY. Second parameter needs to be a BAD GUY!");
		}
	}

	private void checkLifePowers(DCHero goodGuyDcHero, DCHero badGuyDcHero) throws TooWeakLifePowerException {
		if (goodGuyDcHero.getLifePower() < Constant.TOO_WEAK_LIFE_POWER
				|| badGuyDcHero.getLifePower() < Constant.TOO_WEAK_LIFE_POWER) {
			throw new TooWeakLifePowerException("Can't fight, because one of the 'dc heroes' has weak life power...");
		}
	}
}
