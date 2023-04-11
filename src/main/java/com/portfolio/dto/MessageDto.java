package com.portfolio.dto;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.portfolio.entity.Message;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@EntityScan
@Table(name = "message")
public class MessageDto {

	@Id
	@Column(name = "id_message")
	int Id;
	String titolo;
	String email;
	String messaggio;
	
	public MessageDto (Message mess){
		this.Id = mess.getId();
		this.titolo= mess.getTitolo();
		this.email = mess.getMail();
		this.messaggio = mess.getMessaggio();
	}
	
	public MessageDto() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
}
