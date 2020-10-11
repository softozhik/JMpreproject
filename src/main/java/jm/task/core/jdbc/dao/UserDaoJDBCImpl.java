package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
        String dburl = "jdbc:mysql://localhost:3306/jmppdb";
        String dbuser = "jm";
        String dbpassword = "123456";

            try {
                Connection dbconnect = DriverManager.getConnection(dburl, dbuser, dbpassword);
                System.out.println("connect");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }

    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
