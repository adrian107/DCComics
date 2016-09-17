package com.epam.dccomics.domain;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;

import ch.qos.logback.classic.Logger;

public class DCWorld {

	private static Logger logger = (Logger) LoggerFactory.getLogger(DCWorld.class);

	// @Autowired
	// private MessageSource messageSource;

	@Autowired 
	private TheGreenArrow theGreenArrow;

	@Autowired
	private DCHero superman;

	@Autowired
	private Batman batman;

	@Autowired
	private PrototypeDCHero prototypeDCHero;

	@Autowired
	private PrototypeDCHero prototypeDCHero2;

	@Autowired
	private PrototypeDCHero prototypeDCHero3;

	@Autowired
	private Gun gun;

	@Autowired
	private Batmobil batmobil;

	@Autowired
	private LexLutor lexLutor;

	@Autowired
	private Zoom zoom;

	// @Autowired
	// @Qualifier("battle1")
	// private Battle battle1;

	@Autowired
	@Qualifier("battle2")
	private Battle battle2;

	@Autowired
	@Qualifier("battle3")
	private Battle battle3;

	@Autowired
	@Qualifier("battle4")
	private Battle battle4;

	// public DCWorld() {
	// english = Locale.ENGLISH;
	// }
	
	
	@Autowired
	Locale locale;
	
	@Autowired
	private MessageSource messageSource;
	
//	@Autowired
//	ApplicationContext ctx;
	
	@PostConstruct
	public void init() {
		logger.debug("------------------");
		logger.debug(theGreenArrow.toString());
		logger.debug(superman.toString());
		logger.debug(batman.toString());
		logger.debug(prototypeDCHero.toString());
		logger.debug(prototypeDCHero2.toString());
		logger.debug(prototypeDCHero3.toString());
		logger.debug(gun.toString());
		logger.debug(batmobil.toString());
		logger.debug(lexLutor.toString());
		logger.debug(zoom.toString());
		
	}

	public void dcWorld(final ApplicationContext ctx) {
		createDcHeroes(ctx);
	}

	public void createDcHeroes(final ApplicationContext ctx) {
		// logger.debug(messageSource.getMessage("battle.start.message", new
		// Object[] {}, english));


	}

	public void setArrow(TheGreenArrow arrow) {
		this.theGreenArrow = arrow;
	}

	public void setSuperman(Superman superman) {
		this.superman = superman;
	}

	public void setBatman(Batman batman) {
		this.batman = batman;
	}

	public void setPrototypeDCHero(PrototypeDCHero prototypeDCHero) {
		this.prototypeDCHero = prototypeDCHero;
	}

	public void setPrototypeDCHero2(PrototypeDCHero prototypeDCHero2) {
		this.prototypeDCHero2 = prototypeDCHero2;
	}

	public void setPrototypeDCHero3(PrototypeDCHero prototypeDCHero3) {
		this.prototypeDCHero3 = prototypeDCHero3;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public void setBatmobil(Batmobil batmobil) {
		this.batmobil = batmobil;
	}

	public void setLexLutor(LexLutor lexLutor) {
		this.lexLutor = lexLutor;
	}

	public void setZoom(Zoom zoom) {
		this.zoom = zoom;
	}

}
