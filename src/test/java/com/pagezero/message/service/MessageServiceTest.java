package com.pagezero.message.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.pagezero.message.entity.Message;
import com.pagezero.message.repository.MessageRepository;

public class MessageServiceTest {

	private MessageService service;
	private MessageRepository repo;
	
	@Before
	public void prepare() {
		repo = mock(MessageRepository.class);
		service = new MessageService(repo);
	}
	
	@Test
	public void saveTest() {
		Message message = new Message();
		message.setCanvas("canvas");
		message.setRecipient("recipient");
		message.setTitle("title");
		when(repo.save(message)).thenReturn(message);
		assertEquals(service.save("aneesh", message).getCanvas(), "canvas");
	}
}
