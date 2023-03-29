package com.db;

import java.sql.Date;
import java.sql.ResultSet;

public class MessageModel {
    int id;
    String username;
    String message;
    Date date;
    String info;

    MessageModel(int id, String username, String message, Date date, String info) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.date = date;
        this.info = info;
    }

    MessageModel(ResultSet res) {
        try {
            while (res.next()) {
                id = res.getInt("id_");
                username = res.getString("username_");
                message = res.getString("message_");
                date = res.getDate("date_");
                info = res.getString("info_");
            }
            res.close();
        } catch (Exception e) {
        }
    }

    @Override
    public String toString() {
        String string = String.format("id:%d\nusername:%s\nmessage:%s\ndate:%s\ninfo:%s\n", id, username, message,
                date.toString(), info);
        return string;
    }
}
