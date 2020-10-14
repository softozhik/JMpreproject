package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.swing.plaf.IconUIResource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.disConnection;
import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `User` (" +
                    "id BIGINT(20) NOT NULL UNIQUE AUTO_INCREMENT KEY," +
                    "name VARCHAR(60)," +
                    "lastName VARCHAR(60)," +
                    "age TINYINT(3)" +
                    ")";
            st.executeUpdate(sql);
            conn.commit();
            System.out.println("таблица создана");
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                disConnection(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void dropUsersTable() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS `User`");
            conn.commit();
            //System.out.println("таблица удалена");
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                disConnection(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        Connection conn = null;
        try {
            conn = getConnection();
            String sql = "INSERT INTO `User`(name, lastName, age) VALUES (?, ?, ?);";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, lastName);
            st.setByte(3, age);
            st.executeUpdate();
            conn.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                disConnection(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {
        Connection conn = null;
        try {
            conn = getConnection();
            String sql = "DELETE FROM jmppdb.`User` WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
            conn.commit();
            //System.out.println("удалена запись по id " + id);
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                disConnection(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {

        List<User> usr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet out = st.executeQuery("SELECT * FROM `User`");
            while (out.next()) {
                //User currentUser = new User(out.getString("name").toString(), out.getString("lastName").toString(), Byte.valueOf(out.getString("age")));
                User currentUser = new User();
                currentUser.setId(Long.parseLong(out.getString("id")));
                currentUser.setName(out.getString("name"));
                currentUser.setLastName(out.getString("lastName"));
                currentUser.setAge(Byte.valueOf(out.getString("age")));
                usr.add(currentUser);
                System.out.println(currentUser.toString());
                //System.out.println(currentUser.getId());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                disConnection(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return usr;
    }

        public void cleanUsersTable () {
            Connection conn = null;
            try {
                conn = getConnection();
                Statement st = conn.createStatement();
                st.executeUpdate("DELETE FROM `User`");
                conn.commit();
                //System.out.println("таблица очищена");
            } catch (SQLException throwables) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            } finally {
                try {
                    disConnection(conn);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }