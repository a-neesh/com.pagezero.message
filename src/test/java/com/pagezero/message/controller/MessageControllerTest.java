package com.pagezero.message.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pagezero.message.entity.Message;
import com.pagezero.message.service.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MessageService service;
	
	@Test
	public void saveTest() throws Exception {
		Message message = new Message();
		message.setCanvas("canvas");
		message.setRecipient("recipient");
		message.setTitle("title");
		when(service.save("user", message)).thenReturn(message);
//		given(service.save("user", message)).willReturn(message);
		mvc.perform(post("/aneesh/messages/create")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.canvas", is("canvas")))
				.andExpect(jsonPath("$.recipient", is("recipient")))
				.andExpect(jsonPath("$.title", is("title")));
	}
}
