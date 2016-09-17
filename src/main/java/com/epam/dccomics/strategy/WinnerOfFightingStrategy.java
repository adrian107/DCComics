package com.epam.dccomics.strategy;

import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;

public interface WinnerOfFightingStrategy {

	public void startFighting(FightingOpponentPair fightingOpponentPair);
	
	public int generateWinnerOfOneRoundByAbility(FightingOpponentPair fightingOpponentPair);
	
	public void decreaseLifePowerOfLoserDcHero(DCHero dcHero);
	
	public void increaseLifePowerOfWinnerDcHero(DCHero dcHero);	
	
	
}
