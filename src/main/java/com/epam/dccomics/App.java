package com.epam.dccomics;

import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.dccomics.domain.TheGreenArrow;
import com.epam.dccomics.config.DcWorldConfiguration;
import com.epam.dccomics.domain.Batman;
import com.epam.dccomics.domain.Batmobil;
import com.epam.dccomics.domain.DCWorld;
import com.epam.dccomics.domain.Gun;
import com.epam.dccomics.domain.LexLutor;
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

//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_dc_world.xml");
//		ctx.registerShutdownHook();
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(DcWorldConfiguration.class);
		ctx.registerShutdownHook();
				
		DCWorld dcWorld = ctx.getBean("dcWorld", DCWorld.class);
		dcWorld.dcWorld(ctx);
	}

}
