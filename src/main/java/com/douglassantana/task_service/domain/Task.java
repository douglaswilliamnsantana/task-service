package com.douglassantana.task_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

@Document(collation = "task")
@AllArgsConstructor
public @Data class Task implements Serializable {

    @Id
    private String id;

    @Field(name = "full_name")
    private String fullName;
}
