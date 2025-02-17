package com.douglassantana.task_service.repository;

import com.douglassantana.task_service.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> { }
