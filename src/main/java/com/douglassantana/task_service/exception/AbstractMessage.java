package com.douglassantana.task_service.exception;

import com.douglassantana.task_service.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractMessage {
	
	@Autowired
	public MessageService messageService;
    
    public BusinessException throwsException(String message) {
        throw new BusinessException(buildMessage(message, ""));
    }
	
	private String buildMessage(String key, String... args) {
        return this.messageService.getMessage(key, args);
    }
}
