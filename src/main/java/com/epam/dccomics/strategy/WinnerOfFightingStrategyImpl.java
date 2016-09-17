package com.epam.dccomics.strategy;

import java.util.Locale;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.epam.dccomics.constant.Constant;
import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;
import com.epam.dccomics.propertywrappers.WinnerOfFightingStrategyWrapper;
import com.google.common.annotations.VisibleForTesting;

import ch.qos.logback.classic.Logger;

public class WinnerOfFightingStrategyImpl implements WinnerOfFightingStrategy {

	private static Logger logger = (Logger) LoggerFactory.getLogger(WinnerOfFightingStrategyImpl.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Locale locale;

	private WinnerOfFightingStrategyWrapper winnerOfFightingStrategyWrapper;

	public WinnerOfFightingStrategyImpl() {
		winnerOfFightingStrategyWrapper = null;
	}

	public WinnerOfFightingStrategyImpl(WinnerOfFightingStrategyWrapper winnerOfFightingStrategyWrapper) {
		this.winnerOfFightingStrategyWrapper = winnerOfFightingStrategyWrapper;
	}

	@Override
	public void startFighting(FightingOpponentPair fightingOpponentPair) {
		if (fightingOpponentPair == null) {
			throw new IllegalArgumentException("Arg shouldn't be null");
		}

		explanationText(fightingOpponentPair);
		int numberOfFightingRounds = generateRandomNumberOfRounds();
		for (int i = 0; i < numberOfFightingRounds; i++) {
			int actualFightingResult = generateWinnerOfOneRoundByAbility(fightingOpponentPair);
			String fightingResult = processFightingResult(fightingOpponentPair, actualFightingResult);
			logger.debug("\t{}. {}", i + 1, fightingResult);
		}
	}

	@VisibleForTesting
	private void explanationText(FightingOpponentPair fightingOpponentPair) {
		logger.debug(
				"-------------------------------------------------------------------------------------------------------------------");
		String message = messageSource.getMessage("dccomics.dchero.start-fight", new Object[] {
				fightingOpponentPair.getGoodGuyDcHero().getName(), fightingOpponentPair.getBadGuyDcHero().getName() },
				locale);
		logger.debug(message);
		DCHero weakerDcHero = weakerDcHero(fightingOpponentPair);
		DCHero strongerDcHero = strongerDcHero(fightingOpponentPair);
		String weakerRange = "1-" + weakerDcHero.getAbility();
		String strongerRange = weakerDcHero.getAbility() + "-"
				+ (weakerDcHero.getAbility() + strongerDcHero.getAbility());
		message = messageSource.getMessage("dccomics.dchero.fight.explain-for-abilites",
				new Object[] { weakerRange, weakerDcHero.getName(), strongerRange, strongerDcHero.getName() }, locale);
		logger.debug(message);
	}

	@Override
	public int generateWinnerOfOneRoundByAbility(FightingOpponentPair fightingOpponentPair) {
		int min = 1;
		int sumOfAbilities = fightingOpponentPair.getGoodGuyDcHero().getAbility()
				+ fightingOpponentPair.getBadGuyDcHero().getAbility();
		return (int) (Math.random() * (sumOfAbilities - min)) + min;
	}

	public int generateRandomNumberOfRounds() {
		int min = winnerOfFightingStrategyWrapper.getMinRoundOfFights();
		int max = winnerOfFightingStrategyWrapper.getMaxRoundOfFights();
		return (int) (Math.random() * (max - min)) + min;
	}

	public String processFightingResult(FightingOpponentPair fightingOpponentPair, int actualFightingResult) {
		if (fightingOpponentPair == null) {
			throw new IllegalArgumentException("Args shouldn't be null");
		}
		if (actualFightingResult < 1) {
			throw new IllegalArgumentException("Arg shouldn't less than 1");
		}
		String ability = messageSource.getMessage("dccomics.dchero.ability", null, locale);
		String lifePower = messageSource.getMessage("dccomics.dchero.lifepower", null, locale);

		final DCHero weakerDcHero = weakerDcHero(fightingOpponentPair);

		final String goodGuyAbility = "(" + ability + ":" + fightingOpponentPair.getGoodGuyDcHero().getAbility() + "|"
				+ lifePower + ":" + fightingOpponentPair.getGoodGuyDcHero().getLifePower() + ")";
		final String badGuyAbility = "(" + ability + ":" + fightingOpponentPair.getBadGuyDcHero().getAbility() + "|"
				+ lifePower + ":" + fightingOpponentPair.getBadGuyDcHero().getLifePower() + ")";
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
		if (dcHero == null) {
			throw new IllegalArgumentException("Argumentum shouldn't be null");
		}
		dcHero.decreaseLifePower(Constant.DECREASE_LIFE_POWER);
	}

	@Override
	public void increaseLifePowerOfLoserDcHero(DCHero dcHero) {
		if (dcHero == null) {
			throw new IllegalArgumentException("Argumentum shouldn't be null");
		}
		dcHero.increaseLifePower(Constant.INCREASE_LIFE_POWER);
	}

}
