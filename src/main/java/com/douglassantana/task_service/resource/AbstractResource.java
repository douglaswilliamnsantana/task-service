package com.douglassantana.task_service.resource;

import org.springframework.http.converter.json.MappingJacksonValue;

public class AbstractResource {

	protected MappingJacksonValue buildResponse(Object resource) {
        return new MappingJacksonValue(resource);
	}
}
