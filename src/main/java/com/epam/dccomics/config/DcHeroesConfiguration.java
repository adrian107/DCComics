package com.epam.dccomics.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

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

	@Autowired
	private Environment env;
	
	private int lifePower;
	
	@Bean
	public TheGreenArrow theGreenArrow() {
		String name = env.getProperty("dchero.theGreenArrow.name");
		int ability = Integer.parseInt(env.getProperty("dchero.theGreenArrow.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		TheGreenArrow theGreenArrow = DCHeroFactory.getArrowInstance(name);
		theGreenArrow.setAbility(ability);
		theGreenArrow.setLifePower(lifePower);
		return theGreenArrow;
	}

	@Bean
	public Superman superman() {
		String name = env.getProperty("dchero.superman.name");
		int ability = Integer.parseInt(env.getProperty("dchero.superman.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		Superman superman = DCHeroFactory.getSupermanInstance("Superman");
		superman.setAbility(ability);
		superman.setLifePower(lifePower);
		return superman;
	}

	@Bean
	public Batman batman() {
		String name = env.getProperty("dchero.batman.name");
		int ability = Integer.parseInt(env.getProperty("dchero.batman.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		Batman batman = DCHeroFactory.getBatmanInstance("Batman");
		batman.setAbility(ability);
		batman.setLifePower(lifePower);
		return batman;
	}

	@Bean
	public LexLutor lexLutor() {
		String name = env.getProperty("dchero.lexLutor.name");
		int ability = Integer.parseInt(env.getProperty("dchero.lexLutor.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		LexLutor lexLutor = DCHeroFactory.getLexLutorInstance("LexLutor");
		lexLutor.setAbility(ability);
		lexLutor.setLifePower(lifePower);
		return lexLutor;
	}

	@Bean
	public Zoom zoom() {
		String name = env.getProperty("dchero.zoom.name");
		int ability = Integer.parseInt(env.getProperty("dchero.zoom.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		Zoom zoom = DCHeroFactory.getZoomInstance("Zoom");
		zoom.setAbility(ability);
		zoom.setLifePower(lifePower);
		return zoom;
	}

	@Bean
	public DCHero prototypeDCHero() {
		String name = env.getProperty("dchero.prototypeDCHero.name");
		int ability = Integer.parseInt(env.getProperty("dchero.prototypeDCHero.ability"));
		int lifePower = Integer.parseInt(env.getProperty("dccomics.lifepower.default-life-power"));
		PrototypeDCHero prototypeDCHero = new PrototypeDCHero("PrototypeDCHero");
		prototypeDCHero.setAbility(ability);
		prototypeDCHero.setLifePower(lifePower);
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
