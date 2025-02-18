package com.douglassantana.task_service.resource.v1;

import com.douglassantana.task_service.domain.Task;
import com.douglassantana.task_service.repository.TaskRepository;
import com.douglassantana.task_service.resource.AbstractResource;
import com.douglassantana.task_service.resource.v1.api.TaskApi;
import lombok.AllArgsConstructor;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import static com.douglassantana.task_service.locale.ErrorMessageKeys.INTERNAL_SERVER;

@RestController
@AllArgsConstructor
public class TaskResource extends AbstractResource implements TaskApi {

    private TaskRepository taskRepository;

    @Override
    public MappingJacksonValue create(Task task) {

        Task taskModel = Optional.of(task)
                .map(this.taskRepository::save)
                .orElseThrow(() -> throwsException(INTERNAL_SERVER));

        return buildResponse(taskModel);
    }
}
