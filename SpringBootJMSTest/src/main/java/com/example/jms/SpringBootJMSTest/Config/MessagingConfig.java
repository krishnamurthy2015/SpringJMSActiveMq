package com.example.jms.SpringBootJMSTest.Config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.example.jms.SpringBootJMSTest.Consumer.JMSConsumer;

@Configuration
public class MessagingConfig {
	@Autowired
	private ConnectionFactory connectionFactory;
	 @Value("${myqueue}")
	  private String queue;
	 
	 @Bean
	    public DefaultMessageListenerContainer messageListener() {
	        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
	        container.setConnectionFactory(this.connectionFactory);
	        container.setDestinationName(queue);
	        container.setMessageListener(new JMSConsumer());
	        return container;
	    }
	 
	/* @Bean
	 public ActiveMQConnectionFactory activeMQConnectionFactory() {
	     ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("your broker URL");
	     factory.setTrustedPackages(Arrays.asList("com.my.package"));
	     return factory;
	 }*/
}
