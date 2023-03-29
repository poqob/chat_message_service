package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLJDBCConnection {

    /*
     * beklentim: mesaj gönderimi, tüm mesajları çekmek, tarihe göre tek tek mesaj
     * çekmek.
     * 
     */

    public static void main(String[] args) {

        // Veritabanı URL'si
        String dbURL = "jdbc:postgresql://localhost:5432/kanal";

        // Veritabanı kullanıcı adı ve şifresi
        String user = "java";
        String password = "12345";

        try {
            // Veritabanına bağlantı oluştur
            Connection conn = DriverManager.getConnection(dbURL, user, password);

            // Bağlantının başarılı olduğunu kontrol et
            if (conn != null) {
                java.sql.Statement stmt = conn.createStatement();
                String sql = "select * from canal.getconservation()";

                System.out.println("Veritabanına başarıyla bağlandı.");
                ResultSet res = stmt.executeQuery(sql);

                MessageModel model = new MessageModel(res);

                System.out.print(model);
                // Statement nesnesini kapat
                stmt.close();

                // Veritabanı bağlantısını kapat
                conn.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}