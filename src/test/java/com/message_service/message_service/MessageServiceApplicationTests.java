package com.message_service.message_service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.Db;
import com.db.PostgreSQLJDBCConnection;
import com.google.gson.Gson;
import com.model.MessageModel;

@SpringBootTest
class MessageServiceApplicationTests {

	@Test
	void contextLoads() {
		Db db = Db.Db();
		List<MessageModel> d = db.getChat();
		String json = new Gson().toJson(d);
		System.out.print(json);
	}

}
