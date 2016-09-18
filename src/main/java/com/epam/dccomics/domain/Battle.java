package com.epam.dccomics.domain;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.dccomics.constant.Constant;
import com.epam.dccomics.exception.TooWeakLifePowerException;
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
	}

	public Battle(FightingOpponentPair fightingOpponentPair, WinnerOfFightingStrategy winnerOfFightingStrategy) {
		super();
		this.fightingOpponentPair = fightingOpponentPair;
		this.winnerOfFightingStrategy = winnerOfFightingStrategy;

	}

	@PostConstruct
	public void init() {
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
		winnerOfFightingStrategy.startFighting(fightingOpponentPair);
	}

	private void checkLifePowers(FightingOpponentPair fightingOpponentPair) throws TooWeakLifePowerException {
		if (fightingOpponentPair.getGoodGuyDcHero().getLifePower() < Constant.TOO_WEAK_LIFE_POWER) {
			String message = "Can't fight, because the lifepower of '" + fightingOpponentPair.getGoodGuyDcHero().getName() + "' decreased to too weak... Run again the program";
			throw new TooWeakLifePowerException(message);
		}
		else if(fightingOpponentPair.getBadGuyDcHero().getLifePower() < Constant.TOO_WEAK_LIFE_POWER){
			String message = "Can't fight, because the lifepower of '" + fightingOpponentPair.getBadGuyDcHero().getName() + "' decreased to too weak... Run again the program";
			throw new TooWeakLifePowerException(message);
		}
	}

	public void setWinnerOfFightingStrategy(WinnerOfFightingStrategy winnerOfFightingStrategy) {
		this.winnerOfFightingStrategy = winnerOfFightingStrategy;
	}
}
