package com.epam.dccomics.domain;

import java.applet.AppletContext;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.classic.Logger;

public class DCWorld {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(DCWorld.class);

	public DCWorld() {
		
	}

	@PostConstruct
	public void init() {
		logger.debug("DC World created");
		logger.debug("------------------");
	}

	public void dCWorld(final ApplicationContext ctx) {
		createDcHeroes(ctx);
		createSomeBattle();
	}
	
	
	public void createDcHeroes(final ApplicationContext ctx) {
		TheGreenArrow arrow = ctx.getBean("theGreenArrow", TheGreenArrow.class);
		Superman superman = ctx.getBean("superman", Superman.class);
		Batman batman = ctx.getBean("batman", Batman.class);
		PrototypeDCHero prototypeDCHero = ctx.getBean("prototypeDCHero", PrototypeDCHero.class);
		PrototypeDCHero prototypeDCHero2 = ctx.getBean("prototypeDCHero", PrototypeDCHero.class);
		PrototypeDCHero prototypeDCHero3 = ctx.getBean("prototypeDCHero", PrototypeDCHero.class);
		Gun gun = ctx.getBean("batmobilGun", Gun.class);
		Batmobil batmobil = ctx.getBean("batmobil", Batmobil.class);
		LexLutor lexLutor = ctx.getBean("lexLutor", LexLutor.class);
		Zoom zoom = ctx.getBean("zoom", Zoom.class);
		
		logger.debug("------------------");
		logger.debug(arrow.toString());
		logger.debug(superman.toString());
		logger.debug(batman.toString());
		logger.debug(prototypeDCHero.toString());
		logger.debug(prototypeDCHero2.toString());
		logger.debug(prototypeDCHero3.toString());
		logger.debug(gun.toString());
		logger.debug(batmobil.toString());
		logger.debug(lexLutor.toString());
		logger.debug(zoom.toString());
		
		
		FightingOpponentPair supermanAgainstBatman = ctx.getBean("supermanAgainstBatman", FightingOpponentPair.class);
		FightingOpponentPair supermanAgainstLexLutor = ctx.getBean("supermanAgainstLexLutor", FightingOpponentPair.class);
		FightingOpponentPair theGreenArrowAgainstZoom = ctx.getBean("theGreenArrowAgainstZoom", FightingOpponentPair.class);
		
		
		// The following row cause IllegalArgumentException, because two "GoodGuy" can't fight against each other
//		Battle battle1 = ctx.getBean("battle1", Battle.class);
		Battle battle2 = ctx.getBean("battle2", Battle.class);
		Battle battle3 = ctx.getBean("battle3", Battle.class);

		
		
	}
	
	private void createSomeBattle() {
		
	}

	
}
