package com.message_service.message_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.Db;
import com.google.gson.Gson;
import com.model.MessageModel;

@RestController
@RequestMapping(value = { "/conservation", "/last" })
public class Service {
    List<MessageModel> list;

    @GetMapping(name = "/conservation")
    public String getAllMessages() {
        if (list == null)
            list = Db.Db().getChat();
        String json = new Gson().toJson(list);
        return json;
    }

    @GetMapping(name = "/last")
    public String getMessagee() {
        return "last message";
    }
}
