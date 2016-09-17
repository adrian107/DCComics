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

	public String processFightingResult(FightingOpponentPair fightingOpponentPair, int fightingResult) {
		if (fightingOpponentPair == null) {
			throw new IllegalArgumentException("Args shouldn't be null");
		}
		if (fightingResult < 1) {
			throw new IllegalArgumentException("Arg shouldn't less than 1");
		}

		int limitBetweenStrogerAndWeakerDcHero = weakerDcHero(fightingOpponentPair).getAbility();

		DCHero winnerHero = null;
		DCHero loserHero = null;
		if (fightingResult > limitBetweenStrogerAndWeakerDcHero) {
			winnerHero = fightingOpponentPair.getGoodGuyDcHero();
			loserHero = fightingOpponentPair.getBadGuyDcHero();
		} else {
			winnerHero = fightingOpponentPair.getBadGuyDcHero();
			loserHero = fightingOpponentPair.getGoodGuyDcHero();
		}
		refreshLifePowers(winnerHero, loserHero);

		return createFormattedText(fightingResult, winnerHero, loserHero);
	}

	private String createFormattedText(int fightingResult, DCHero winnerHero, DCHero loserHero) {
		final String winnerAbilityLifePowerText = createFormattedTextForResultExplaination(winnerHero);
		final String loserAbilityLifePowerText = createFormattedTextForResultExplaination(loserHero);

		String message = "";
		message = createFormattedTextForResult(winnerHero, loserHero, fightingResult, winnerAbilityLifePowerText,
				loserAbilityLifePowerText);

		return message;
	}

	private void refreshLifePowers(DCHero winnerHero, DCHero loserHero) {
		increaseLifePowerOfWinnerDcHero(winnerHero);
		decreaseLifePowerOfLoserDcHero(loserHero);
	}

	/*
	 this method build a formatted text to display in console
	 e.g. Superman (képesség:10|életerö:100) -- LexLutor (képesség:7|életerö:100) LexLutor won, (result: 5) 
	 */
	private String createFormattedTextForResult(DCHero winnerDcHero, DCHero loserDcHero, int fightingResult,
			final String winnerAbilityLifePowerText, final String loserAbilityLifePowerText) {
		return String.format("%10s %30s -- %10s %-30s --> %12s, (result: %d)", winnerDcHero.getName(),
				winnerAbilityLifePowerText, loserDcHero.getName(), loserAbilityLifePowerText,
				winnerDcHero.getName() + " won", fightingResult);
	}

	private String createFormattedTextForResultExplaination(DCHero dcHero) {
		String ability = messageSource.getMessage("dccomics.dchero.ability", null, locale);
		String lifePower = messageSource.getMessage("dccomics.dchero.lifepower", null, locale);
		return "(" + ability + ":" + dcHero.getAbility() + "|" + lifePower + ":" + dcHero.getLifePower() + ")";
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
	public void increaseLifePowerOfWinnerDcHero(DCHero dcHero) {
		if (dcHero == null) {
			throw new IllegalArgumentException("Argumentum shouldn't be null");
		}
		dcHero.increaseLifePower(Constant.INCREASE_LIFE_POWER);
	}

}
