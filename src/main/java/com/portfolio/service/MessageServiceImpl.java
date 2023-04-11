package com.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dto.MessageDto;
import com.portfolio.entity.Message;
import com.portfolio.repository.MessageRepo;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageRepo repo;

	@Override
	public List<MessageDto> getAllMessage() {

		List<Message> list = repo.getAllMessage();
		
		List<MessageDto> dto = list.stream().map(entity -> new MessageDto(entity)).collect(Collectors.toList());

		return dto;
	}

	@Override
	public MessageDto insertMessage(MessageDto mess) {

		Message entity = repo.insertMessage(mess);
		
		MessageDto dto = new MessageDto(entity);

		return dto;
	}

	@Override
	public MessageDto deleteMessageById(MessageDto mess) {

		Message entity = repo.deleteMessageByID(mess);
		
		MessageDto dto = new MessageDto(entity);
		
		return dto;
	}

	@Override
	public MessageDto updateMessage(MessageDto mess) {

		Message entity = repo.updateMessageById(mess);
		
		MessageDto dto = new MessageDto(entity);

		return dto;
	}

	@Override
	public List<MessageDto> findMessageByTitolo(String mess) {

		List<Message> entity = repo.findMessageByTitolo(mess);
		
		List<MessageDto> dto = entity.stream().map(e -> new MessageDto(e)).collect(Collectors.toList());
		
		return dto;
	}

}
