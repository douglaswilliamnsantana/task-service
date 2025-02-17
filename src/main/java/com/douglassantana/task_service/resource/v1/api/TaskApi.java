package com.douglassantana.task_service.resource.v1.api;

import com.douglassantana.task_service.domain.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1/task")
public interface TaskApi {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    default MappingJacksonValue create(@Validated @RequestBody Task task) {
        throw new RuntimeException("TODO");
    }
}