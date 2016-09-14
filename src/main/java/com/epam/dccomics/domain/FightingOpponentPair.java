package com.epam.dccomics.domain;

public class FightingOpponentPair {

	private DCHero goodGuyDcHero;

	private DCHero badGuyDcHero;

	private int counterOfGoodGuyDcHero;

	private int counterOfBadGuyDcHero;

	public FightingOpponentPair(DCHero goodGuyDcHero, DCHero badGuyDcHero) {
		super();
		this.goodGuyDcHero = goodGuyDcHero;
		this.badGuyDcHero = badGuyDcHero;
		this.counterOfGoodGuyDcHero = 0;
		this.counterOfBadGuyDcHero = 0;
	}

	public DCHero getGoodGuyDcHero() {
		return goodGuyDcHero;
	}

	public DCHero getBadGuyDcHero() {
		return badGuyDcHero;
	}

	public int getCounterOfGoodGuyDcHero() {
		return counterOfGoodGuyDcHero;
	}

	public int getCounterOfBadGuyDcHero() {
		return counterOfBadGuyDcHero;
	}

	public void setCounterOfGoodGuyDcHero(int counterOfGoodGuyDcHero) {
		this.counterOfGoodGuyDcHero = counterOfGoodGuyDcHero;
	}

	public void setCounterOfBadGuyDcHero(int counterOfBadGuyDcHero) {
		this.counterOfBadGuyDcHero = counterOfBadGuyDcHero;
	}
	
	public void setBadGuyDcHero(DCHero badGuyDcHero) {
		this.badGuyDcHero = badGuyDcHero;
	}
	
	public void setGoodGuyDcHero(DCHero goodGuyDcHero) {
		this.goodGuyDcHero = goodGuyDcHero;
	}

}
