package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.MessageDto;
import com.portfolio.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService message$;
	
	@GetMapping
	public ResponseEntity<List<MessageDto>> getAllMessage(){
		
		List<MessageDto> list = message$.getAllMessage();
		
		return new ResponseEntity<List<MessageDto>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<MessageDto> insertMessage(@RequestBody MessageDto mess){
		
		MessageDto dto = message$.insertMessage(mess);
		
		return new ResponseEntity<MessageDto>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<MessageDto> deleteMessage(@RequestBody MessageDto mess){
		MessageDto dto = message$.deleteMessageById(mess);
		
		return new ResponseEntity<MessageDto>(dto, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<MessageDto> updateMessage(@RequestBody MessageDto mess){
		
		MessageDto dto = message$.updateMessage(mess);
		
		return new ResponseEntity<MessageDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{titolo}")
	public ResponseEntity<List<MessageDto>> findMessageByTitolo(@PathVariable String titolo){
		
		List<MessageDto> list = message$.findMessageByTitolo(titolo);
		
		return new ResponseEntity<List<MessageDto>>(list, HttpStatus.OK);
	}
	
}
