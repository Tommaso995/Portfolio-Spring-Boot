package com.portfolio.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.portfolio.dto.MessageDto;
import com.portfolio.entity.Message;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class MessageRepoImpl implements MessageRepo {
	
	@PersistenceContext
	EntityManager entity;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAllMessage() {

		Query q = entity.createQuery("SELECT u FROM Message u");
		
		return q.getResultList();
	}

	@Override
	@Transactional
	public Message insertMessage(MessageDto mess) {

		Message  e= new Message(mess);

		return entity.merge(e);
	}

	@Override
	@Transactional
	public Message deleteMessageByID(MessageDto mess) {

		Message r = entity.find(Message.class, mess.getId());
		
		entity.remove(mess);
		
		return r;
	}

	@Override
	@Transactional
	public Message updateMessageById(MessageDto mess) {

		Message e = new Message(mess);
		
		entity.remove(mess);
		entity.merge(mess);
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findMessageByTitolo(String titolo) {
		
		Query q = entity.createQuery("SELECT u FROM Message u WHERE u.titolo = :titolo");
		
		return q.setParameter("titolo", titolo).getResultList();
	}

}
