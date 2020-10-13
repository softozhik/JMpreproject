package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;



public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        //new UserServiceImpl().saveUser("Petr", "Bbcuhsd", (byte) 12);
        new UserServiceImpl().getAllUsers();

    }
}
