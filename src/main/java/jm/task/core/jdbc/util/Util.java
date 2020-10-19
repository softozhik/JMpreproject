package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

public class Util {
    // реализуйте настройку соеденения с БД
    private static ServiceRegistry sr;
    private static final String dburl = "jdbc:mysql://localhost:3306/jmppdb";
    private static final String dbuser = "jm";
    private static final String dbpassword = "123456";
    public static Connection getConnection() throws SQLException {

        Connection dbconnect = DriverManager.getConnection(dburl, dbuser, dbpassword);
        //System.out.println("соединение: " + !dbconnect.isClosed());
        dbconnect.setAutoCommit(false);
        return dbconnect;
    }

    public static void disConnection(Connection dbconnect) throws SQLException {
        dbconnect.close();
        //System.out.println("отключено: " + dbconnect.isClosed());
    }

    //hibernate
    public static SessionFactory hiberFactory() {
        Configuration config = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
//                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.connection.url", dburl)
                .setProperty("hibernate.connection.username", dbuser)
                .setProperty("hibernate.connection.password", dbpassword)
                .addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder().enableAutoClose();
        sb.applySettings(config.getProperties());
        sr = sb.build();
        return config.buildSessionFactory(sr);
    }

    public static void disHiberFactory () {
        StandardServiceRegistryBuilder.destroy(sr);
    }
/*

    public static void printConnectInfo() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) hiberFactory();
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    }
