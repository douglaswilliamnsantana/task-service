package com.douglassantana.task_service.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
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
