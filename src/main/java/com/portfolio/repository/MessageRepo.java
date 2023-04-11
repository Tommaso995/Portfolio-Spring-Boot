package com.portfolio.repository;

import java.util.List;

import com.portfolio.dto.MessageDto;
import com.portfolio.entity.Message;

public interface MessageRepo {

	
	List<Message> getAllMessage();
	
	Message insertMessage(MessageDto mess);
	
	Message deleteMessageByID(MessageDto mess);
	
	Message updateMessageById(MessageDto mess);
	
	List<Message> findMessageByTitolo(String titolo);


	
}
