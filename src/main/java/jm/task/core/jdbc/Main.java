package jm.task.core.jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static jm.task.core.jdbc.dao.UserDaoJDBCImpl.getConnection;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        try {
            Connection conn = getConnection();

            Statement st = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `User` (" +
                    "id BIGINT(20) NOT NULL UNIQUE AUTO_INCREMENT KEY," +
                    "name VARCHAR(60)," +
                    "lastName VARCHAR(60)," +
                    "age TINYINT(3)" +
                    ")";
            st.executeUpdate(sql);
//            //st.executeUpdate("CREATE TABLE IF NOT EXISTS `User` (id INT(20) NOT NULL UNIQUE AUTO_INCREMENT KEY, name VARCHAR(60), lastName VARCHAR(60), age TINYINT(3))");
//            st.executeUpdate("DROP TABLE IF EXISTS `User`");
            conn.close();
            System.out.println(conn.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
}
