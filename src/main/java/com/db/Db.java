package com.db;

import java.util.List;

import com.model.MessageModel;

public class Db implements IDb {

    final IDb db = new PostgreSQLJDBCConnection();

    // Db tipinde static bir değişken
    private static Db db2;

    private Db() {
    }

    // (factory metod)
    public static Db Db() {
        if (db2 == null)
            db2 = new Db();
        return db2;
    }

    @Override
    public void sendMessage(String message) {
        db.sendMessage(message);
    }

    @Override
    public List<MessageModel> getChat() {
        return db.getChat();
    }

    @Override
    public MessageModel getMessage() {
        return db.getMessage();
    }

}
