package com.epam.dccomics.factory;

import com.epam.dccomics.domain.Batman;
import com.epam.dccomics.domain.GoodGuy;
import com.epam.dccomics.domain.LexLutor;
import com.epam.dccomics.domain.Slade;
import com.epam.dccomics.domain.Superman;
import com.epam.dccomics.domain.TheGreenArrow;
import com.epam.dccomics.domain.Zoom;

public class DCHeroFactory {

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
		Batman batman = new Batman(dcHeroName);
		batman.setGoodGuy(GoodGuy.GOOD_GUY);
		return batman;
	}

	public static LexLutor getLexLutorInstance(final String dcHeroName) {
		LexLutor lexLutor = new LexLutor(dcHeroName);
		lexLutor.setGoodGuy(GoodGuy.BAD_GUY);
		return lexLutor;
	}

	public static Zoom getZoomInstance(final String dcHeroName) {
		Zoom zoom = new Zoom(dcHeroName);
		zoom.setGoodGuy(GoodGuy.BAD_GUY);
		return zoom;
	}

}
