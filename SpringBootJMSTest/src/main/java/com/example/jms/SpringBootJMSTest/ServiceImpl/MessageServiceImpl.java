package com.example.jms.SpringBootJMSTest.ServiceImpl;

import org.springframework.stereotype.Service;

import com.example.jms.SpringBootJMSTest.Repository.MessageRepository;
import com.example.jms.SpringBootJMSTest.Service.MessageService;
import com.example.jms.SpringBootJMSTest.dto.MainMessage;

@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository msgRepository;
	@Override
	public void saveJsonData(MainMessage messageObj) {
	msgRepository.save(messageObj);
	}

}
