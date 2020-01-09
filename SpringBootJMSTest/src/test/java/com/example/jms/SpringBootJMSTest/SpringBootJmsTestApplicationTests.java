package com.example.jms.SpringBootJMSTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jms.SpringBootJMSTest.Controller.ProducerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJmsTestApplicationTests {

	 @Autowired
	  private ProducerController sender;

	 

	  @Test
	  public void testSendMessage() throws Exception {
		  
	    sender.SendMessageText("GZXFRTJ675FTRHJJJ87zyxtBig Kumar           U000000000000017.450EURATCGB:20:TR234565,Zu8765Z,Bhj876t:32A:180123:36:12");
	  
	    
	    
	  }
}
