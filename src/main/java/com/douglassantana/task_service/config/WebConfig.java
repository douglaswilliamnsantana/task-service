package com.douglassantana.task_service.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	* In contrast to ResourceBundleMessageSource, this class supports reloading of properties files through the "cacheSeconds"
	* setting, and also through programmatically clearing the properties cache.
	* Since application servers do typically cache all files loaded from the classpath, it is necessary to store resources
	* somewhere else (for example, in the "WEB-INF" directory of a web app).
	* Otherwise, changes of files in the classpath are not reflected in the application.
	*
	* https://docs.spring.io/spring-framework/docs/1.1.3/javadoc-api/org/springframework/context/support/ReloadableResourceBundleMessageSource.html
	* */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/errors");
		messageSource.setDefaultEncoding("ISO-8859-1");
		messageSource.setCacheSeconds(Integer.parseInt(System.getProperty("cache-seconds", "-1")));
		return messageSource;
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
	    return new Jackson2ObjectMapperBuilderCustomizer() {
	        @Override
	        public void customize(Jackson2ObjectMapperBuilder builder) {
	            builder.dateFormat(new StdDateFormat());  
	        }           
	    };
	}
}
