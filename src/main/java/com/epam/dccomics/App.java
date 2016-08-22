package com.epam.dccomics;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.dccomics.domain.Arrow;
import com.epam.dccomics.domain.Batman;
import com.epam.dccomics.domain.Batmobil;
import com.epam.dccomics.domain.Gun;
import com.epam.dccomics.domain.PrototypeDCHero;
import com.epam.dccomics.domain.Superman;

import ch.qos.logback.classic.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = (Logger) LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();

		System.out.println(
				"****************************************************************************************************************\n\n");
		Arrow arrow = ctx.getBean("arrow", Arrow.class);
		Superman superman = ctx.getBean("superman", Superman.class);
		Batman batman = ctx.getBean("batman", Batman.class);
		PrototypeDCHero prototypeDCHero = ctx.getBean("prototypeDCHero", PrototypeDCHero.class);
		Gun gun = ctx.getBean("batmobilGun", Gun.class);
		Batmobil batmobil = ctx.getBean("batmobil", Batmobil.class);

		logger.debug(arrow.toString());
		logger.debug(superman.toString());
		logger.debug(batman.toString());
		logger.debug(prototypeDCHero.toString());
		logger.debug(gun.toString());
		logger.debug(batmobil.toString());

		
		
		
		System.out.println(
				"\n\n****************************************************************************************************************");
	}

}
