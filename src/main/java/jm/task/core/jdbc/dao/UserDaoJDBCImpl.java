package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() {
//CREATE TABLE IF EXIST `User`;
//        CREATE TABLE IF EXIST `jmppdb`.`User` (
//  `id` BIGINT(64) NOT NULL,
//  `name` VARCHAR(60) NULL,
//  `lastName` VARCHAR(60) NULL,
//  `age` TINYINT(3) NOT NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
        try {
            Connection conn = getConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
//DROP TABLE IF EXIST `User`;
        try {
            Connection conn = getConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        //insert into User (name, lastName, age) values (name, lastName, age);

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        //UserDaoJDBCImpl conn = new UserDaoJDBCImpl();
        //"SELECT * FROM jmppdb.User"
        try {
            Connection conn = getConnection();
            //Map<String, Class<?>> map; map = conn.getTypeMap();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void cleanUsersTable() {
        //"DELETE FROM User"
    }

    public static Connection getConnection() throws SQLException {
        String dburl = "jdbc:mysql://localhost:3306/jmppdb";
        String dbuser = "jm";
        String dbpassword = "123456";

        Connection dbconnect = DriverManager.getConnection(dburl, dbuser, dbpassword);
        System.out.println("соединились");
        return dbconnect;

    }
}