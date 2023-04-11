package com.portfolio.entity;

import java.io.Serializable;

import com.portfolio.dto.MessageDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_message")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String titolo;
	String email;
	String messaggio;
	
	
	public Message(MessageDto dto) {
		
		this.id = dto.getId();
		this.titolo  = dto.getTitolo();
		this.email = dto.getEmail();
		this.messaggio = dto.getMessaggio();
	}

	public Message() {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getMail() {
		return email;
	}


	public void setMail(String mail) {
		this.email = mail;
	}


	public String getMessaggio() {
		return messaggio;
	}


	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
}
