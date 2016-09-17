package com.epam.dccomics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.epam.dccomics.domain.DCWorld;

@Configuration
@Lazy
@ComponentScan(basePackages = { "com.epam.dccomics" })
@Import({ DcBattlesConfiguration.class })
@PropertySource("classpath:dccomics.properties")
public class DcWorldConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public DCWorld dcWorld() {
		return new DCWorld();
	}

	
	
}
