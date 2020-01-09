package com.example.jms.SpringBootJMSTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jms.SpringBootJMSTest.dto.MainMessage;

@RestController
public class ProducerController {
	@Value("${myqueue}")
	  private String queue;
	@Autowired
	private JmsTemplate jsmTemplate;
	
	@RequestMapping(path="/send/{message}",method = RequestMethod.POST)	
	public void SendMessageText(@PathVariable String message) {
		try {
			
		jsmTemplate.convertAndSend(queue, message);
		}catch(JmsException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(path="/ProduceMessages", method = RequestMethod.POST, consumes = {"application/json"})
	public void SendMessage(@RequestBody MainMessage message) {
		try {
			
		jsmTemplate.convertAndSend(queue, message);
		}catch(JmsException e) {
			e.printStackTrace();
		}
		
	}

}
