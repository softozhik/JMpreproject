package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

//        Util.printConnectInfo();

//        new UserServiceImpl().createUsersTable();
        new UserServiceImpl().saveUser("Alex", "Fbcuhjsdk", (byte) 32);
        new UserServiceImpl().saveUser("Soda", "Uggvrw", (byte) 32);
        new UserServiceImpl().saveUser("Frank", "Mashuy", (byte) 32);
        new UserServiceImpl().saveUser("Carn", "Tbfjsdk", (byte) 32);
//        new UserServiceImpl().removeUserById(2L);
        new UserServiceImpl().getAllUsers();
//        new UserServiceImpl().cleanUsersTable();
//        new UserServiceImpl().dropUsersTable();

    }

}
