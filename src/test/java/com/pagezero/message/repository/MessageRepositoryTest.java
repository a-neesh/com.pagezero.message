package com.pagezero.message.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pagezero.message.entity.Message;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageRepositoryTest {

	@Autowired
	private MessageRepository repo;
	
	@Test
	public void saveTest() {
		Message message = new Message();
		message.setCanvas("canvas");
		message.setRecipient("recipient");
		message.setTitle("title");
		
		Message result = repo.save(message);
		
		assertEquals(result.getCanvas(), "canvas");
		assertEquals(result.getRecipient(), "recipient");
		assertEquals(result.getTitle(), "title");
	}
}
