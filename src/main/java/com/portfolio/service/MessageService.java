package com.portfolio.service;

import java.util.List;

import com.portfolio.dto.MessageDto;
import com.portfolio.entity.Message;

public interface MessageService {
	
	List<MessageDto> getAllMessage();

	MessageDto insertMessage(MessageDto mess);
	
	MessageDto deleteMessageById(MessageDto mess);
	
	MessageDto updateMessage(MessageDto mess);
	
	List<MessageDto> findMessageByTitolo(String mess);
}
