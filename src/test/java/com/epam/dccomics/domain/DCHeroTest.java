package com.epam.dccomics.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.epam.dccomics.factory.DCHeroFactory;

public class DCHeroTest {

	DCHero dcHero;

	@Before
	public void setUp() {
		dcHero = DCHeroFactory.getArrowInstance("theGreenArrow");
	}

	@Test
	public void testDecreaseLifePower_ShouldReturnLifePowerIfIsHigherIncludedThanZero() {
		// given
		int decrease = 20;
		int minLimit = 0;
		// when
		dcHero.setLifePower(50);
		int result = dcHero.decreaseLifePower(decrease);
		// then
		assertTrue(result >= minLimit);
	}

	@Test
	public void testDecreaseLifePower_ShouldReturnZeroIfLifePowerIsDecreasedBelowZero() {
		// given
		int decrease = 20;
		int minLimit = 0;
		// when
		dcHero.setLifePower(15);
		int result = dcHero.decreaseLifePower(decrease);
		System.out.println(result);
		// then
		assertTrue(result == minLimit);
	}

	@Test
	public void testDecreaseLifePower_ShouldReturnZeroIfLifePowerIsLessThanZero() {
		// given
		int decrease = 20;
		int minLimit = 0;
		// when
		dcHero.setLifePower(-15);
		int result = dcHero.decreaseLifePower(decrease);
		// then
		assertTrue(result == minLimit);
	}

	@Test
	public void testIncreaseLifePower_ShouldReturnLifePowerIfLowerIncludedThanHundred() {
		// given
		int increase = 20;
		int maxLimit = 100;
		// when
		dcHero.setLifePower(60);
		int result = dcHero.increaseLifePower(increase);
		// then
		assertTrue(result <= maxLimit);
	}

	@Test
	public void testIncreaseLifePower_ShouldntReturnHundredIfLifePowerIsHigherThanHundred() {
		// given
		int increase = 20;
		int maxLimit = 100;
		// when
		dcHero.setLifePower(90);
		int result = dcHero.increaseLifePower(increase);
		// then
		assertTrue(result == maxLimit);
	}
	
	
}
