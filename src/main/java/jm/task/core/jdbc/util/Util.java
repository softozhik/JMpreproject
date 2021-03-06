package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public static Connection getConnection() throws SQLException {
        final String dburl = "jdbc:mysql://localhost:3306/jmppdb";
        final String dbuser = "jm";
        final String dbpassword = "123456";

        Connection dbconnect = DriverManager.getConnection(dburl, dbuser, dbpassword);
        //System.out.println("соединение: " + !dbconnect.isClosed());
        dbconnect.setAutoCommit(false);
        return dbconnect;
    }

    public static void disConnection(Connection dbconnect) throws SQLException {
        dbconnect.close();
        //System.out.println("отключено: " + dbconnect.isClosed());
    }
    }
