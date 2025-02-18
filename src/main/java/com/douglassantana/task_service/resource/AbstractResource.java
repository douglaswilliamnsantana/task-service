package com.douglassantana.task_service.resource;

import com.douglassantana.task_service.exception.AbstractMessage;
import org.springframework.http.converter.json.MappingJacksonValue;

public class AbstractResource extends AbstractMessage {

	protected MappingJacksonValue buildResponse(Object resource) {
        return new MappingJacksonValue(resource);
	}
}
