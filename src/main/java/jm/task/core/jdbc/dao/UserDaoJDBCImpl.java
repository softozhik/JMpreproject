package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `User` (" +
                    "id BIGINT(20) NOT NULL UNIQUE AUTO_INCREMENT KEY," +
                    "name VARCHAR(60)," +
                    "lastName VARCHAR(60)," +
                    "age TINYINT(3)" +
                    ")";
            st.executeUpdate(sql);
            System.out.println("таблица создана");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS `User`");
            System.out.println("таблица удалена");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO `User`(name, lastName, age) VALUES (?, ?, ?);";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, lastName);
            st.setByte(3, age);
            st.executeUpdate();
            System.out.println("User с именем - " + name + "дабавлен в базу данных");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM jmppdb.`User` WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
            System.out.println("удалена запись по id " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> usr = new LinkedList<>();
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet out = st.executeQuery("SELECT * FROM `User`");
            System.out.println(out);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return null;
        }

        public void cleanUsersTable () {
            try (Connection conn = getConnection()) {
                Statement st = conn.createStatement();
                st.executeUpdate("DELETE FROM `User`");
                System.out.println("таблица очищена");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }