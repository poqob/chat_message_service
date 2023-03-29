package com.db;

import java.util.List;

public interface Db {
    public void sendMessage(String message);

    public List<MessageModel> getChat();

    public MessageModel getMessage();
}
