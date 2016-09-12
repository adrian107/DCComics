package com.epam.dccomics.strategy;

import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;

public interface WinnerOfFightingStrategy {

	public int startFighting(FightingOpponentPair fightingOpponentPair);
	
	public int generateWinnerOfOneRoundByAbility(FightingOpponentPair fightingOpponentPair);
	
}
