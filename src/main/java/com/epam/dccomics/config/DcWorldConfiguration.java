package com.epam.dccomics.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
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
	@Lazy(false)
	public DCWorld dcWorld() {
		return new DCWorld();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public Locale locale() {
		String lang = env.getProperty("locale.lang");
		String country = env.getProperty("locale.country");
		return new Locale(lang, country);
	}
}
