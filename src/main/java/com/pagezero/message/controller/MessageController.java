package com.pagezero.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagezero.message.entity.Message;
import com.pagezero.message.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService service;
	
	@GetMapping("/")
	public String hello() {
		return "Message Service";
	}
	
	@GetMapping("/{user}/messages/outbox")
	public ResponseEntity<List<Message>> findBySender(
			@PathVariable @Valid String user) {
		return new ResponseEntity<List<Message>>(
				service.findBySender(user), HttpStatus.OK);
	}
	
	@GetMapping("/{user}/messages/inbox")
	public ResponseEntity<List<Message>> findByRecipient(
			@PathVariable @Valid String user) {
		return new ResponseEntity<List<Message>>(
				service.findByRecipient(user), HttpStatus.OK);
	}
	
	@PostMapping("/{user}/messages/create")
	public ResponseEntity<Message> save(
			@PathVariable String user, @RequestBody Message message) {
		return new ResponseEntity<Message>(
				service.save(user, message), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{user}/messages/{messageId}")
	public ResponseEntity<?> delete(
			@PathVariable String user, @PathVariable Long messageId) {
		service.delete(user, messageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
