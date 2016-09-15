package com.epam.dccomics.strategy;

import java.rmi.activation.UnknownObjectException; 

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.epam.dccomics.constant.Constant;
import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.DCWorld;
import com.epam.dccomics.domain.FightingOpponentPair;
import com.epam.dccomics.domain.GoodGuy;

import ch.qos.logback.classic.Logger;

public class WinnerOfFightingStrategyImpl implements WinnerOfFightingStrategy {

	private static Logger logger = (Logger) LoggerFactory.getLogger(WinnerOfFightingStrategyImpl.class);

	

	@Override
	public void startFighting(FightingOpponentPair fightingOpponentPair) {
		logger.debug("-------------------------------------------------------------------------------------------------------------------");
		logger.debug("Start fighting " + fightingOpponentPair.getGoodGuyDcHero().getName() + " against "
				+ fightingOpponentPair.getBadGuyDcHero().getName());
		explanationText(fightingOpponentPair);
		int numberOfFightingRounds = generateRandomNumberOfRounds();
		for (int i = 0; i < numberOfFightingRounds; i++) {
			int actualFightingResult = generateWinnerOfOneRoundByAbility(fightingOpponentPair);
			String fightingResult = processFightingResult(fightingOpponentPair, actualFightingResult);
			logger.debug("\t{}. {}", i + 1, fightingResult);
		}
	}

	private void explanationText(FightingOpponentPair fightingOpponentPair) {
		DCHero weakerDcHero = weakerDcHero(fightingOpponentPair);
		DCHero strongerDcHero = strongerDcHero(fightingOpponentPair);
		String weakerRange = "1-" + weakerDcHero.getAbility();
		String strongerRange = weakerDcHero.getAbility() + "-"
				+ (weakerDcHero.getAbility() + strongerDcHero.getAbility());
		String s1 = "if the result is between " + weakerRange + ", then " + weakerDcHero.getName();
		String s2 = "else between " + strongerRange + ", then " + strongerDcHero.getName();
		logger.debug("({}, {})", s1, s2);
	}

	@Override
	public int generateWinnerOfOneRoundByAbility(FightingOpponentPair fightingOpponentPair) {
		int min = 1;
		int sumOfAbilities = fightingOpponentPair.getGoodGuyDcHero().getAbility()
				+ fightingOpponentPair.getBadGuyDcHero().getAbility();
		return (int) (Math.random() * (sumOfAbilities-min)) + min;
	}

	public int generateRandomNumberOfRounds() {
//		environment.getClass();
//		System.out.println(environment.getProperty("dccomics.fights.min-round-number"));
//		
//		int min = Integer.parseInt(environment.getProperty("dccomics.fights.min-round-number"));
//		int max = Integer.parseInt(environment.getProperty("dccomics.fights.max-round-number"));
		int min = 3;
		int max = 8;
		return (int) (Math.random() * (max-min)) + min;
	}

	private String processFightingResult(FightingOpponentPair fightingOpponentPair, int actualFightingResult) {
		DCHero weakerDcHero = weakerDcHero(fightingOpponentPair);

		final String goodGuyAbility = "(ability:" + fightingOpponentPair.getGoodGuyDcHero().getAbility() + "|lifepower:" + fightingOpponentPair.getGoodGuyDcHero().getLifePower() + ")";
		final String badGuyAbility = "(ability:" + fightingOpponentPair.getBadGuyDcHero().getAbility() + "|lifepower:" + fightingOpponentPair.getBadGuyDcHero().getLifePower() + ")";
		String fightingResult = "";
		if (actualFightingResult > weakerDcHero.getAbility()) {
			fightingResult = String.format("%10s %30s -- %10s %-30s --> %12s, (result: %d)",
					fightingOpponentPair.getGoodGuyDcHero().getName(), goodGuyAbility,
					fightingOpponentPair.getBadGuyDcHero().getName(), badGuyAbility,
					fightingOpponentPair.getGoodGuyDcHero().getName() + " won", actualFightingResult);
			increaseLifePowerOfLoserDcHero(fightingOpponentPair.getGoodGuyDcHero());
			decreaseLifePowerOfLoserDcHero(fightingOpponentPair.getBadGuyDcHero());
		} else {
			fightingResult = String.format("%10s %30s -- %10s %-30s --> %12s, (result: %d)",
					fightingOpponentPair.getGoodGuyDcHero().getName(), goodGuyAbility,
					fightingOpponentPair.getBadGuyDcHero().getName(), badGuyAbility,
					fightingOpponentPair.getBadGuyDcHero().getName() + " won", actualFightingResult);
			increaseLifePowerOfLoserDcHero(fightingOpponentPair.getBadGuyDcHero());
			decreaseLifePowerOfLoserDcHero(fightingOpponentPair.getGoodGuyDcHero());
		}
		return fightingResult;
	}

	private DCHero weakerDcHero(FightingOpponentPair fightingOpponentPair) {
		int goodGuyAbility = fightingOpponentPair.getGoodGuyDcHero().getAbility();
		int badGuyAbility = fightingOpponentPair.getBadGuyDcHero().getAbility();
		return goodGuyAbility < badGuyAbility ? fightingOpponentPair.getGoodGuyDcHero()
				: fightingOpponentPair.getBadGuyDcHero();
	}

	private DCHero strongerDcHero(FightingOpponentPair fightingOpponentPair) {
		int goodGuyAbility = fightingOpponentPair.getGoodGuyDcHero().getAbility();
		int badGuyAbility = fightingOpponentPair.getBadGuyDcHero().getAbility();
		return goodGuyAbility > badGuyAbility ? fightingOpponentPair.getGoodGuyDcHero()
				: fightingOpponentPair.getBadGuyDcHero();
	}

	@Override
	public void decreaseLifePowerOfLoserDcHero(DCHero dcHero) {
		int lp = dcHero.decreaseLifePower(Constant.DECREASE_LIFE_POWER);
	}
	
	@Override
	public void increaseLifePowerOfLoserDcHero(DCHero dcHero) {
		int lp = dcHero.increaseLifePower(Constant.INCREASE_LIFE_POWER);
	}

	
}
