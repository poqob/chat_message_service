package com.message_service.message_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.PostgreSQLJDBCConnection;

@SpringBootTest
class MessageServiceApplicationTests {

	@Test
	void contextLoads() {
		PostgreSQLJDBCConnection c = new PostgreSQLJDBCConnection();
		c.getChat();
	}

}
