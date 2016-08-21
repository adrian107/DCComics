package com.epam.dccomics;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.dccomics.domain.Arrow;
import com.epam.dccomics.domain.Batman;
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
	
		System.out.println("****************************************************************************************************************\n\n");
		Arrow arrow = ctx.getBean("arrow", Arrow.class);
		Superman superman = ctx.getBean("superman", Superman.class);
		Batman batman = ctx.getBean("batman", Batman.class);
		
		
		logger.debug(arrow.toString());
		logger.debug(superman.toString());
		logger.debug(batman.toString());
		
//		System.out.println(arrow);
//		System.out.println(superman);
//		System.out.println(batman);
		
		
		
		
		
		System.out.println("\n\n****************************************************************************************************************");
	}

}
