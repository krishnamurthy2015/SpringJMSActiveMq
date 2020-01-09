package com.example.jms.SpringBootJMSTest.Consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import com.example.jms.SpringBootJMSTest.ParseMessage.ParseMessages;
import com.example.jms.SpringBootJMSTest.Service.MessageService;
import com.example.jms.SpringBootJMSTest.dto.MainMessage;
import com.google.gson.Gson;

@EnableJms
@Component
public class JMSConsumer implements MessageListener{
	private Logger log = LoggerFactory.getLogger(JMSConsumer.class);
	private Gson gson = new Gson();
	
	@Override
	public void onMessage(Message message) {
		try {
			
			if(message instanceof TextMessage) {
			TextMessage txt=(TextMessage)message;
			
			String msg= txt.getText();
			log.info("Received message:----->" +msg/*message.getBody(Object.class)*/);
			
			
			ParseMessages.saveJmsTextData(msg);
			
			
				
			}else if (message instanceof ObjectMessage) {
				MainMessage msg=(MainMessage)((ObjectMessage)message).getObject();
				
				String text=gson.toJson(msg);
				log.info("Object Message::"+text);
				
				 /* ObjectMapper oMapper = new ObjectMapper();
				  // object -> Map
			        Map<String, String> map = oMapper.convertValue(msg, Map.class);
                 log.info("ObjectMapper Message::"+map);*/
                 
                 
                 // Method to store the data into table 
                 
					ParseMessages.saveJmsJSONData(msg);
				
            
            }
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
