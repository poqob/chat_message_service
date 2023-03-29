package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.MessageModel;

public class PostgreSQLJDBCConnection implements IDb {

    /*
     * beklentim: mesaj gönderimi, tüm mesajları çekmek, tarihe göre tek tek mesaj
     * çekmek.
     * 
     */
    String dbURL = "jdbc:postgresql://localhost:5432/kanal";

    // Veritabanı kullanıcı adı ve şifresi
    String user = "java";
    String password = "12345";
    Connection conn;

    boolean isConnected() {

        boolean status = false;

        try {
            status = conn.isValid(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }

    public PostgreSQLJDBCConnection() {
        // Veritabanı URL'si
        try {
            // Veritabanına bağlantı oluştur
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MessageModel> getChat() {
        List<MessageModel> list = new ArrayList<MessageModel>();

        try {

            if (conn != null) {
                java.sql.Statement stmt = conn.createStatement();
                String sql = "select * from canal.getconservation()";

                ResultSet res = stmt.executeQuery(sql);
                MessageModel model;
                while (res.next()) {
                    model = new MessageModel(res.getInt("id_"), res.getString("username_"),
                            res.getString("message_"),
                            res.getDate("date_"), res.getString("info_"));
                    list.add(model);
                }
                res.close();

                // Statement nesnesini kapat
                stmt.close();

                // Veritabanı bağlantısını kapat
                conn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public MessageModel getMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}