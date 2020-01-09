package com.example.jms.SpringBootJMSTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jms.SpringBootJMSTest.dto.MainMessage;

public interface MessageRepository extends JpaRepository<MainMessage, String> {

}
