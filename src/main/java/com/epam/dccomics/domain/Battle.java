package com.epam.dccomics.domain;

import org.slf4j.LoggerFactory;

import com.epam.dccomics.TooWeakLifePowerException;
import com.epam.dccomics.constant.Constant;
import com.epam.dccomics.strategy.WinnerOfFightingStrategy;
import com.epam.dccomics.strategy.WinnerOfFightingStrategyImpl;

import ch.qos.logback.classic.Logger;

public class Battle {

	private static Logger logger = (Logger) LoggerFactory.getLogger(Battle.class);

	private String place;

	private WinnerOfFightingStrategy winnerOfFightingStrategy;

	private FightingOpponentPair fightingOpponentPair;

	public Battle(FightingOpponentPair fightingOpponentPair) {
		super();
		this.fightingOpponentPair = fightingOpponentPair;
		this.winnerOfFightingStrategy = new WinnerOfFightingStrategyImpl();
		fight();
	}

	public void fight() {
		if (fightingOpponentPair.getGoodGuyDcHero().getGoodGuy() != GoodGuy.GOOD_GUY
				|| fightingOpponentPair.getBadGuyDcHero().getGoodGuy() != GoodGuy.BAD_GUY) {
			throw new IllegalArgumentException(fightingOpponentPair.getGoodGuyDcHero().getName()
					+ " can't fight agains " + fightingOpponentPair.getBadGuyDcHero().getName() + ". "
					+ "First parameter needs to be a GOOD GUY. Second parameter needs to be a BAD GUY!");
		}
		checkLifePowers(fightingOpponentPair);
		startFighting(fightingOpponentPair);

	}

	private void startFighting(FightingOpponentPair fightingOpponentPair) {
//		logger.debug("Start fighting " + fightingOpponentPair.getGoodGuyDcHero().getName() + " against " + fightingOpponentPair.getBadGuyDcHero().getName());
		
//		for (int i = 0; i < numberOfFightingRounds; i++) {
//			int num = winnerOfOneRoundStrategy.generateWinnerByAbility(fightingOpponentPair);
//			System.out.println(num);
//		}
		winnerOfFightingStrategy.startFighting(fightingOpponentPair);
	}

	

	private void checkLifePowers(FightingOpponentPair fightingOpponentPair) throws TooWeakLifePowerException {
		if (fightingOpponentPair.getGoodGuyDcHero().getLifePower() < Constant.TOO_WEAK_LIFE_POWER
				|| fightingOpponentPair.getBadGuyDcHero().getLifePower() < Constant.TOO_WEAK_LIFE_POWER) {
			throw new TooWeakLifePowerException("Can't fight, because one of the 'dc heroes' has weak life power...");
		}
	}
}
