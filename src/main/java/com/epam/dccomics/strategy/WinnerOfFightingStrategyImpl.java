package com.epam.dccomics.strategy;

import java.rmi.activation.UnknownObjectException;

import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;

public class WinnerOfFightingStrategyImpl implements WinnerOfFightingStrategy {

	@Override
	public int startFighting(FightingOpponentPair fightingOpponentPair) {
		int numberOfFightingRounds = generateNumberOfRounds();
		for (int i = 0; i < numberOfFightingRounds; i++) {
			int actualFightingResult = generateWinnerOfOneRoundByAbility(fightingOpponentPair);
			processFightingResult(fightingOpponentPair, actualFightingResult);
		}
		return 0;
	}

	@Override
	public int generateWinnerOfOneRoundByAbility(FightingOpponentPair fightingOpponentPair) {
		int sumOfAbilities = fightingOpponentPair.getGoodGuyDcHero().getAbility()
				+ fightingOpponentPair.getBadGuyDcHero().getAbility();
		return (int) (Math.random() * sumOfAbilities) + 1;
	}

	private int generateNumberOfRounds() {
		int min = 1;
		int max = 5;
		return (int) (Math.random() * max) + min;
	}

	private void processFightingResult(FightingOpponentPair fightingOpponentPair, int actualFightingResult) {
		throw new UnsupportedOperationException("processFightingResult .....................");
	}

}
