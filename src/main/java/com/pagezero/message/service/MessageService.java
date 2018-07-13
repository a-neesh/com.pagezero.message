package com.pagezero.message.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagezero.message.audit.AuditorAwareImpl;
import com.pagezero.message.entity.Message;
import com.pagezero.message.exception.ResourceNotFoundException;
import com.pagezero.message.exception.UnauthenticatedUserPostRequestingException;
import com.pagezero.message.repository.MessageRepository;

@Service
public class MessageService {

	private MessageRepository repo;
	
	@Autowired
	public MessageService(MessageRepository repo) {
		this.repo = repo;
	}
	
	public Message save(String user, Message message) {
		if (!isAuthenticatedUser(user)) {
			//Add Logger with try-catch and remove throws
			//Logout the user
			//send notification to reciever and update messages
		}
		return repo.save(message);
	}
	
	public List<Message> findByRecipient(String recipient) {
		if (!isAuthenticatedUser(recipient)) {
			//Add Logger with try-catch
			//Logout the user
		}
		return repo.findByRecipient(recipient);
	}
	
	public List<Message> findBySender(String sender) {
		if (!isAuthenticatedUser(sender)) {
			//Add Logger with try-catch
			//Logout the user
		}
		return repo.findBySender(sender);
	}
	
	public void delete(String user, Long message_id) {
		if (!isAuthenticatedUser(user)) {
			//Add Logger with try-catch
			//Logout the user
		}
		if(repo.existsById(message_id)) {
			Message message = repo.findByMessageId(message_id);
			repo.delete(message);
		} else
			throw new ResourceNotFoundException("Message ID " + message_id + "not found");
	}
	
	public Boolean isAuthenticatedUser(String user) {
		Optional<String> authenticatedUser = new AuditorAwareImpl().getCurrentAuditor();
		if(authenticatedUser.equals(Optional.of(user)))
			return true;
		else
			throw new UnauthenticatedUserPostRequestingException(
					"User " + user 
					+ " does not match the authenticated user "
					+ authenticatedUser);
	}
}
