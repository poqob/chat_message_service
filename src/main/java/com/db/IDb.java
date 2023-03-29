package com.db;

import java.util.List;

import com.model.MessageModel;

public interface IDb {
    public void sendMessage(String message);

    public List<MessageModel> getChat();

    public MessageModel getMessage();
}
