package com.epam.dccomics.factory;

import javax.naming.OperationNotSupportedException;

import com.epam.dccomics.domain.TheGreenArrow;
import com.epam.dccomics.domain.Batman;
import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.GoodGuy;
import com.epam.dccomics.domain.LexLutor;
import com.epam.dccomics.domain.Superman;

public class DCHeroFactory {

//	public static DCHero createInstance(String dcHeroName) throws Exception {
//
//		if (dcHeroName.equals("arrow")) {
//			return getArrowInstance(dcHeroName);			
//		} else if (dcHeroName.equals("superman")) {
//			return getSupermanInstance(dcHeroName);
//		} else if (dcHeroName.equals("batman")) {
//
//		} else if (dcHeroName.equals("flash")) {
//
//		} else if (dcHeroName.equals("zoom")) {
//
//		} else {
//			throw new OperationNotSupportedException("BAD HERO NAME !!!");
//		}
//		return null;
//	}
	
	public static TheGreenArrow getArrowInstance(final String dcHeroName) {
		TheGreenArrow arrow = new TheGreenArrow(dcHeroName);
		arrow.setGoodGuy(GoodGuy.GOOD_GUY);
		return arrow;
	}
	
	public static Superman getSupermanInstance(final String dcHeroName) {
		Superman superman = new Superman(dcHeroName);
		superman.setGoodGuy(GoodGuy.GOOD_GUY);
		return superman;
	}
	
	public static Batman getBatmanInstance(final String dcHeroName) {
		Batman batman= new Batman(dcHeroName);
		batman.setGoodGuy(GoodGuy.GOOD_GUY);
		return batman;
	}
	
	public static LexLutor getLexLutorInstance(final String dcHeroName) {
		LexLutor lexLutor = new LexLutor(dcHeroName);
		lexLutor.setGoodGuy(GoodGuy.BAD_GUY);
		return lexLutor;
	}
	
}
