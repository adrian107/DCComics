package com.epam.dccomics.strategy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;
import com.epam.dccomics.factory.DCHeroFactory;

public class WinnerOfFightingStrategyImplTest {

	private WinnerOfFightingStrategyImpl winnerOfFightingStrategyImpl;

	@Mock
	private FightingOpponentPair fightingOpponentPair;

	@Mock
	private DCHero goodGuy;

	@Mock
	private DCHero badGuy;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		winnerOfFightingStrategyImpl = new WinnerOfFightingStrategyImpl();

//		goodGuy = DCHeroFactory.getSupermanInstance("Superman");
//		badGuy = DCHeroFactory.getLexLutorInstance("LexLutor");
//		goodGuy.setAbility(8);
//		badGuy.setAbility(5);
//		fightingOpponentPair.setGoodGuyDcHero(goodGuy);
//		fightingOpponentPair.setBadGuyDcHero(badGuy);
//		System.out.println(fightingOpponentPair.getBadGuyDcHero().toString());
	}

	@Test
	public void testGenerateRandomNumberOfRounds_ShouldReturnARandomNumberBetweenMinAndMax() {
		// given
		int min = 3;
		int max = 8;
		// when
		int result = winnerOfFightingStrategyImpl.generateRandomNumberOfRounds();
		// then
		assertTrue("Error, random number is to low", result >= min);
		assertTrue("Error, random number is to high", result <= max);
	}

	@Test
	public void testGenerateWinnerOfOneRoundByAbility_ShouldReturnSumOfTwoAbilitesofDcHero() {
		// given
		int min = 1;
		BDDMockito.given(fightingOpponentPair.getGoodGuyDcHero()).willReturn(goodGuy);
		BDDMockito.given(fightingOpponentPair.getBadGuyDcHero()).willReturn(badGuy);		
		BDDMockito.given(fightingOpponentPair.getGoodGuyDcHero().getAbility()).willReturn(10);
		BDDMockito.given(fightingOpponentPair.getBadGuyDcHero().getAbility()).willReturn(7);
		// when
		int result = winnerOfFightingStrategyImpl.generateWinnerOfOneRoundByAbility(fightingOpponentPair);
		// then
		System.out.println(result);
		Assert.assertTrue("Error, result is lower than MinAbility", result >= 1);
		Assert.assertTrue("Error, result is higher than MaxAbility", result <= 17);
	}

}
