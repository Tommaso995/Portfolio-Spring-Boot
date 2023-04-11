package com.portfolio.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.portfolio.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class UserRepoImpl implements UserRepo{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {

		Query q = entityManager.createQuery("SELECT u FROM User u");

		return q.getResultList();
	}

	@Override
	@Transactional
	public User insertUser(User u) {

		User user = entityManager.merge(u);

		return user;
	}

	@Override
	@Transactional
	public User updateUser(User u) {
		
		
		User user = entityManager.find(User.class, u.getId());
		entityManager.remove(user);
		entityManager.merge(u);

		return u;
	}

	@Override
	@Transactional
	public User deleteUser(User u) {
		
		User user = entityManager.find(User.class, u.getId());
		
		entityManager.remove(user);
		
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserFindByName(String email) {

		Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");

		return q.setParameter("email", email).getResultList();
	}

}
