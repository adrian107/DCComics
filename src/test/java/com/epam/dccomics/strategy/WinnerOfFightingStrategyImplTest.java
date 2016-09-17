package com.epam.dccomics.strategy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.dccomics.constant.Constant;
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
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStartFighting_ShouldThrowExceptionWhenArgIsNull() {
		// GIVEN
		FightingOpponentPair pair = null;
		// WHEN
		winnerOfFightingStrategyImpl.startFighting(pair);
	}

//	@Test
//	public void testStartFighting_ShouldCallMethods() {
//		// GIVEN
//		BDDMockito.given(fightingOpponentPair.getGoodGuyDcHero()).willReturn(goodGuy);
//		BDDMockito.given(fightingOpponentPair.getBadGuyDcHero()).willReturn(badGuy);
//		// WHEN
//		winnerOfFightingStrategyImpl.startFighting(fightingOpponentPair);
//		// THEN
////		BDDMockito.verify(mockThis,times(1)).explanationText(fightingOpponentPair);
//		
//	}

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
		Assert.assertTrue("Error, result is lower than MinAbility", result >= min);
		Assert.assertTrue("Error, result is higher than MaxAbility", result <= 17);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDecreaseLifePowerOfLoserDcHero_ShouldThrowExceptionWhenArgIsNull() {
		// GIVEN
		DCHero dcHero = null;
		winnerOfFightingStrategyImpl.decreaseLifePowerOfLoserDcHero(dcHero);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tesIncreaseLifePowerOfLoserDcHero_ShouldThrowExceptionWhenArgIsNull() {
		// GIVEN
		DCHero dcHero = null;
		// WHEN
		winnerOfFightingStrategyImpl.increaseLifePowerOfWinnerDcHero(dcHero);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcessFightingResult_ShouldThrowExceptioWhenArgIsNull() {
		// GIVEN
		DCHero dcHero1 = DCHeroFactory.getArrowInstance("theGreenArrow");
		DCHero dcHero2 = DCHeroFactory.getArrowInstance("superman");
		FightingOpponentPair pair = new FightingOpponentPair(dcHero1, dcHero2);
		int actualFightingResult = 0;
		// WHEN
		winnerOfFightingStrategyImpl.processFightingResult(pair, 0);
	}

	@Test
	public void testDecreaseLifePowerOfLoserDcHero_ShouldCallAMethodOnce() {
		// GIVEN
		// WHEN
		winnerOfFightingStrategyImpl.decreaseLifePowerOfLoserDcHero(goodGuy);
		// THEN
		BDDMockito.verify(goodGuy, times(1)).decreaseLifePower(Constant.INCREASE_LIFE_POWER);
	}

	@Test
	public void testIncreaseLifePowerOfLoserDcHero_ShouldCallAMethodOnce() {
		// GIVEN
		// WHEN
		winnerOfFightingStrategyImpl.increaseLifePowerOfWinnerDcHero(goodGuy);
		// THEN
		BDDMockito.verify(goodGuy, times(1)).increaseLifePower(Constant.DECREASE_LIFE_POWER);
	}

}
