package com.model;

import java.sql.Date;

public class MessageModel {
    int id;
    String username;
    String message;
    Date date;
    String info;

    public MessageModel(int id, String username, String message, Date date, String info) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.date = date;
        this.info = info;
    }

    @Override
    public String toString() {
        String string = String.format("id:%d\nusername:%s\nmessage:%s\ndate:%s\ninfo:%s\n", id, username, message,
                date.toString(), info);
        return string;
    }
}
