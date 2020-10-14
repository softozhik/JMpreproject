package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;




public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        new UserServiceImpl().createUsersTable();
        new UserServiceImpl().saveUser("Alex", "Fbcuhjsdk", (byte) 32);
        new UserServiceImpl().saveUser("Soda", "Uggvrw", (byte) 32);
        new UserServiceImpl().saveUser("Frank", "Mashuy", (byte) 32);
        new UserServiceImpl().saveUser("Carn", "Tbfjsdk", (byte) 32);
        new UserServiceImpl().removeUserById(1);
        new UserServiceImpl().getAllUsers();
        new UserServiceImpl().cleanUsersTable();
        new UserServiceImpl().dropUsersTable();


    }
}
