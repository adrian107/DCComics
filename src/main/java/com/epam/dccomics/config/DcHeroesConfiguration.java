package com.epam.dccomics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.epam.dccomics.domain.Batman;
import com.epam.dccomics.domain.Batmobil;
import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.GoodGuy;
import com.epam.dccomics.domain.Gun;
import com.epam.dccomics.domain.LexLutor;
import com.epam.dccomics.domain.Limousine;
import com.epam.dccomics.domain.PrototypeDCHero;
import com.epam.dccomics.domain.Superman;
import com.epam.dccomics.domain.TheGreenArrow;
import com.epam.dccomics.domain.Zoom;
import com.epam.dccomics.factory.DCHeroFactory;

@Configuration

@Lazy
@ComponentScan(basePackages = { "com.epam.dccomics" }, lazyInit = true)
public class DcHeroesConfiguration {

	@Bean
	public DCHero theGreenArrow() {
		TheGreenArrow theGreenArrow = DCHeroFactory.getArrowInstance("TheGreenArrow");
		return theGreenArrow;
	}

	@Bean
	public DCHero superman() {
		Superman superman = DCHeroFactory.getSupermanInstance("Superman");
		return superman;
	}

	@Bean
	public DCHero batman() {
		Batman batman = DCHeroFactory.getBatmanInstance("Batman");
		return batman;
	}

	@Bean
	public DCHero lexLutor() {
		LexLutor lexLutor = DCHeroFactory.getLexLutorInstance("LexLutor");
		return lexLutor;
	}

	@Bean
	public DCHero zoom() {
		Zoom zoom = DCHeroFactory.getZoomInstance("Zoom");
		return zoom;
	}

	@Bean
	public DCHero prototypeDCHero() {
		PrototypeDCHero prototypeDCHero = new PrototypeDCHero("PrototypeDCHero");
		prototypeDCHero.setGoodGuy(GoodGuy.BAD_GUY);
		return prototypeDCHero;
	}

	@Bean
	public Gun batmobilGun() {
		Gun batmobilGun = new Gun("batmobilGun1");
		return batmobilGun;
	}

	@Bean
	public Batmobil batmobil() {
		Batmobil batmobil = new Batmobil("batmobil", batmobilGun());
		return batmobil;
	}

	@Bean
	public Limousine limousine1() {
		Limousine limousine1 = new Limousine("limousine1");
		return limousine1;
	}
}
